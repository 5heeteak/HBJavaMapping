<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:set var="ctx" value="${pageContext.request.contextPath }" />
  
<header class="header">
	<h1><a href="${ctx}/index"><img src="${ctx}/resources/img/logo-ldpi.png" /></a></h1>
	<nav class="main-menu">
		<h1 class="hidden">메인메뉴</h1>
		<ul>
			<li id="ham-button">
			<a href="">
			<img src="${ctx}/resources/img/ic_dehaze_black_24dp_1x.png">
			</a>
			</li>
			<%-- <li><a href=""><img src="${ctx}/resources/img/ic_search_black_24dp_1x.png"></a></li> --%>
			
			<!-- <li><a href=""><img src=""></a></li> -->
		</ul>
	</nav>
</header>
	
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
	