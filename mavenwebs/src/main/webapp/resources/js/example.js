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
		img1
		.css({
			width:"300px"
		})
		.css({
			height:"200px"
		});
	});
});












