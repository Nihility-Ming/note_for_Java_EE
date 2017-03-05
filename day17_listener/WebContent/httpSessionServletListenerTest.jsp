<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HttpSessionServletListenerTest</title>
</head>
<body>
<%
// 关闭服务器
// 
// session.setMaxInactiveInterval(10); //10秒后销毁session
session.invalidate(); // 销毁session
%>
</body>
</html>