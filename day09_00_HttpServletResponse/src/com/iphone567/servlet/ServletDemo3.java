package com.iphone567.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 下载一个图片
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = this.getServletContext().getRealPath("/WEB-INF/classes/timg.jpg");
		File file = new File(path);

		response.setContentType("image/jpeg");
		response.setHeader("content-disposition", "attachment;filename=" + file.getName());

		InputStream inputStream = new FileInputStream(file);
		ServletOutputStream outputStream = response.getOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(data)) != -1) {
			outputStream.write(data, 0, len);
		}
		
		inputStream.close();
	}

}
