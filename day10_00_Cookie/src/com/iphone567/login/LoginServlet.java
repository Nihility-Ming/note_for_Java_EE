package com.iphone567.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		PrintWriter w = response.getWriter();

		// 查找Cookie检查用户是否已经登陆
		String username = "";
		String remember = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("username")) {
				Cookie usernameCookie = cookies[i];
				username = usernameCookie.getValue();
				remember = "checked=checked";
			}
		}

		w.println("<form action=dologin method=post>");
		w.println("<label>用户名<input type=text name=username value='" + username + "' /></label>");
		w.println("<label>密 码<input type=password name=password /></label>");
		w.println("<label>记住<input type=checkbox name=remember value='remember' " + remember + "/></label>");
		w.println("<input type=submit value='登陆' />");
		w.println("</from>");
	}

}
