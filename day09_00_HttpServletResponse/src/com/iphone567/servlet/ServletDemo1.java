package com.iphone567.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setCharacterEncoding("utf-8");
		// resp.setHeader("content-type", "text/html; charset=utf-8");
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().write("你好，中国！");

	}

}
