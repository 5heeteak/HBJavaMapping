<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" type="text/css" rel="stylesheet" />
<meta  name="viewport"  content="width=device-width, 
initial-scale=1,minimum-scale=1, user-scalable=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="example.js"></script>
</head>
<body>

	<section id="ex7" class="example">
		<h1>사진 갤러리 예제</h1>
		<div class="text-align-center viewer" >
			
		</div>
		<div class="photo-box">
			<ul>
				<li><img class="" src="img/mybatis.png" /></li>
				<li><img class="" src="img/tomcat.png" /></li>
				<li><img class="" src="img/mysql.jpg" /></li>
			</ul>
		</div>
		<div>
			<input class="btn btn-default btn-left" type="button" value="왼쪽" />
			<input class="btn btn-default btn-right" type="button" value="오른쪽" />
		</div>
	</section>

	<section id="ex6" class="example">
		<h1>노드 조작 예제</h1>
		<div class="text-align-center">
			ssssss
		</div>
			
		<div>
			<input class="btn btn-default btn-add" type="button" value="노드 추가" />
			<input class="btn btn-default btn-remove" type="button" value="노드 삭제" />
		</div>
	</section>

	<section id="ex5" class="example">
		<h1>이벤트? 예제</h1>
		<div class="text-align-center">
			<img class="" src="img/mybatis.png" />
			<img class="animate" src="img/tomcat.png" />
			<img class="" src="img/mysql.jpg" />
		</div>
		<div>
			<input class="btn btn-default btn-ok" type="button" value="확인" />
			<input class="btn btn-default btn-css" type="button" value="css 애니메이트" />
		</div>
	</section>

	<section id="ex4" class="example">
			<h1>효과주기 예제</h1>
			<div class="text-align-center">
				<img class="" src="img/mybatis.png" />
				<img class="animate" src="img/tomcat.png" />
			</div>
			<div>
				<input class="input" type="text" list="img-list" />
				<datalist id="img-list">
					<option>ssy</option>
					<option>mybatis</option>
					<option>donut</option>
					<option>hanbit</option>
					<option>answeris</option>
				</datalist>
				<input class="btn btn-default btn-ok" type="button" value="확인" />
				<input class="btn btn-default btn-css" type="button" value="css 애니메이트" />
			</div>
		</section>
		
	<section id="ex3" class="example">
		<h1>속성, 스타일 수정 예제</h1>
		<div class="text-align-center">
			<img src="img/mybatis.png" />
		</div>
		<div>
			<input class="input" type="text" list="img-list" />
			<datalist id="img-list">
				<option>ssy</option>
				<option>mybatis</option>
				<option>donut</option>
				<option>hanbit</option>
				<option>answeris</option>
			</datalist>
			<input class="btn btn-default btn-ok" type="button" value="확인" />
			<input class="btn btn-default btn-toggle" type="button" value="토글" />
		</div>
	</section>
	
	<section id="ex2" class="example">
		<h1>이벤트 처리 예제</h1>
		<div>
			<input class="btn btn-default" type="button" value="확인" />
		</div>
	</section>
	
	<!-- example 1 - 노드 선택 -->
	<section id="ex1" class="example">
		<h1>노드 선택 예제</h1>
		<div>
			<input class="btn btn-default" type="button" value="확인" />
		</div>
	</section>
	
</body>
</html>