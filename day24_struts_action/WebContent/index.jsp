<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/demo1.action">访问Struts2第一个案例</a> <br />
<a href="${pageContext.request.contextPath}/demo1">访问Struts2第一个案例(没有.action)</a> <br />
<a href="${pageContext.request.contextPath}/demo1.do">访问Struts2第一个案例(有.do)</a> <br />
<a href="${pageContext.request.contextPath}/demo1.abc">访问Struts2第一个案例(有.abc)</a> <br />
<a href="${pageContext.request.contextPath}/demo1.jjj">访问Struts2第一个案例(有.jjj)</a>
</body>
</html>