<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.dimigo.vo.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home</title>	
<!-- Bootstrap css -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>

<style>
html, body {
	height: 100%
}
div.container {
	padding-top: 30px;
	padding-bottom: 20px;
}
</style>

<script>
	function menu_over(e) {
		e.setAttribute("class", "nav-item active");
	}
	function menu_out(e) {
		e.setAttribute("class", "nav-item");
	}
</script>

<script type="text/javascript">
</script>

</head>
<body>
	<!-- navbar-dark bg-dark !-->	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Home</a>
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
	<!-- <div style="width: 100%; display: flex; height: 93.7%;">
		<div style="width :3%; height:100%;background-color:silver;" >
		<button data-activates="slide-out" class="button-collapse"><img src="${contextPath}\jsp\book.png" width="40px" height="40px"></button>
		<div style="padding-top:200px">
		<button><img src="${contextPath}\jsp\calc.png"width="40px" height="40px"> </button></div>
		<div style="padding-top:200px">
		<button><img src="${contextPath}\jsp\Magnifier.png"width="40px" height="40px"> </button> </div>
		</div>	
		<div style="width :97%; height:100%;">
		<img src="${contextpath}/jsp/sky.jpg"  style="width:100%; height:100%;">
		</div>
	</div> -->
			<div class="jumbotron jumbotron-fluid" style="width:100%; height:92.9%; background-image: url('${contextpath}/jsp/sky.jpg'); background-size: cover;">
				<h3 style="color:white;">메모를 열심히 하자!!</h3>	
	</div>
	<%@ include file="modal.jsp"%>

<script>
$('.button-collapse').sideNav({
    menuWidth: 300, // Default is 240
    edge: 'left', // Choose the horizontal origin
    closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
  }
);
</script>

</body>
</html>