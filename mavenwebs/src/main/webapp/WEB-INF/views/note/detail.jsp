<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />  
	<main class="main note-detail">
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
		
		<section>
			<h1 class="hidden"> 댓글 입력 폼 </h1>
			<h2> 댓글이나 쓰고 가라 </h2>
			<form action="${note.id}/comment/reg" method="post">
				<section>
					<div>
						<label class="hidden" >작성자</label>
						<input type="text" placeholder="작성자" name="nic-name"/>
						<label class="hidden" >비밀번호</label>
						<input type="password" placeholder="비밀번호" name="pwd"/>
					</div>
					<div>
						<label class="hidden" >댓글</label>
						<textarea rows="1" cols="50" name="content"></textarea>
					</div>
					<div>
						<input type="checkbox" id="secret-option"/>
						<label> 비밀 댓글 </label>
						<input type="submit" value="취소"/>
						<input type="submit" value="등록"/>
					</div>
				</section>
			</form>
		</section>
		
		<section>
			<h1>comment : ${note.commentCount} 개!!!!!! </h1>
			<ul>
				<c:forEach var="c" items="${note.comments}">
					<li>
						<table border="1">
							<tr>
								<td rowspan="2">이미지</td>
								<td>
									<span>${c.writerId}</span>
									<span>${c.regDate}</span>
									<span></span>
								</td>
							</tr>
							<tr>
								<td>${c.content}</td>
							</tr>
						</table>
					</li>
				</c:forEach>
			</ul>
		</section>
		
		<nav>
			<h1></h1>
			<ul>
				<li>
					<c:if test="${not empty note.prev}">
						<a href="${note.prev.id}">이전 글 : ${note.prev.title}</a>
					</c:if>
					<c:if test="${empty note.prev}">
						<span>이전글 없음</span>
					</c:if>
				</li>
				<li>
					<c:if test="${not empty note.next}">
						<a href="${note.next.id}">다음 글 : ${note.next.title}</a>
					</c:if>
					<c:if test="${empty note.next}">
						<span>이전글 없음</span>
					</c:if>
				</li>
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