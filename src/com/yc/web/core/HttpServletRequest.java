package com.yc.web.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.tomcat.util.StringUtil;

public class HttpServletRequest implements ServletRequest{

	private String method;
	private String url;
	private InputStream is;
	private BufferedReader reader;
	private Map<String, String> parameter=new HashMap<String, String>();
	private String protocalVersion;
	
	public HttpServletRequest(InputStream is) {
		this.is=is;
		parse();
	}
	@Override
	public void parse() {
		try {
			reader=new BufferedReader(new InputStreamReader(is));
			List<String> headers=new ArrayList<String>();
			String line=null;
			while((line=reader.readLine())!=null && !"".equals(line)) {
				headers.add(line);
			}
		//	headers.forEach(System.out::println);
			parseFirseLine(headers.get(0));//解析起始行
			
			parseParameter(headers);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 解析参数
	 * @param headers
	 */
	private void parseParameter(List<String> headers) {
		// 如果是GET请求，那么参数只会在起始行中有
		
		//如果是post请求，那么要获取头部字段中的Context-Length Context-Type
		
	}
	
	/**
	 * 解析起始行
	 * @param string
	 */
	private void parseFirseLine(String str) {
		if(StringUtil.checkNull(str)) {
			return;
		}
		
		String[] arrs=str.split(" ");
		this.method=arrs[0];//请求方式
		if(arrs[1].contains("?")) {//说明有请求参数
			this.url=arrs[1].substring(0, arrs[1].indexOf("?"));
		}else {
			this.url=arrs[1];
		}
		this.protocalVersion=arrs[2];
		
	}
	@Override
	public String getParameter(String key) {
		return this.parameter.getOrDefault(key, null);
	}

	@Override
	public String getMethod() {
		return this.method;
	}

	@Override
	public String getUrl() {
		return this.url;
	}
	
	public String getProtocalVersion() {
		return protocalVersion;
	}

	
}
