<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main class="main note detail">
		<article class="note-list">
			<header>
				<h1>${note.title}</h1>
				<h2>컴퓨터프로그래밍</h2>
			</header>
			<footer>
				<span>0</span>
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