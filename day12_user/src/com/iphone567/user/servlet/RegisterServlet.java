package com.iphone567.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.iphone567.user.domain.User;
import com.iphone567.user.service.UserService;
import com.iphone567.user.service.imp.UserServiceImp;


public class RegisterServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImp();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html; charset=utf-8");
		request.setAttribute("title", "My Site - 注册");
		request.getRequestDispatcher("/WEB-INF/content/header.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/content/register.jsp").include(request, response);
		request.getRequestDispatcher("/WEB-INF/content/footer.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(userService.register(user) > 0) {
				
			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
