<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--

	pageContext.setAttribute("username", "BiWeiming", PageContext.REQUEST_SCOPE);
	request.getRequestDispatcher("/pageContext2.jsp").forward(request, response);
--%>

<%
// 四个作用域
	int i1 = PageContext.PAGE_SCOPE;
	int i = PageContext.REQUEST_SCOPE;
	int i2 = PageContext.APPLICATION_SCOPE;
	int i3 = PageContext.SESSION_SCOPE;
	
	pageContext.setAttribute("username", "123456", PageContext.SESSION_SCOPE);
/* 	request.getRequestDispatcher("/pageContext2.jsp").forward(request, response);
 */	
	pageContext.forward("/pageContext2.jsp");
%>
</body>
</html>