package com.iphone567.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("A：我要借钱！");
		System.out.println("B：我没有，但是我可以告诉你谁有。");

		// 设置非表单请求参数
		request.setAttribute("money", 100);

		// 转发，直接跳到demo6，然后再回来继续执行，能保持request, response
		// 转发不能转到其他应用
//		request.getRequestDispatcher("demo6").forward(request, response);
		
		request.getRequestDispatcher("demo6").include(request, response); // 包含，两个资源当一个用

		System.out.println("A：已经完成借款");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
