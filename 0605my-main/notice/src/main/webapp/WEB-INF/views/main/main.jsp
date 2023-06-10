<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<jsp:include page="menu.jsp"></jsp:include>
		</div>
		<h1>Welcome to my home</h1>
		<h1 align="center">
			<a href="noticeList.do">게시글목록</a>
		</h1>
		<h6 algin="center">
			<a href="memberList.do">멤버목록 보기</a>
		</h6>
		<h3 algin="center">
			<a href="memberLoginForm.do">로그인하기</a>
		</h3>
	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>