<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<main class="main">
		<section class="note-list">
			<h1 class="hidden">NOTE LIST</h1>
			<ul>
			<c:forEach var="note" items="${notes}">
				<li>
					<div><a href="${note.id}">${note.title}</a></div>
					<div >
						<span class="text-concat">${note.content }
						<span class="text ellipsis">...</span>
						</span>
					</div>
					<div><span>0</span><span> ${note.regDate }</span></div>
				</li>
			</c:forEach> 
			</ul>
		</section>
		<nav class="btn-list">
			<h1 class="hidden">버튼버튼</h1>
			<ul>
				<li id="add-button"><a href="reg" >추가</a></li>
			</ul>
		</nav>
	</main>
