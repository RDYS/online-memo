<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap css -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

</head>
<body>
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

			<form action="${contextpath}/searchmemo.do" method="post">
			  <input class="form-control mr-sm-2" type="text" placeholder="검색..." aria-label="Search"  name="search" style="display:align;">
			  <button type="submit" style="display:align; position : relative; bottom:32px; left : 220px;">검색</button>
			</form>

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
			<%@ include file="modal3.jsp" %>
	

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th width="10%">#</th>
					<th width="30%">date</th>
					<th width="60%">title</th>
				</tr>
			</thead>
			<tbody>
				<%--<c:if test="${list != null}">--%>
				<c:if test="${!empty list}">
					<c:forEach var="item" items="${list}" varStatus="status">
						<tr>
							<th>${status.count}</th>
							<td>${item.year}-${item.month}-${item.day}</td>
							<td><a
								href="${contextPath}/getmemo.do?title=${ item.title }">${item.title}</a></td>
							<td><a
								href="${contextpath}/deletememo.do?title=${ item.title }">삭제
							</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<%--<c:if test="${list == null || list.size() == 0}">--%>
				<c:if test="${empty list}">
					<tr>
						<td colspan="4" align="center">데이터가 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>

<c:if test="${empty user}">
		<script>
		var myModal = $('#myModal1');
		myModal.find('.modal-title').text('Login First');
		//myModal.find('.modal-body').text('Invalid username or password');
		myModal.find('.modal-body').text('로그인을 먼저 해주십시오.');
		myModal.modal();
		</script>
	</c:if>

</body>
</html>