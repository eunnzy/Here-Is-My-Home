<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
	 <h2 style="text-align: center; font-weight: bold;" class="my-5">예약 확인</h2>
	  <div class="container">
	    <div class="row">
	    <c:forEach items="${revList}" var="revList">
	      <div class="col-12">
	        <div class="card bg-light">
	          <div class="card-body">
	            <h4 class="card-title">방문 예약 일자 : ${revList.revDate}</h4>
	            <h6 class="card-subtitle mb-2 text-muted">중개사 : ${revList.lessorId}</h6>
				<p><a href="/home/detail?homeNum=${revList.homeNum} " class="card-text">매물 번호 : ${revList.homeNum}</a></p>
	            <p class="card-text">예약 상태 : ${revList.state}</p>
	            
	            <button class="btn btn-secondary mx-5" type="submit" 
	            onclick = "location.href = '/home/reservation/cancel?revNum=${revList.revNum}&imchaId=${revList.imchaId }'" >신청 취소</button>
	          </div>
	        </div>
	        <p class="mb-2"></p>
	      </div>
	     </c:forEach>
		</div>
	  </div>


  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>