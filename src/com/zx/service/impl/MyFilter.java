package com.zx.service.impl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//过滤请求外通过通配符可以保护页面，图片，文件，还可以进行加密、安全过滤、权限管理等等
public class MyFilter implements Filter {

	private String encoding;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(encoding);  
        response.setCharacterEncoding(encoding);  
        chain.doFilter(request, response);  
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("========" + config.getInitParameter("encoding") + "========");  
        encoding = config.getInitParameter("encoding");
	}

}
