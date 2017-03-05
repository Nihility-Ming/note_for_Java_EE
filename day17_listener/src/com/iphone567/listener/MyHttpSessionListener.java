package com.iphone567.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	public MyHttpSessionListener() {
	}

	// session创建的时候触发该方法
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("MyHttpSessionListener sessionCreated");
	}

	// session销毁的时候触发该方法
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("MyHttpSessionListener sessionDestroyed");
	}

}
