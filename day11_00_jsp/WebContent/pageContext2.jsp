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
	// 取不到
	// String username = (String)pageContext.getAttribute("username");
	// out.println(username);
	
	// out.println(request.getAttribute("username"));
	out.println(pageContext.findAttribute("username"));
	// out.println(session.getAttribute("username"));
%>
</body>
</html>