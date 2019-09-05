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
	<h2>통장 만들기</h2>
	<form id="account_Form" action="<%=request.getContextPath()%>/account.do">
		입금액 <input type="text" name="money"/> <br/>
		<input type="submit" id="btn" value="전송">
		<!-- 
		//id, pass, name, ssn, credit		
		 -->
	</form>
</div>
<script>
$('#account_Form').submit(function(){
	alert('통장테스트!!');
});
</script>
<body>
</body>
</html>