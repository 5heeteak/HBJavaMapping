<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main class="main">
		<article class="note-list">
			<h1 class="hidden">NOTE LIST</h1>
			<ul>
				<li>
					<div><span>제목 : </span>${note.title}</div>
					<div><span>작성자 : </span>${note.id}</div>
					<div><span>조회수 : </span>${note.hit}</div>
					<div>${note.content }</div>
					<div><span>${note.order}</span></div>
					<div><span> ${note.regDate }</span></div>
				</li>
			</ul>
			<div>
				<input type="button" value="수정" onclick="location.href='../list/${note.id}/edit'"/>
				<input type="button" value="목록" onclick="location.href='list'" />
			</div>
		</article>
	</main>
