<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax测试</title>
<script type="text/javascript">
	function showCustomer(str) {
		var xmlhttp;
		if (str == "") {
			document.getElementById("txtHint").innerHTML = "";
			return;
		}
		
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
			}
		}
		
		xmlhttp.open("GET", "showDataServlet?flname=" + str + "&time=" + new Date().getTime(), true);
		xmlhttp.send();
	}
	
	window.onload=function() {
		var select = document.getElementsByName("flname")[0];
		showCustomer(select.options[0].value);
	}
</script>
</head>
<body>
<div>
<select name="flname" onchange="showCustomer(this.value)">
	<option value="派对">派对</option>
	<option value="眼药水">眼药水</option>
	<option value="买零食">买零食</option>
	<option value="吃麦当劳汉堡">吃麦当劳汉堡</option>
	<option value="其他">其他</option>
</select>
</div>
<div id="txtHint">

</div>
</body>
</html>