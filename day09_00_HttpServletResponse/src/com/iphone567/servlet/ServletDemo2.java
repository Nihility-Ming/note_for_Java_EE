package com.iphone567.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("gbk"); // 告诉服务器使用gbk编码
		response.setContentType("text/html; charset=gbk"); // 告诉客户端使用网页和gbk编码
		OutputStream outputStream = response.getOutputStream();
		outputStream.write("你好中国！".getBytes("gbk"));
	}

}
