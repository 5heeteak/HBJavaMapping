<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />  
	<main class="main note detail">
		<article class="note-list">
			<header>
				<h1>${note.title}</h1>
				<h2>컴퓨터프로그래밍</h2>
			</header>
			<footer>
				<span><fmt:formatDate pattern="yyyy-MM-dd일 aHH:mm" value="${note.regDate}"/>  </span>
			</footer>
			<div>
				${note.content}
			</div>
		</article>
		<nav class="btn-list">
			<h1 class="hidden">버튼버튼</h1>
			<ul>
				<li id="sel-button">선택</li>
				<li id="edit-button"><a href="" >수정</a></li>
				<li id="del-button"><a href="" >삭제</a></li>
			</ul>
		</nav>
		<section>
			<h1 class="hidden">버튼</h1>
			<div>
				<a href="${note.id}/like" class="btn btn-like">좋아요!!!!</a>
			</div>
		</section>
</main>


<script>
	window.addEventListener("load",function(){
	
		var selBtn = document.querySelector("#sel-button");
		var editBtn = document.querySelector("#edit-button");
		var delBtn = document.querySelector("#del-button");

		selBtn.onclick = function(){

			if(editBtn.className == "")
			{
				editBtn.classList.add("show");
				delBtn.classList.add("show");
			}
			else
			{
				editBtn.classList.remove("show");
				delBtn.classList.remove("show");
			}
			
		};

	});
	
</script>