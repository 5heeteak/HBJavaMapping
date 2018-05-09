//example7 - 사진 갤러리
//event (object, bubble, capture, trigger), ajax, dom 점검
$(function(){
	var leftBtn = $("#ex7 .btn-left");
	var rightBtn = $("#ex7 .btn-right");
	var viewer = $("#ex7 .viewer");
	var photoBox = $("#ex7 .photo-box")
	var photoList = $("#ex7 .photo-box > ul");
	//PhotoList.css("left","0px");
	
	var width = photoList.width(); 
	
	/*var img = photoList.find("img").first();
	img.click(function(){
		alert("imgimg");
	});
	
	photoList.click(function(){
		alert("ListList");
	});*/
	
	leftBtn.click(function()
	{
		photoList.css("left","-=200px");
		width -= 200;
		
		
	});
	
	rightBtn.click(function()
	{
		photoList.css("left","+=200px");
		width += 200;
		
	});
	
	
		photoList.on("transitionend",function()
		{
			if(width <= 400 || width >= 800)
				{
					alert("EyaHO");
				}
			//if
			//alert("last");
		});
	/*photoList.find("img").click(function(){
		이미지 클릭 시 이벤트 발생 
		이미지에 직접 이벤트 작성
	});*/
	
	//모든 img 엘리먼트에 각각 click 이벤트를 바인딩
	/*photoList.find("img").click(function(e){
		//$(e.target); -> var target = $(e.target);
		//this -> var target = $(this);
		var target = $(e.target);
		
		$("<img />")
			.attr("src", target.attr("src"))
			.appendTo(viewer);
		
	});*/
	
	//이벤트 바인딩 개선 -> bubbling
	photoList.click(function(){
		//alert(event.currentTarget.tagName);
		//alert(event.target.tagName);
	});
	
	/*photoList.click(function(e){
		var target = $(e.target);
		
		viewer.empty();
		
		$("<img />")
		.attr("src", target.attr("src"))
		.appendTo(viewer);
	});*/
	//이미지를 클릭 했을 때 처리해야할 기본 행위
	photoList.get(0).addEventListener("click",function(e){
		var target = $(e.target);
		
		viewer.empty();
		
		$("<img />")
		.attr("src", target.attr("src"))
		.appendTo(viewer);
		
		//공통 속성 적용
		target.css("border","1px solid red")
		
	}, true);
	
	/*특정 이미지는 다른 일을 할 수 있다.
		- 추가적인 일 
		- 순서가 필요한 일
		- 배타적인 일*/
	photoList.find("img").get(1).addEventListener("click",function(e){
		// 추가 기능?
		//선택된 이미지 경계선 색 변경
		/*var target = $(e.target);
		target.css("border","1px solid aqua");*/
		
		// 순서 기능 (버블링일 경우 자식먼저, 캡처링일 경우 부모 먼저)
		var target = $(e.target);
		target.css("border","1px solid aqua");
		
		// 배타적 기능
		e.stopPropagation();
	});
});

//example6 - 노드조작
$(function(){
	var addBtn = $("#ex6 .btn-add");
	var removeBtn = $("#ex6 .btn-remove");
	var box = $("#ex6>div:nth-child(2)");
	
	addBtn.click(function()
	{
		//box.css("background","black");
		//1. text 노드 추가
		/*var text = "이이이이야야야야야";
		box.append(text);*/
		
		//2. img 노드 추가
		/*
		$(img)					-> wrapping
		$("img")				-> selecting
		$("<img />")		-> creating
		*/
		//2-1. 노드 추가 방법
		/*var img = $("<img />")
							.attr("src","img/mysql.jpg");
		box.append(img);*/
		
		//2-2 appendTo 이용
		$("<img />")
				.attr("src","img/mysql.jpg")
				.appendTo(box);	
	});
	
	removeBtn.click(function()
	{
		//3. 노드 삭제
		//box
		//방법 1
		/*.children() //Box의 DOM 자식들을 담는 객체 중 하나
		.first()*/
		//방법 2.
		//.children(":first-child") //Box의 자손들 중 첫번째
		//.remove
		//방법 3.
	/*	find(":first-child") //Box의 자손들 중 첫번째
		.remove();			// 중첩 구조일 경우에 여러 객체가 선택*/		
		
		//-------------------------------------------------------------
		//삭제 2
		//box.$("img").remove(":first-child");
		
		//삭제 3
		box.empty();
	});
	
});


