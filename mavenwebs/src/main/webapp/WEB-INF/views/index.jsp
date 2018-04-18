<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta  name="viewport"  content="width=device-width, initial-scale=1,minimum-scale=1, user-scalable=1">
    
    <link href="resources/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<header class="header">
		<h1>BOOK Book</h1>
		<nav class="main-menu">
			<h1 class="hidden">메인메뉴</h1>
			<ul>
				<li id="ham-button">
					<a href="">
					<img src="${ctx}/resources/img/ic_dehaze_black_24dp_1x.png">
					</a>
				</li>
				<%-- <li><a href=""><img src="${ctx}/resources/img/ic_search_black_24dp_1x.png"></a></li> --%>
				<li><a href="${ctx}/author/note/list">관리</a></li>
				<!-- <li><a href=""><img src=""></a></li> -->
		</ul>
		
		</nav>
	</header>
	
	<nav class="aside">
		<h1></h1>
		<ul>
			<li>
				<a href="${ctx}/member/login" >로그인</a>
			</li>
			<li>
				<a href="${ctx}/member/logout" >로그아웃</a>
			</li>
		</ul>
	</nav>
	
	<main class="main">
		<section class="note-list">
			<h1 class="hidden">NOTE LIST</h1>
			<ul>
			<c:forEach begin="0" end="10">
				<li>
					<div>노트 제목</div>
					<div>노트 내용 ㅁㅗㄱ ㄹㅗㄱ 
					ㅁㅗㄱ ㄹㅗㄱ ㅁㅗㄱ ㄹㅗㄱ 
					ㅁㅗㄱ ㄹㅗㄱ ㅁㅗㄱ ㄹㅗㄱ</div>
					<div><span>분류</span><span> 2018-03-22 12:49</span></div>
				</li>
			</c:forEach>
			</ul>
		</section>
	</main>


</body>
</html>


<script>
	window.addEventListener("load",function(event){
		var button =document.querySelector("#ham-button");
		var aside = document.querySelector(".aside");

		button.onclick = function(e)
		{
			if(aside.classList.contains("show"))
				aside.classList.remove("show");
			else
				aside.classList.add("show");
			e.preventDefault();
		};
		
	});
	
</script>	