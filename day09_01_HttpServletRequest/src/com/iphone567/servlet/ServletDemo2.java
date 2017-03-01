package com.iphone567.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 获取 指定请求头 和 打印所有请求头
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		switch (request.getParameter("test")) {
		case "1":
			test1(request, response);
			break;
		case "2":
			test2(request, response);
			break;
		default:
			test1(request, response);
			break;
		}
	}

	// 获取"User-Agent"请求头，并且判断用户使用哪种浏览器
	private void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String header = request.getHeader("User-Agent").toLowerCase();
		response.getWriter().println("<p>" + header + "</p>");
		if (header.contains("msie")) {
			response.getWriter().println("<h2>您使用的是IE浏览器</h2>");
		} else if (header.contains("chrome")) {
			response.getWriter().println("<h2>您使用的是谷歌浏览器</h2>");
		} else if (header.contains("firefox")) {
			response.getWriter().println("<h2>您使用的是火狐浏览器</h2>");
		} else if (header.contains("safari")) {
			response.getWriter().println("<h2>您使用的是Safari浏览器</h2>");
		} else {
			response.getWriter().println("<h2>您使用的是未知浏览器</h2>");
		}
	}

	// 打印所有请求头
	private void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String ele = headerNames.nextElement();
			response.getWriter().println(ele + " : " + request.getHeader(ele));
		}
	}

}
