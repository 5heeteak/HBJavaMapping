<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:set var="ctx" value="${pageContext.request.contextPath }" />
  
	<nav class="aside">
		<h1></h1>
		<ul>
			<li>
				<a href="${ctx}/member/login" >로그인</a>
			</li>
			<li>
				<a href="${ctx}/member/logout" >로그아웃</a>
			</li>
			<li>
				<a href="${ctx}/member/join" >회원가입</a>
			</li>
			<li>
				<a href="${ctx}/author/index">관리</a>
			</li>
			<li>
				<a href="${ctx}/admin/index">관리자페이지</a>
			</li>
		</ul>
	</nav>