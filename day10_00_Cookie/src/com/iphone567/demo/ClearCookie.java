package com.iphone567.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClearCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 删除名为lastAccessTime 的cookie
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		Cookie lastAccessTimeCookie = new Cookie("lastAccessTime", "");
		lastAccessTimeCookie.setPath("/");
		// 设置立即过期时间，相当于删除cookie
		lastAccessTimeCookie.setMaxAge(0); 
		response.addCookie(lastAccessTimeCookie);
		response.getWriter().println("成功删除lastAccessTime cookie!");
	}

}
