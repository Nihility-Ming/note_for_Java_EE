package com.iphone567.demo;

import com.iphone567.annotation.MyTest;

public class Demo {

	@MyTest(timeout = 1000)
	public void method1() {
		System.out.println("执行测试方法1");
	}

	@MyTest(timeout = 1000000)
	public void method2() {
		System.out.println("执行测试方法2");
	}

	@MyTest
	public void method3() {
		System.out.println("执行测试方法3");
	}

}
