package com.iphone567.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("C：听说你要借钱？");
		// 获取非表单参数
		Integer money = (Integer) request.getAttribute("money");
		System.out.println("A：我要借" + money + "万！");
	}
}
