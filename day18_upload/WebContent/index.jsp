<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath }/upload"
		enctype="multipart/form-data">
		姓名： <input type="text" name="username" /> <br /> 文件： <input
			type="file" name="uploadFile" /> <br /> <input type="submit"
			value="提 交" />
	</form>
</body>
</html>