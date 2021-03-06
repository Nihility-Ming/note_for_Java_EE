package com.iphone567.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterConfig implements Filter {

	private FilterConfig filterConfig;

	public MyFilterConfig() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String encoding = filterConfig.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		System.out.println("用拦截器 设置默认编码方式");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
	

}
