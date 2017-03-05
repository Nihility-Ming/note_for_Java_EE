package com.iphone567.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {
	private static Timer timer = new Timer();

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");

		ServletContext servletContext = sce.getServletContext();
		final List<HttpSession> sessions = Collections.synchronizedList(new ArrayList<HttpSession>());
		servletContext.setAttribute("sessoins", sessions);

		// 设置定时任务，每5秒执行清除最后访问时间大于5秒的session
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("开始扫描。。。");
				for (Iterator<HttpSession> iterator = sessions.iterator(); iterator.hasNext();) {
					HttpSession httpSession = (HttpSession) iterator.next();
					long t = System.currentTimeMillis() - httpSession.getLastAccessedTime();
					if (t >= 5000) {
						httpSession.invalidate();
						iterator.remove();
						System.out.println("清除了session。。。");
					}
				}
			}
		}, 2000, 5000);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
	}

}
