package com.iphone567.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter2 implements Filter {

	public MyFilter2() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(getClass().getSimpleName() + "拦截");
		chain.doFilter(request, response); // 放行
		System.out.println(getClass().getSimpleName() + "放行后");
	}

	@Override
	public void destroy() {
	}


}
