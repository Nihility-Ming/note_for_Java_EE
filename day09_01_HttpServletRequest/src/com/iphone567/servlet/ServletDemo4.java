package com.iphone567.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// getInputStream
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 获取请求的输入流，对POST有效，对GET无效
		ServletInputStream inputStream = request.getInputStream();
		int len = 0;
		byte[] data = new byte[1024];
		while ((len = inputStream.read(data)) != -1) {
			String content = new String(data, 0, len);
			System.out.println(content);
		}
	}

}
