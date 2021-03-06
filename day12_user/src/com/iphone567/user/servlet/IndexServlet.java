package com.iphone567.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html; charset=utf-8");
		request.setAttribute("title", "My Site");
		request.getRequestDispatcher("/WEB-INF/content/header.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/content/welcome.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/content/footer.jsp").include(request, response);
	}

}
