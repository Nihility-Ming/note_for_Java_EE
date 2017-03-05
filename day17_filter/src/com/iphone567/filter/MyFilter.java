package com.iphone567.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	public MyFilter() {
	}

	// 服务器启动时，触发
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println(getClass().getSimpleName() + " init");
	}

	// 用户访问时，触发
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(getClass().getSimpleName() + "拦截");
		chain.doFilter(request, response); // 放行
		System.out.println(getClass().getSimpleName() + "放行后");
	}

	// 服务器卸载时，触发
	@Override
	public void destroy() {
		System.out.println(getClass().getSimpleName() + " destroy");
	}
}
