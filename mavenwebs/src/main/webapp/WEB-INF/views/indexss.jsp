<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="root" value="${pageContext.request.contextPath }"  />
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
   <meta  name="viewport" 
      content="width=device-width, initial-scale=1,minimum-scale=1,user-scalable=1"    
   >

   <title>Insert title here</title>
   <link href="${root}/resources/css/indexss.css" type="text/css" rel="stylesheet">
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
         var shutterContent = $(".shutter ul");
         var shutterButton = $(".shutter-button-box > span");
                  
         /* var wrapper = $("<div />");         
         // shutter 안에 있는 엘리먼트들을 wrapper 안으로 옮기고 wrapper를 shutter으로 자식으로
         wrapper
            .html(shutter.html());
         
         shutter
            .empty()
            .append(wrapper);   
         
         var shutterButton = $(".shutter-button-box span"); */
         
         shutterContent.detach();
         var clipper = $("<div />")
                        .append(shutterContent)
                        .appendTo(shutter)
                        .css("overflow", "hidden");   
         
         shutterContent.css("transition", "1s");
         
         // 초기 상태(펼칠것인지, 접을 것인지) : visited의 값을 이용해서
         if(${visited}){            
            shutterContent.css("margin-top", -shutter.outerHeight()+"px");            
         }
         
         shutterButton.click(function(){         
            
            shutterContent.css("margin-top", -shutter.outerHeight()+"px");
            
         });
         
         shutterContent.on("transitionend", function(){
            
            // 이부분도 신경써야 할 부분이 있어서 지움.
            var marginTop = parseInt(shutterContent.css("margin-top"));
            console.log(marginTop);
            
            if(marginTop < 0)
               shutterButton.css("background", 'rgb(67,107,67) url("resources/images/ic_expand_more_black_24dp_1x.png") no-repeat center');
            else
               shutterButton.css("background", 'rgb(67,107,67) url("resources/images/ic_expand_less_black_24dp_1x.png") no-repeat center');
         });
         
      });
      
      // tab-switch
      $(function(){
         var categoryViews = $(".category-views");
         var categoryList = $(".category ul");
         var ajaxIcon = null;
         var views = categoryViews.children(); // 뷰의 목록이 달라지면 ..갱신
         var oldView = views.eq(0);
         
         categoryList.click(function(e){
            
            if(e.target === e.currentTarget)
               return;            
            
            var target = e.target;
            
            if(target.nodeName == "A"){
               target = target.parentNode;
               e.preventDefault();
            }
            
            if(ajaxIcon != null){
               alert("처리중입니다.");
               return;
            }
                        
            var viewName = target.dataset.viewName;
            
            // view 객체 얻기
            var view = $("."+viewName);
            //view.css("border", "1px solid red");            
                        
            // 1. CSS로 초기 상태 만들기
            // - view들의 position이 모두 absolute로 겹치게 한다.
            // - view들의 부모는 현재 view의 높이와 같게 한다.
            //    단. 그 높이는 실행해봐야 아는 문제이므로 스크립트로 처리한다.
            
            // 1,2,3
            // 1. 선택된 놈을 오니쪽으로 위치시키고 z 축 제일 위로 올라가도록 .
            views.css({
               zIndex:"1"
            });
            
            oldView.css({
               zIndex:"2"
            });
            
            view.css({
               left:"-90%",
               zIndex:"3"
            });
            
            
            // 2. 그 놈의 높이로 부모 영역의 높이를 맞추고
            categoryViews.animate({
               height : view.height()
            }, 400);
            
            // 3. 그 놈이 천천히 밀고 들어온다.
            
            
            
            
            
            
            
            
            //view가 null 이라면
               // ajax로 가져오기
            /* if(view.length == 0){
               
               ajaxIcon = $("<img />")
                              .attr("src", "resources/images/ajax-loader2.gif")
                              .css({
                                 position:"absolute",
                                 left:"17px",
                                 top:"20px"
                              })
                              .appendTo(target);
               
               
               $.get(viewName + "-partial", function(data){
               
                  var html = categoryViews.html();
                  categoryViews.html(html+data);
                  
                  var views = categoryViews.find("section");
                  var height = Math.max(views.eq(0).height(),views.eq(1).height());                  
                  views.css("height", height);
                  
                  view = categoryViews.find("."+viewName);
                                    
                  view
                     .addClass("show")
                     .animate({
                           right:"0px"
                        }, 400, function(){
                           view
                           .css({
                              position:"static",
                              height:"auto"
                           })
                           .prev()
                           .remove();
                           
                        });
                  
                  ajaxIcon.remove();
                  ajaxIcon = null;
                  
               });
            }
            else
               view
               .addClass("show")
               .animate({
                     right:"0px"
                  }, 400); */
            
            //categoryViews.load("book-list-partial");
               
            // view를 show 하기
            // 1. 모든 view에 hidden을 추가하고            
            // categoryViews.children("section").addClass("hidden");
            // 2. 현재 필요한 view만 hidden을 제거한다.            
            //view.removeClass("hidden");
            
            oldView = view;
         });
      });
   </script>
   <section class="notepubs shutter"> <!-- clipper -->      
      <h1 class="hidden">서비스 안내</h1>
      <div class="shutter-button-box" style="position: relative;">
         <span class="">확장/축소</span>
      </div>
      <ul>
         <li>
            <article>
               <h1>NOTE</h1>
               <h2>
                  스스로 새롭게 알게된 지식은 노트로 기록해 보세요.
                  기록된 지식은 사라지지 않습니다.
                  그것이 누적되면 나를 성장시키는 큰 자산이 됩니다.
               </h2>
               <div>
                  <img src="resources/images/notes-sm.png" />
               </div>
            </article>
         </li>
         <li>
            <article>
               <h1>BOOK</h1>
               <h2>
                  단편적으로 기록한 노트들을 엮어서 관련있는 것들로 모아보세요.
                  그러면 하나의 책이 됩니다.
                  책은 지식을 체계적으로 이해하고 정리하는데 도움이 됩니다.
               </h2>
               <div>
                  <img src="resources/images/book-sm.png" />
               </div>
            </article>
         </li>
         <li>
            <article>
               <h1>OPEN</h1>
               <div></div>
            </article>
         </li>
         <li>
            <article>
               <h1>PUBLISH</h1>
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
            <li data-view-name="published-list"><a href="">출간본</a></li>
         </ul>
      </section>
      <div class="category-views">
         <section class="note-list">
            <h1 class="hidden">공개노트 목록</h1>
            <ul class="">
               <c:forEach var="note" items="${notes}">
                  <li>
                     <div><a href="${note.id}">${note.title}</a></div>
                     <div>
                        ${note.content}
                     </div>               
                     <div><span>분류</span><span>${note.regDate}</span><span>(${note.commentCount})</span></div>
                  </li>
               </c:forEach>         
            </ul>
         </section>
         <section class="book-list">
            <h1 class="hidden">공개북 목록</h1>
            <ul class="">
               <li><a href="note/list">책...</a></li>            
            </ul>
         </section>
         <section class="published-list">
            <h1 class="hidden">출간된책 목록</h1>
            <ul class="">
               <li><a href="note/list">출간본 1...</a></li>
               <li><a href="note/list">출간본 2...</a></li>
               <li><a href="note/list">출간본 3...</a></li>
               <li><a href="note/list">출간본 4...</a></li>            
            </ul>
         </section>
      </div>
   </main>
   <!-- footer -->   
   <jsp:include page="inc/footer.jsp" />
</body>
</html>


   
   