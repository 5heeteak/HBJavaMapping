<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="ctx" value="${pageContext.request.contextPath }" />
<main class="main">
	<section>
		<h1 class="hidden">로그인 폼</h1>
		<form action="${ctx}/login" method="post">
			<fieldset>
				<legend>로그인 필드</legend>
				<table>
					<tr>
						<th>아이디 : </th>
						<td><input type="text" name="username" placeholder="아이디를 입력해"  /></td>
					</tr>
					<tr>
						<th>비밀번호 : </th>
						<td><input type="password" name="password" placeholder="비밀번호를 입력해"   /></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</section>
</main>
