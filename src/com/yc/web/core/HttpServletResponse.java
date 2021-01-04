package com.yc.web.core;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.yc.tomcat.core.ConstantInfo;
import com.yc.tomcat.util.StringUtil;

public class HttpServletResponse implements ServletResponse{

	private OutputStream os=null;
//	private String basePath=ConstantInfo.BASE_PATH;
	
	public HttpServletResponse() {
		this.os=os;
	}
	public HttpServletResponse(OutputStream os2) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void sendRedirect(String url) {
		if(StringUtil.checkNull(url)) {
			
		}
		//读取指定的资源文件
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
