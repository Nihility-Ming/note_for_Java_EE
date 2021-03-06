package com.iphone567.history;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用cookie实现浏览历史功能 原理：使用id-id-id字符串存在cookie里面，对id-id-id的cookie读写 测试地址
 * /bookHistory
 */
public class BookHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		PrintWriter w = response.getWriter();
		for (Book book : bookService.findAllBooks()) {
			w.println("<p><a href=bookDetail?id=" + book.getId() + ">《" + book.getName() + "》[" + book.getAuthor() + "]"
					+ "</a></p>");
		}

		w.println("<hr />");
		w.println("<p style='color:red'>浏览历史<p>");

		// 输出浏览历史Cookie
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("book_hostory")) {
				String value = cookies[i].getValue();
				String[] ids = value.split("-");
				for (int j = 0; j < ids.length; j++) {
					Book book = this.bookService.findBookById(ids[j]);
					w.println("<p>" + book.getName() + "</p>");
				}
			}
		}

	}

}
