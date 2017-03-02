package com.iphone567.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter w = response.getWriter();
		
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		String remember = request.getParameter("remember");
		
		Cookie cookie = new Cookie("username", username);
		cookie.setPath("/");
				
		if("admin".equals(username) && "123456".equals(password)) {
			if(remember!=null && remember.equals("remember")) {
				cookie.setMaxAge(Integer.MAX_VALUE); // 永不过期
			} else {
				cookie.setMaxAge(-1); // 关闭浏览器过期
			}
			w.println("<p>登陆成功!</p>");
		} else {
			cookie.setMaxAge(0); // 立即过期
			w.println("<p>用户名或密码错误！</p>");
		}
		
		response.addCookie(cookie);
		
		w.println("<p>2秒后跳转...</p>");
		response.setHeader("refresh", "2;url=login");
	}

}
