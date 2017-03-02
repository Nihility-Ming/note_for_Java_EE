<%@page import="com.iphone567.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student student = new Student();
		student.setName("Biweiming");
		
		request.setAttribute("stu", student);
		
		request.getRequestDispatcher("2.jsp").forward(request, response);
	%>
</body>
</html>