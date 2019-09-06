<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행 관리 시스템</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<div>
	<h2>회원가입join</h2>
	<form id="join_Form" action="<%=request.getContextPath()%>/customer.do">
		아이디 <input type="text" name="id"/> <br/>
		비빌번호<input type="text" name="pw"/> <br/>
		주민번호<input type="text" name="ssn"/> <br/>
		이름<input type="text" name="name"/> <br/>
		신용도<input type="text" name="credit"/> <br/>
		<input type="hidden" name="action" value="join" />
		<input type="hidden" name="page" value="login" />
		<input type="hidden" name="directory" value="customer" />
		<input type="submit" id="btn" value="전송">
		<!-- 
		//id, pass, name, ssn, credit		
		 -->
	</form>
</div>
<script>
$('#join_Form').submit(function(){
	alert('회원가입성공!!');
	});
</script>
<body>
</body>
</html>