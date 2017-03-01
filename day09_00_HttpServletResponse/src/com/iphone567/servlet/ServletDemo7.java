package com.iphone567.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 请求重定向
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("A：我要借钱！");
		System.out.println("B：我没有，但是我可以告诉你谁有。");
		
		// 请求重定向，java代码继续执行，只告诉客户端重定向信息
		response.sendRedirect("demo8"); 
//		下面等价效果
//		response.setStatus(302);
//		response.setHeader("location", "demo8");
		
		System.out.println("A:我去了");
	}

}
