package com.iphone567.shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter w = response.getWriter();

		w.println("<h3>添加到购物车：</h3>");
		for (Book book : bookService.findAllBooks()) {
			w.println("<p><a href='addCart?id=" + book.getId() + "'>" + book.getName() + "</a></p>");
		}

		w.println("<hr />");
		w.println("<a href='showCart' target='_blank'>查看购物车</a>");

	}

}
