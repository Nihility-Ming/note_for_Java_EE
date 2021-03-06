package com.iphone567.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter w = response.getWriter();

		String id = request.getParameter("id");
		Book book = bookService.findBookById(id);
		if (book == null) {
			w.println("<h3>不存在这书...</h3>");
			response.setHeader("refresh", "3; url=showAllBooks");
			return;
		}

		// ----- 写入Session -----

		HttpSession session = request.getSession();
		// 设置session有效时间
		session.setMaxInactiveInterval(1000);
		System.out.println("session id:" + session.getId());

		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) session.getAttribute("cart");
		if (books == null) {
			books = new ArrayList<>();
		}

		if (books.contains(book)) {
			w.println("<h1>这本书籍《" + book.getName() + "》已经存在于购物车！</h1>");
			response.setHeader("refresh", "3; url=showAllBooks");
			return;
		}

		books.add(book);

		session.setAttribute("cart", books);

		w.println("<h3>成功添加...</h3>");
		w.println("<p>" + book + "</p>");
		response.setHeader("refresh", "3; url=showAllBooks");
	}

}
