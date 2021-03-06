package com.iphone567.demo;

import java.lang.reflect.Method;

import com.iphone567.annotation.MyTest;

@SuppressWarnings("all")
public class Main {

	public static void main(String[] args) throws Exception {
		Method[] methods = Demo.class.getMethods();
		for (Method method : methods) {
			// 判断当前方法是否有@MyTest修饰
			boolean annotationPresent = method.isAnnotationPresent(MyTest.class);
			if (annotationPresent) {
				// 拿到Annotation注解
				MyTest mytest = (MyTest) method.getAnnotation(MyTest.class);
				Object newInstance = Demo.class.newInstance();

				if (mytest.timeout() == 0) { // 注解默认的timeout属性值是0，说明当前方法没有设置timeout属性，直接执行方法即可。
					method.invoke(newInstance, null);
				} else { // 设置了
					long s = System.nanoTime();
					method.invoke(newInstance, null);
					long e = System.nanoTime();
					if ((e - s) > mytest.timeout()) { // 根据timeout属性值于方法执行时间，判断当前方法执行是否超时
						System.out.println(method.getName() + "执行超时！");
					}
				}

			}
		}
	}

}
