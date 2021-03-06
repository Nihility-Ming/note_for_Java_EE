package com.iphone567.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Person {
	// 动态代理的作用：给原方法挤入额外代码
	public static void main(String[] args) {
		// 一只狗变超级狗去开冰箱
		Dog dog = new Dog();
		
		Dosomething superDog = (Dosomething)Proxy.newProxyInstance(Dosomething.class.getClassLoader(), new Class[]{Dosomething.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// 植入前方法
				System.out.println("狗打开冰箱，查看有没骨头。");
				System.out.println("狗用手拿一个骨头");
				
				// 调用原方法
				method.invoke(dog, args);
				
				// 植入后方法
				System.out.println("狗关冰箱");
				return null;
			}
		});
		
		superDog.doSomething("狗吃骨头");
	}
}
