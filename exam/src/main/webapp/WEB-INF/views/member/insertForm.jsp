<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" action="Insert.do" onsubmit="return checkForm()" method="post">
		<ul>
			<li><label for="memberId">아이디</label>
			<input type="text" id="memberId" name="memberId">
			<button type="button" onclick="checkId()" id="idCheck" value="No">중복체크</button></li>
			<li><label for="memberPw">비밀번호</label>
			<input type="password" id="memberPw" name="memberPw"></li>
			<li><label for="checkPw">비밀번호확인</label>
			<input type="password" id="checkPw" name="checkPw"></li>
			<li><label for="memberName">이름</label>
			<input type="text" id="memberName" name="memberName"></li>
			<li><label for="memberAge">나이</label>
			<input type="text" id="memberAge" name="memberAge"></li>
			<li><label for="memberTel">전화번호</label>
			<input type="text" id="memberTel" name="memberTel"></li>
			<li><label for="memberGender">성별</label>
			<input type="text" id="memberGender" name="memberGender"></li>	
		</ul>
	<input type="submit" value="확인">
	</form>
	<script type="text/javascript">
	function checkForm(){
		let frm = document.getElementById("frm");
		
		if(frm.memberPw.value != frm.checkPw.value){
			frm.memberPw.value = "";
			frm.checkPw.value = "";
			
			frm.memberPw.focus();
			return false;
			
		} else if(frm.idCheck.value != 'Yes'){
			alert("아이디 체크를 해주세요");
			return false;
		}
		
		return true;
		
	}
	
	function checkId(){
		let id = document.getElementById("memberId").value;
		let url = "ajaxCheckId.do?id=" + id;
		
		fetch(url)
			.then(response => response.text())
			.then(text => htmlProcess(text));
	}
	
	function htmlProcess(data){
		if(data == 'Yes'){
			alert("사용가능한 아이디");
			document.getElementById("idCheck").value = 'Yes';
		} else {
			alert("사용중인 아이디");
		}
	}
	
	</script>
</body>
</html>