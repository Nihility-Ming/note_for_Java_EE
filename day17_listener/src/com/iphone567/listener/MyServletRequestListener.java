package com.iphone567.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	public MyServletRequestListener() {
	}
	
	// request创建的时候触发该方法
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("MyServletRequestListener requestInitialized");
	}

	// request销毁的时候触发该方法
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("MyServletRequestListener requestDestroyed");
	}

	

}
