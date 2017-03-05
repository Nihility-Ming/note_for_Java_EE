package com.iphone567.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyServletContextListener implements ServletContextListener {

	// 服务器启动的时候触发
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyServletContextListener 创建了");
	}

	// 服务器关闭的时候触发
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyServletContextListener 销毁了");
	}


}
