<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="navbar-nav mr-auto"> 
  <li class="nav-item" onmouseover="menu_over(this)" onmouseout="menu_out(this)">
    <a class="nav-link" href="${contextPath}/jsp/creatmemo.jsp">메모장 작성</a>
  </li>
  <li class="nav-item" onmouseover="menu_over(this)" onmouseout="menu_out(this)">
    <a class="nav-link" href="${contextPath}/list.do">메모장조회</a>
  </li>
    <li class="nav-item" onmouseover="menu_over(this)" onmouseout="menu_out(this)">
    <a class="nav-link" href="${contextPath}/saying.do">오늘의 명언</a>
  </li>
</ul>