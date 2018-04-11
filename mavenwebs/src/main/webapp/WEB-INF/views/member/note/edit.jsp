<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main class="main">
			<section>
				<h1 class="hidden">노트 등록 폼</h1>
				<form method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<th>제목</th>
						</tr>
						
						<tr>
							<td><input type="text" value="${note.title}" name="title"/></td>
						</tr>
						
						<tr>
							<th>첨부파일</th>
						</tr>
						
						<tr>
							<td><input type="file" name="file"/></td>
						</tr>
						
						<tr>
							<th>내용</th>
						</tr>
						
						<tr>
							<td>
								<textarea rows="10" cols="40" name="content" >${note.content}
								</textarea>
							</td>
						</tr>
					</table>
					<div>
						<input type="submit" value="수정" />
						<input type="button" value="목록" onclick="location.href='../../list'" />
					</div>
				</form>
			</section>
		</main>
		
		<script>

	window.addEventListener("load",function(event){

		var submitBtn = document.querySelector("input[type='submit']");
		var title = document.querySelector("input[name='title']");

		submitBtn.onclick = function(e){
			
			var request = new XMLHttpRequest();
			request.onload = function(evt){
				//title.value = request.responseText;
				alert(request.responseText);
			}

			request.open("GET","data");
			request.send();
			
			e.preventDefault();
		};

	});

</script>