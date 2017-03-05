<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty zhangwu}">
	<h1>什么都没有。。。</h1>
</c:if>

<c:if test="${not empty zhangwu}">
	<table border="1">
		<tr>
			<th>zwid</th>
			<th>flname</th>
			<th>money</th>
			<th>zhanghu</th>
			<th>createtime</th>
			<th>description</th>
		</tr>
		<tr>
			<td>${zhangwu.zwid}</td>
			<td>${zhangwu.flname}</td>
			<td>${zhangwu.money}</td>
			<td>${zhangwu.zhanghu}</td>
			<td>${zhangwu.createtime}</td>
			<td>${zhangwu.description}</td>
		</tr>
	</table>
</c:if>
