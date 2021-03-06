package com.iphone567.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 登陆处理
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter w = response.getWriter();

		// 获取请求表单的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code").toLowerCase();

		// 判断用户／密码／验证码是否正确，并设置错误信息
		if (!code.equals(request.getSession().getAttribute("code"))) {
			request.setAttribute("errMsg", "验证码错误！");
		} else if (!("admin".equals(username) && "123456".equals(password))) {
			request.setAttribute("errMsg", "用户名或密码错误！");
		}

		// 如果有错误信息，直接转发到登陆页
		if (request.getAttribute("errMsg") != null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		// 都没有问题，显示登陆成功
		w.println("<h1>登陆成功！</h1>");
		response.setHeader("refresh", "3; url=login.jsp");
	}

}
