<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서비스 성공</title>
</head>
<body>
	<h1>서비스 성공</h1>
	<h2>${requestScope.msg}</h2>
	<script>
		const result = ${msg};
		alert(result);
		window.location.href = "URL";
	</script>
</body>
</html>