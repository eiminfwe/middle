<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- forward는 같은 것이 전달 되는 것이 아니지만(새로운 일을 위임하는 것. sendRedirect같은 것들을 그 결과값이 아니라 sednRedirect  그 자체를 전송함), 
dispatcher는 같은 것이 전달됨(원하는 정보가 옴. ).
-->
	<jsp:forward page="main.do"/>
</body>
</html>