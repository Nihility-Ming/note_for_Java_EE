<%@page import="javax.naming.Context"%><%@page import="javax.sql.DataSource"%><%@page import="javax.naming.InitialContext"%><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试JNDI数据源</title>
</head>
<body>
	<h2>测试JNDI数据源</h2>
	<h3 style="color: red">
		<%
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/tally");
			out.println(ds);
		%>
	</h3>
	<hr />
	<p>PS：需要在tomcat目录lib下丢一个mysql的驱动jar包。然后在web应用目录META-INF目录下放一个context.xml</p>
	<p>PS：或者可以在tomcat的conf/context.xml目录下配置全局范围的多个数据源组成的JNDI</p>
	<p>详情查看tomcat doc 9) JDBC DataSources</p>
</body>
</html>