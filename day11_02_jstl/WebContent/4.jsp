<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.odd {
	background-color: gray;
}

.even {
	background-color: white;
}
</style>
</head>
<body>
	<%
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");

		request.setAttribute("list", list);
	%>
	<table border="1">
		<tr>
			<th>数据</th>
			<th>索引</th>
			<th>记数</th>
			<th>第一个</th>
			<th>最后一个</th>
		</tr>
		<c:forEach items="${list }" var="vx" varStatus="vs">
			<tr class="${vs.index%2==0?'odd':'even'}">
				<td>${vx }</td>
				<td>${vs.index }</td>
				<td>${vs.count }</td>
				<td>${vs.first }</td>
				<td>${vs.last }</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>