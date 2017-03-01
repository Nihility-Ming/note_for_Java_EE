package com.iphone567.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 页面刷新和跳转
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		test1(response);
		test2(response);
	}

	@SuppressWarnings("unused")
	private void test1(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "3");
		
		Random random = new Random();
		response.getWriter().write(random.nextDouble()+"");
	}

	private void test2(HttpServletResponse response)  throws IOException  {
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("正在跳转到注册页面。。。");
		response.setHeader("refresh", "3;url=login.html");
	}

	

}
