<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		String str1 = null;
		String str2 = "";
		String str3 = "aaa";
		List<String> list1 = null;
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>() {
			{
				add("Hello");
			}
		};

		request.setAttribute("str1", str1);
		request.setAttribute("str2", str2);
		request.setAttribute("str3", str3);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
	%>
	<p>empty 运算符用法</p>
	String str1 = null; ----- \${empty str1 } ----- ${empty str1 }
	<hr />
	String str2 = ""; ----- \${empty str2 } ----- ${empty str2 }
	<hr />
	String str3 = "aaa"; ----- \${empty str3 } ----- ${empty str3 }
	<hr />
	List list1 = null; ----- \${empty list1 } ----- ${empty list1 }
	<hr />
	List list2 = new ArrayList(); ----- \${empty list2 }----- ${empty list2 }
	<hr />
	List list3 = new ArrayList(){ { add("Hello"); } }; ----- \${empty list3}-----
	${empty list3}

	<hr />
	<p>三目运算符</p>
	\${empty str1 ? "the null" : "not null" }-------${empty str1 ? "the null" : "not null" }

</body>
</html>