package com.iphone567.servlet;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.iphone567.entity.User;

public class ServletDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 使用register.html测试
	// 获取用户表单提交的参数（POST请求）
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决POST过来的数据乱码的问题(如果是GET乱码即用new String方式解决)
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// test1(request, response);
		// test2(request, response);
		// entity(request, response);
		use_framework_build_entity(request, response);
	}

	// 获取所有的请求参数，并且打印到控制台
	@SuppressWarnings("unused")
	private void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {

			String name = parameterNames.nextElement();
			String[] values = request.getParameterValues(name);

			for (int i = 0; values != null && i < values.length; i++) {
				System.out.println(name + "\t" + values[i]);
			}

		}
	}

	// 获取register.html用户填写的表单内容
	@SuppressWarnings("unused")
	private void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] xq = request.getParameterValues("xq");
		String city = request.getParameter("city");

		response.getWriter().println("用户名：" + username);
		response.getWriter().println("密码：" + password);
		response.getWriter().println("性别：" + gender);
		response.getWriter().print("兴趣：");
		for (int i = 0; xq != null && i < xq.length; i++) {
			response.getWriter().print(xq[i] + " ");
		}
		response.getWriter().println();
		response.getWriter().println("城市：" + city);
	}

	// 把请求参数封装到domain对象
	@SuppressWarnings("unused")
	private void entity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		User user = new User();
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			String name = entry.getKey();
			String[] values = entry.getValue();

			try {
				PropertyDescriptor descriptor = new PropertyDescriptor(name, User.class);
				Method writeMethod = descriptor.getWriteMethod();
				if (values.length == 1) {
					writeMethod.invoke(user, values[0]);
				} else if (values.length > 1) {
					writeMethod.invoke(user, (Object) values);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println(user);
	}
	
	// 使用框架生成JavaBean
	private void use_framework_build_entity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println(user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
