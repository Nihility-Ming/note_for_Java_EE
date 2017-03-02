package com.iphone567.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 验证码
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValidateCode validateCode = new ValidateCode(110, 22, 4, 5);
		String code = validateCode.getCode().toLowerCase();
		validateCode.write(response.getOutputStream());
		// 把验证码保存到session
		request.getSession().setAttribute("code", code);
		
		System.out.println(request.getSession().getId() + "验证码：" + code);
	}

}
