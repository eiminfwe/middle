<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<div><h1>게시글목록</h1></div>
<div>

<c:forEach items="${notices }" var="n">
	${n.noticeId }:${n.noticeWriter }:${n.noticeTitle }:${n.noticeWdate } :${n.noticeHit }
	<br>
</c:forEach>
</div>
</div>


</body>
</html>