<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%><%@ page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- HTML注释 -->
	<%--JSP注释 --%>
	<%
		/*Java注释*/
	%>

	<%!// 定义变量和方法
	private int visitedCount = 0;

	public static String getTimeString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}%>

	<h1><%=getTimeString()%></h1>
	<h2>
		已访问次数：<%=++visitedCount%></h2>
</body>
</html>