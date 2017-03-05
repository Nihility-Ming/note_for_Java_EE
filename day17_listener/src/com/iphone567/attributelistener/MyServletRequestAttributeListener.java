package com.iphone567.attributelistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

	public MyServletRequestAttributeListener() {
	}

	// request.setAttribute的时候触发
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("request属性添加了");
		System.out.println("添加的name: " + srae.getName());
		System.out.println("添加的value: " + srae.getValue());
	}

	// request.removeAttribute的时候触发
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("request属性移除了");
		System.out.println("移除的name: " + srae.getName());
		System.out.println("移除的value: " + srae.getName());
	}

	// request.setAttribute已存在的name的时候触发
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request属性被替换了");
		System.out.println("替换的name: " + srae.getName());
		System.out.println("替换的value: " + srae.getValue());
	}

}
