<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="bs-docs-section row">
			<div class="col-lg-12">
				<br><br>
				<h1 id="tables" style="text-align: center;">신고매물 목록</h1>
				<br><br>
				
				<div class="bs-component">
					<table class="table table-hover" style="text-align: center">
					<tr>
						<th scope="col" style="width: 15%;">신고 번호</th> 
						<th scope="col" style="width: 15%;">매물 번호</th> 
						<th scope="col" style="width: 15%;">신고자</th>
						<th scope="col" style="width: 15%;">신고 유형</th> 
						<th scope="col" style="width: 30%;">신고 내용</th> 
						<th scope="col" style="width: 15%;">신고 날짜</th>
						</tr>
						<c:forEach var="Home" items="${list }">
						<tr>
					<%-- 		<td>${ }</td>
							<td>${ }</td>
							<td>${imcha.imchaId }</td>
							<td>${ }</td> --%>
						</c:forEach>
						  
				</div>
			</div>
		</div>
	</div>
</body>
</html>