package com.iphone567.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("已经设置了session");
		// 把当前session丢到servletContext的自定义集合中...
		ServletContext servletContext = se.getSession().getServletContext();
		@SuppressWarnings("unchecked")
		List<HttpSession> sessions = (List<HttpSession>) servletContext.getAttribute("sessoins");
		sessions.add(se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session 已经销毁！");
	}

}
