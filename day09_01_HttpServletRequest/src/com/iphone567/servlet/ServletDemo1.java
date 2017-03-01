package com.iphone567.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// HttpServletRequest request常用方法
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// test:
		// http://localhost:8888/day09_01_HttpServletRequest/demo1?name=username&passsword=password
		System.out.println(request.getRequestURL()); // http://localhost:8888/day09_01_HttpServletRequest/demo1
		System.out.println(request.getRequestURI()); // /day09_01_HttpServletRequest/demo1
		System.out.println(request.getMethod()); //GET
		System.out.println(request.getContextPath()); // /day09_01_HttpServletRequest
		System.out.println(request.getQueryString()); // name=username&passsword=password
	}

}
