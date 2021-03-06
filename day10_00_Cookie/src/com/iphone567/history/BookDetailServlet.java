package com.iphone567.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = new BookService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		PrintWriter w = response.getWriter();

		String id = request.getParameter("id");

		if (id != null) {
			Book book = bookService.findBookById(id);
			if (book != null) {
				w.println("<h1>正在浏览：" + book + "</h1>");
				// 保存Cookie
				save(book, request, response);
			}
		}

		w.println("<h5>3秒后跳转...</h5>");
		response.setHeader("refresh", "3; url=bookHistory");

	}

	private void save(Book book, HttpServletRequest request, HttpServletResponse response) {
		try {
			Cookie[] cookies = request.getCookies();
			// 最后的要添加cookie的id串
			String resultValue = book.getId();

			for (int i = 0; cookies != null && i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				// 查找Cookie
				if (cookie.getName().equals("book_hostory")) {
					String value = cookie.getValue();
					String ids[] = value.split("-");
					LinkedList<String> list = new LinkedList<>(Arrays.asList(ids));
					String willAddId = request.getParameter("id");
					// 如果存在id，则先删除，保证
					if (list.contains(willAddId)) {
						list.remove(willAddId);
					}

					list.addFirst(willAddId);

					// 重组Cookie的value值
					StringBuffer stringBuffer = new StringBuffer();
					for (int j = 0; j < list.size(); j++) {
						if (j > 0) {
							stringBuffer.append("-");
						}
						stringBuffer.append(list.get(j));
					}

					resultValue = stringBuffer.toString();

				}
			}

			// 保存Cookie
			Cookie willSaveCookie = new Cookie("book_hostory", resultValue);
			willSaveCookie.setMaxAge(Integer.MAX_VALUE);
			willSaveCookie.setPath("/");
			response.addCookie(willSaveCookie);

			System.out.println("add cookie book_hostory : " + resultValue);
		} catch (Exception e) {
		}
	}

}
