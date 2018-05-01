<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <c:set var="ctx" value="${pageContext.request.contextPath }" />
  
	<nav class="aside">
		<!-- not-authenicated -->
		<!-- 인증 정보 확인 작업 -->
		
		<sec:authorize access="!isAuthenticated()">
		<section class="not-authenticated">
			<h1>
				<img src="${ctx}/resources/img/bg-profile.png"/>
			</h1>
			<h2>로그인 정보를 내놔라</h2>
			<div>
				<a href="${ctx}/member/login" class="btn">MavenPubs Login</a>
			</div>
			
		</section>
		</sec:authorize>
		
		<!-- authenicated -->
		<sec:authorize access="isAuthenticated()">
		<section class="authenticated">
			<h1></h1>
		</section>
		</sec:authorize>
	
		<%-- <h1></h1>
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
		</ul> --%>
	</nav>
	
	
	