<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>SignUp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/css/signin.css">
</head>
<body>
<div class="container">

  <form id="signupForm" class="form-signin">
    <h2 class="form-signin-heading">Please sign up</h2>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" name="id" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required>
	<label for="inputName" class="sr-only">Name</label>
    <input type="text" name="name" id="inputName" class="form-control" placeholder="Name" required>
	<label for="inputNickName" class="sr-only">Nick Name</label>
    <input type="text" name="nickname" id="inputNickName" class="form-control" placeholder="Nickname" required>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
  </form>
</div>

<%@ include file="modal.jsp" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<script>
$(document).ready(function() {
	$('#signupForm').submit(function (event) {
		// Stop form from submitting normally
		event.preventDefault();
		
		var id = $("#inputEmail").val();
		var pwd = $("#inputPassword").val();
		var name = $("#inputName").val();
		var nickname = $("#inputNickName").val();
		
		$.post("${contextPath}/signup.do", 
				{ 
				  "id": id, 
				  "pwd": pwd,
				  "name": name,
				  "nickname": nickname
				},
				function(data) {
				    if(data.msg == 'success') {
				    	location.href = "${contextPath}/jsp/login.jsp";
				    } else if(data.msg == 'error') {
					  	var myModal = $('#myModal');
						myModal.find('.modal-title').text('Sign Up Error');
						//myModal.find('.modal-body').text('회원 가입 시 오류가 발생하였습니다.');
						myModal.find('.modal-body').text(data.error);
						myModal.modal();
					}
			    });
	});
});
</script>
	
</body>
</html>