//example5 - 슬라이드?
$(function(){
	var okBtn = $("#ex5 .btn-ok");
	
	okBtn.click(function(){
		
	});
	
});


//example 0 - 초기화 블럭
//window.addEventListener("load",function(){});
//$(window)
//jquery(window)

$(function()
{
	//alert("message");	
});

//example 1 - 노드 선택

$(function()
{
	//var okBtn = document.querySelector("#ex1 .btn-default");
	var okBtn = $("#ex1 .btn-default");
	okBtn.val("HOHOHOHOHOHOHO");	
});

//example 2 - 이벤트 처리

$(function()
{
	var okBtn = $("#ex2 .btn-default");
	/*okBtn.on("click",function(){
		alert("message");
	});*/
	
	okBtn.click(function(){
		okBtn.val("버튼!!");
		alert("버튼 바꾸기");
	});

});

//example 3 -속성, 스타일 수정

$(function()
{
	var okBtn = $("#ex3 .btn-ok");
	var img =$("#ex3 img");
	var textBox = $("#ex3 input[type=text]");
	var toggleBtn =$("#ex3 .btn-toggle");
	
	okBtn.click(function(){
		//img.attr("src","img/1234.png");
		//var imgName = textBox.attr("val");
		/*var imgName = textBox.val();
		img.attr("src","img/"+ imgName +".png");*/
		
		//스타일 한번에 적용
		/*img.css("width", "300px");
		img.css("height", "100px");
		img.css("box-shadow", "#979797 3px 3px 3px");*/
		
	/*	var imgStyle = {
				width: "300px",
				height: "100px",
				"box-shadow": "#979797 3px 3px 3px"
		};
		
		img.css(imgStyle);*/
		
		//정적 스타일 변경
		
		img.addClass("zoom-in");
	});
	
	toggleBtn.click(function()
	{
		if(img.hasClass("zoom-in"))
			img.removeClass("zoom-in");
		else
			img.addClass("zoom-in");
		
	});

});


//example 4 - 효과주기

$(function()
{
	var okBtn = $("#ex4 .btn-ok");
	var cssBtn = $("#ex4 .btn-css");
	var img1 =$("#ex4 img:nth-child(1)");
	var img2 =$("#ex4 img:nth-child(2)");
	
	okBtn.click(function()
	{
		//1.css 변화에 duration
		/*var imgStyle = 
		{
				width: "300px",
				height: "100px",
				"box-shadow": "#979797 3px 3px 3px"
		};
		
		img.animate(imgStyle,50000);*/
		
		
		//2. css의변화에 순서를 주기
	/*	img1.animate({
			width:"200px"
		})
		.animate({
			heigth:"100px"
		})
		});*/
		/*img2
			.delay(800)
			.animate({
			width:"200px",
			height:"100px"
		});*/
		
		
		//3. callback 
		img1.animate({
			width:"200px"
		},function(){
			img2
			.animate({
				width:"200px",
				height:"200px"
			});	
		})
		.animate({
			height:"200px"
		},2000);
		
		
	});
	
	cssBtn.click(function(){
		/*img1
		.css({
			width:"300px"
		})
		.css({
			height:"200px"
		});*/
		/*if(!img1.hasClass("anmiate1"))
			img1.addClass("animate1");
		else
			img1.removeClass("animate1");*/
		
		/*img2.removeClass("animate1");
		img1.removeClass("animate1");
		setTimeout(function(){
			img2.addClass("animate1");
			img1.addClass("animate1");
		},10);*/
		
		img2.on("animationend",function(){
			img2.removeClass("animate1");
		});
		img2.addClass("animate1");
	});
});












