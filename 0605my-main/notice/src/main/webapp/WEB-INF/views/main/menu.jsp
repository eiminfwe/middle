<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<nav id="topMenu">
			<ul>
				<li><a class="menuLink" href="main.do"></a>home</li>
				<li>Notice</li>
				<c:if test="${empty id }">
					<li><a class="menuLink" href="memberJoin.do">memberJoin</a></li>
				</c:if>
				<c:if test="${empty id }">
				<li><a class="menuLink" href="memberLoginFomr.do">Login</a>
				</li>
				</c:if>
				<c:if test="${not empty id }">
				<li><a class="menuLink" href="#">Logout</a>
				</li>
				</c:if>
				<li>MemberJoin</li>
				<li>Member</li>
				<li>Login</li>
				
<!-- 				id는 session의 변수명. session은 어느 페이지에서나 사용가능 -->
			</ul>
		</nav>
	</div>

</body>
</html>