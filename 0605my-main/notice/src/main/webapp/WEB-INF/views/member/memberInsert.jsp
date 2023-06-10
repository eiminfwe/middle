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
			<h2>회원가입</h2>
		</div>
		<form id="frm" action="memberInsert.do" onsubmit="return formCheck()"
			method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">*id</th>
						<td width="300"><input type="email" id="memberId"
							name="memberId">&nbsp;
							<button type="button" id="checkId" value="No" onclick="idCheck()">중복체크</button>
						</td>

					</tr>
					<tr>
						<th>*pw</th>
						<td><input type="password" id="memberPw" name="memberPw"
							required="required"></td>
					</tr>
					<tr>
						<th>*pwCheck</th>
						<td><input type="password" id="Pwcheck" name="Pwcheck"></td>
					</tr>
					<tr>
						<th>*name</th>
						<td><input type="text" id="memberName" name="memberName"></td>
					</tr>
					<tr>
						<th>*phoneNumber</th>
						<td><input type="tel" id="memberTel" name="memberTel">
						</td>
					</tr>
					<tr>
						<th>Age</th>
						<td><input type="text" id="memberAge" name="memberAge">
						</td>
					</tr>
					<tr>
						<th>*Gender</th>
						<td><input type="text" id="memberGender" name="memberGender"
							required="required"></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="submit" value="submit"">&nbsp;&nbsp; <input
					type="reset" value="cancel">&nbsp;&nbsp; <input
					type="button" onclick="location.href='main.do'" value="back">

			</div>
		</form>
		<div>
			<jsp:include page="../main/footer.jsp"></jsp:include>
		</div>
	</div>
	<script type="text/javascript">
		function formCheck() {
			let frm = document.getElementById("frm");
			if (frm.memberPw.value != frm.Pwcheck.value) {
				alert("plz check pw once more")
				frm.memberPw.value = "";
				frm.Pwcheck.value = "";
				frm.memberPw.focus();
				return false;
			}
			if (frm.checkId.value != "Yes") {
				alert("중복체크를 수행하세요")
				return false;
			}
			return true;
		}
		
		function idCheck(){
			let id=document.getElementById("checkId").value;
			//let checkId=document.getElementById("checkId").value;
			let url="ajaxCheckId.do?id="+id;
// 			fetch랑 비슷한 것:promise(여러 개(callback method) 처리)
//get방식은 생략가능fetch(get방식의 method)라서 생략한 것임
			
			
			fetch(url){//ajax(fetch api)호출(get 방식으로 호출)
				.then(response=>response.text());
				.then(text=>htmlProcess(text))
			}
			alert(id);
		}
		function htmlProcess(data){
			if(data =="Yes"){
				alert("document.getElementById("memberId").value+ "\n you can use that id");
				document.getElementById("checkId").value="yes";
			}else{
				alert("document.getElementById("memberId").value+ "\n you can't use this id");
						alert("document.getElementById("memberId").focus();
			}
		}
	</script>

</body>
</html>