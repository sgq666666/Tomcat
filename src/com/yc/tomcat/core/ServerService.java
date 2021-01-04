package com.yc.tomcat.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;

import com.yc.web.core.HttpServletRequest;
import com.yc.web.core.HttpServletResponse;
import com.yc.web.core.ServletRequest;
import com.yc.web.core.ServletResponse;

/**
 * 负责处理请求的信息的类
 * company 源辰信息
 * @author 沈观清
 * @data 2021年1月2日
 * Email 1198865589@qq.com
 */
public class ServerService implements Runnable{
	private Socket sk;
	private InputStream is;
	private OutputStream os;
	
	public ServerService(Socket sk) {
		this.sk=sk;
	}

	@Override
	public void run() {
		try {
			this.is=sk.getInputStream();
			this.os=sk.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//解析请求头信息
		ServletRequest request=new HttpServletRequest(is);
		
		String url=request.getUrl();
		
		try {
			url=URLDecoder.decode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		ServletResponse response=new HttpServletResponse(os);
		response.sendRedirect(url);
	}

}
