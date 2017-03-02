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
		pageContext.setAttribute("page", "page", PageContext.PAGE_SCOPE);
		pageContext.setAttribute("session", "session", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("request", "request", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("application", "application", PageContext.APPLICATION_SCOPE);
		response.addCookie(new Cookie("mycookie", "hello_cookie"));

		if (request.getParameter("param") == null)
			response.sendRedirect("5.jsp?param=mylove");
	%>
	<p>---- code ----</p>
	<pre>
	pageContext.setAttribute("page", "page", PageContext.PAGE_SCOPE);
	pageContext.setAttribute("session", "session", PageContext.SESSION_SCOPE);
	pageContext.setAttribute("request", "request", PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("application", "application", PageContext.APPLICATION_SCOPE);
	response.addCookie(new Cookie("mycookie", "hello_cookie"));
	
	if(request.getParameter("param")==null) response.sendRedirect("5.jsp?param=mylove");
</pre>
	<hr />
	<i>隐式对象(除了pageContext是PageContext类型，其他都是Map类型)</i>
	<p>\${pageScope.page} ---------- ${pageScope.page}</p>
	<p>\${requestScope.request} ---------- ${requestScope.request}</p>
	<p>\${sessionScope.session} ---------- ${sessionScope.session}</p>
	<p>\${applicationScope.application} ----------
		${applicationScope.application}</p>
	<p>\${param.param} ---------- ${param.param}</p>
	<p>\${paramValues.param[0]} ---------- ${paramValues.param[0]}</p>
	<p>\${header["User-Agent"]"} ---------- ${header["User-Agent"]}</p>
	<p>\${headerValues["User-Agent"][0]} ----------
		${headerValues["User-Agent"][0]}</p>
	<p>\${cookie.mycookie.value} ---------- ${cookie.mycookie.value}</p>
</body>
</html>