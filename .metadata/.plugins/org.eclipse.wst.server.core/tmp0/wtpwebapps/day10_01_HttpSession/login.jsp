<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script type="text/javascript">
	function changeCode(img) {
		img.src = "code?time=" + new Date().getTime();
	}
</script>
</head>
<body>

	<form method="post" action="doLogin">
		<table
			style="margin: 100px auto 0px; border: 1px dotted pink; padding: 50px;">
			<%
				String errMsg = (String) request.getAttribute("errMsg");
				if (errMsg != null) {
					out.println("<caption>" + errMsg + "</caption>");
				}
			%>
			<tr>
				<td>账号：</td>
				<td colspan="2"><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td colspan="2"><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="code" /></td>
				<td><img src="code" alt="验证码" onclick="changeCode(this)" /></td>
			</tr>
			<tr>
				<td colspan="3" style="padding-left: 70px"><input type="submit"
					value="登陆" /> <input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>