package com.iphone567.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 如果浏览器禁用cookie，可以使用response.encodeURL()方法重写url。
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 获取cookie
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			response.getWriter().println("<p>您是第一次访问本站!</p>");
		} else {
			for (Cookie cookie : cookies) {
				// 取得名称为lastAccessTime的cookie
				if (cookie.getName().equals("lastAccessTime")) {
					Long t = Long.parseLong(cookie.getValue());
					String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(t));
					response.getWriter().println("您最近访问时间是：" + time);
					response.getWriter().println("<a href=clearcookie target=_blank>clear cookie</a>");
				}
			}
		}
		
		// 创建cookie
		Cookie lastAccessTimeCookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		// 设置过期时间是5分钟，过期时间单位是秒
		lastAccessTimeCookie.setMaxAge(60 * 5);
		// 设置路径，作为cookie的标识
		lastAccessTimeCookie.setPath("/");
		// 添加最近访问时间的cookie
		response.addCookie(lastAccessTimeCookie);
	}

}
