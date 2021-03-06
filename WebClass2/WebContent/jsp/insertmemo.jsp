<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="org.dimigo.vo.UserVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
	
<script> 

function menu_over(e) {
	e.setAttribute("class", "nav-item active");
}
function menu_out(e) {
	e.setAttribute("class", "nav-item");
}
</script>
	
</head>
<body>
		<%@ include file="modal4.jsp" %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="${contextpath}/jsp/home.jsp">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<%@ include file="menu.jsp"%>

			<c:if test="${empty user}">
				<a class="text-bold text-white" style="text-decoration: none"
					href="${contextPath}/jsp/login.jsp">Sign in</a>
				<span class="text-bold text-white">&nbsp; or &nbsp;</span>
				<a class="text-bold text-white" style="text-decoration: none"
					href="${contextPath}/jsp/signup.jsp">Sign up</a>
			</c:if>
			<c:if test="${!empty user}">
				<ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
					<li class="nav-item dropdown"><a
						class="nav-item nav-link dropdown-toggle mr-md-2" href="#"
						id="bd-versions" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> ${ user.name }님 </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="bd-versions">
							<form action="${contextPath}/logout.do" method="post">
								<button type="submit" class="dropdown-item">Sign out</button>
							</form>
							<div class="dropdown-divider"></div>
							<button type="button" class="dropdown-item">Action1</button>
							<button type="button" class="dropdown-item">Action2</button>
						</div></li>
				</ul>
			</c:if>
		</div>
	</nav>
	
	<div class="jumbotron jumbotron-fluid" style="background-image: url('${contextpath}/jsp/main.jpg');">	
<button onclick="window.open('jsp/trans.jsp', 'naver', 'top=100px, left=100px, height=800px, width=800px')">번역</button>
<form action="${contextpath}/insertmemo.do" method="post">
	<div class="container" style="padding-top: 5px;">
		제목<br><br> 
		<textarea placeholder="제목"
				 style="width: 80%; height: 30px; overflow:hidden;"name="title" required>${sessionScope.title}</textarea>
	</div>
	<div class="container" style="padding-top: 10px;">
		내용<br>
		<br><textarea placeholder="내용 입력..."
				 style="width: 100%; height: 500px;"name="content" required>${sessionScope.content}</textarea>
	</div>
	<div clsss="container" style="padding-top: 50px; padding-left: 20%;">
	<a href="${contextpath}/jsp/home.jsp" style="padding-right: 450px;">최소</a>
		<button type="submit">수정 완료</button>
	</div>
</form>
</div>

	<!-- 	<input type="button"value="확인" onclick="alert(‘Hello, World!’)">
 -->
 
 <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
 
 	<c:if test="${!empty msg}">
		<script>
		var myModal = $('#myModal2');
		myModal.find('.modal-title').text('memo create error');
		//myModal.find('.modal-body').text('Invalid username or password');
		myModal.find('.modal-body').text('메모 제목 중복');
		myModal.modal();
		</script>
	</c:if>
 
</body>
</html>