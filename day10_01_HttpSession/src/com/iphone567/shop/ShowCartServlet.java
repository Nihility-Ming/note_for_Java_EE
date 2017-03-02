package com.iphone567.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 查看购物车里面保存的书籍
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter w = response.getWriter();
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) session.getAttribute("cart");
		if(books == null) {
			w.println("<p>购物车空空如也。。。</p>");
			return;
		}
		
		w.println("<h3>购物车</h3>");
		w.println("<hr />");
		for (int i = 0; i < books.size(); i++) {
			w.println("<p>"+books.get(i).getName()+"</p>");
		}
	}

}
