<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 没有否则语句 -->
	<c:set var="num" value="3"></c:set>
	<c:if test="${num>2}">
		<h1>3>2</h1>
	</c:if>

	<!-- 相当于switch语句 -->
	<c:choose>
		<c:when test="${num ==1 }">aaa</c:when>
		<c:when test="${num ==2 }">bbb</c:when>
		<c:when test="${num ==3 }">ccc</c:when>
	</c:choose>

</body>
</html>