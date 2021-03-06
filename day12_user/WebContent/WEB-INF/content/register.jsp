<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.content table {
	text-align: left;
}
</style>
<div class="content">
	<form action="${pageContext.request.requestURI }" method="post">
		<table align="center">
			<td colspan="2" style="text-align:center"><img
				src="${pageContext.request.contextPath }/images/logo.jpg" /></td>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" value="${username }" required /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value="${password }" required /></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="repassword" value="${repassword }" required /></td>
			</tr>
			<tr>
				<td>性别</td>
				
				<td><label><input type="radio" value="male"
						name="gender" ${gender == "male" || empty gender ? "checked=\"checked\"" : ""} />男</label>&nbsp;&nbsp;&nbsp;<label><input
						type="radio" value="female" name="gender"  ${gender == "female" ? "checked=\"checked\"" : ""} />女</label></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><select name="age">
						<c:forEach begin="18" end="120" step="1" var="l">
							<option value="${l}"${l==age? " selected=\"selected\"" : ""}>${l}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>邮件</td>
				<td><input type="email" name="email" value="${email}" required /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><textarea cols="30" rows="4" name="description">${description}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center"><input type="submit" value="注 册" />&nbsp;&nbsp;&nbsp;<input
					type="reset" value="重 置" /></td>
			</tr>
		</table>
	</form>

</div>