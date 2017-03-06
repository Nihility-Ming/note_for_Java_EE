package com.iphone567.demo;

import com.iphone567.annotation.MyAnnotation;
import com.iphone567.annotation.OtherAnnotation;

@MyAnnotation(name="我的测试",others={@OtherAnnotation("xdf"), @OtherAnnotation("abc")})
public class MyTest {

	@SuppressWarnings("all")
	public MyTest() {
		
	}

}
