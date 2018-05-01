<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta  name="viewport"  content="width=device-width, initial-scale=1,minimum-scale=1, user-scalable=1">
    
    <link href="resources/css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<jsp:include page="inc/header.jsp" />
	
	<!-- aside -->
	<jsp:include page="inc/aside.jsp" />
	
	<!-- visual -->
	<section class="visual">
		<h1></h1>
	</section>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(function(){
			
			var shutter = $(".shutter");
			
			var content = $(".shutter ul");
			var shutterBtn = $(".shutter-btn-box > span");
			
			
			/* var wrapper = $("<div />");
			shutter 안에 있는 엘리먼트를 wrapper 안으로 옮기고 wrapper를 shutter의 자식으로 추가
			wrapper
				.html(shutter.html());
			
			
			
			shutter.empty().append(wrapper); */
			
			content.detach();
			
			var clipper = $("<div />")
									.append(content)
									.appendTo(shutter)
									.css("overflow","hidden");
			
			var shutterContent = $(".shutter > div > ul");
			shutterContent.css("transition","1.5s");
			
			
			if(${visited})
			{
				shutterContent.css("margin-top",-shutter.outerHeight()+"px");
			} 
			
			shutterBtn.click(function(){
				//shutter.css("overflow","hidden");
				shutterContent.css("margin-top",-shutter.outerHeight()+"px");
				
			});
			
			shutterContent.on("transitionend", function(){
				
				var marginTop = parseInt(shutterContent.css("margin-top"));
				console.log(marginTop);
				
				if(marginTop < 0)
					shutterBtn.css("background","#1bc2fa url('/mavenwebs/resources/img/ic_expand_more_black_24dp_1x.png') no-repeat center");
					
				else
					shutterBtn.css("background","#1bc2fa url('/mavenwebs/resources/img/ic_expand_less_black_24dp_1x.png') no-repeat center");
				
			});
			
		});
		
		$(function(){
			var categoryViews = $(".category-views section");
			var categoryBtn = $(".category > ul");
			
			categoryBtn.click(function(e)
			{
				if(e.target === e.currentTarget)
					return;
				
				var target = e.target;
				
				if(target.nodeName == "A")
					target=target.parentNode;				
				
				var viewName = target.dataset.viewName;
				
				//view 객체 얻기
				var view = $("."+viewName);
				
				view.css("border","1px solid red");
				
				
				//view를 보여주기
				//1. 모든 view에 hidden 추가
				categoryViews.addClass("hidden");
				
				//2. 필요한 view만 hidden 제거
				view.removeClass("hidden");
				/* 
				if(	view.hasClass("hidden"))
					view.removeClass("hidden");
				else
					view.addClass("hidden"); */
				
				//view가 null이라면
				// ajax로 가져오기
				/* if(view == null)
				{
					
				} */
				
				
			});
			
		});
	</script>
	<section class="mavenpubs shutter"> <!-- cliper -->
		<h1 class="hidden">서비스 안내</h1>
		<div class="shutter-btn-box">
			<span class="">More</span>
		</div>
		<ul>
			<li>
				<article>
					<h1>Note?</h1>
					<!-- <h2>
						기록된 지식은 사라지지 않는다.
						그것이 누적되면 나를 성장시키는 자산이 된다.
						알게된 지식을 기록하여라.
					</h2> -->
					<div>
						<img src="${ctx}/resources/img/notes-sm.png" />
					</div>
				</article>
			</li>
			
			<li>
				<article>
					<h1>Book?</h1>
					<h2>
						단편적으로 기록한 노트를 엮어서 모아라.
						그러면 하나의 책이 될 것이다.
						책은 지식을 체계적으로 이해하고 정리하는데 도움이 될 것이다.
					</h2>
					<div>
						<img src="${ctx}/resources/img/book-sm.png" />
					</div>
				</article>
			</li>
			
			<li>
				<article>
					<h1>Open?</h1>
					<div></div>
				</article>
			</li>
			
			<li>
				<article>
					<h1>Publish?</h1>
					<div></div>
				</article>
			</li>
		</ul>
	</section>
	
	<!-- main -->
	<main class="main">
		<section class="category">
			<h1>카테고리</h1>
			<ul>
				<li data-view-name="note-list"><a href="">노트</a></li>
				<li data-view-name="book-list"><a href="">책</a></li>
				<li data-view-name="published-book-list"><a href="">출간본</a></li>
			</ul>
		</section>
		<div class="category-views">
			<section class="note-list hidden">
	         <h1 class="hidden">공개노트 목록</h1>
	         <ul class="">
	            <li><a href="note/list">노트보기</a></li>
	         </ul>
	      </section>
	      
	      <!-- <section class="book-list hidden">
	         <h1 class="hidden">공개 북 목록</h1>
	         <ul class="">
	            <li><a href="note/list">책 보기</a></li>
	         </ul>
	      </section> -->
	      
	      <section class="published-book-list hidden">
	         <h1 class="hidden">출간된 책 목록</h1>
	         <ul class="">
	            <li><a href="note/list">책 보기</a></li>
	         </ul>
	      </section>
      </div>
	</main>
	
	<!-- footer -->
	<jsp:include page="inc/footer.jsp" />

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