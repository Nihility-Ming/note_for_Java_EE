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
	Student stu = (Student)pageContext.findAttribute("stu");
	out.println(stu.getName());
%>

<!-- 和上面代码等价 -->
${stu.name}

${stuxx.xxx}<!-- 即使对象和属性不存在，也不会报错！直接转成了空字符串 -->

${stu.city.name}<!-- 属性导航，相当于：stu.getCity().getName() -->
</body>
</html>