<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="./bootstrap.min.css" rel="stylesheet"></link>
    <title>Document</title>
</head>
<body style="height: 100; width: 100;">
  <header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>


  <!-- body -->

  <h2 style="text-align: center; font-weight: bold;" class="my-5">매물 관리</h2>

  <div class="container">
    <div class="row ">
    <c:forEach items="${manageList}" var="manageList">
      <div class="col-12">
        <div class="card bg-light mb-3">
          <h3 class="card-header">${manageList.homeTitle}</h3>
          <div class="card-body">
            <h5 class="card-title">${manageList.homeType }</h5>
            <h6 class="card-subtitle text-muted">${manageList.rentType }</h6>
            <p></p>
            <h6 class="card-subtitle text-muted">보증금 : ${manageList.deposit }, 월세 : ${manageList.monthly}</h6>
          </div>
          <svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="200" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">
            <rect width="100%" height="100%" fill="#868e96"></rect>
            <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
          </svg>
          
          <ul class="list-group list-group-flush">
            <li class="list-group-item">${manageList.addr2} ${manageList.addr3}</li>
          </ul>
          <div class="card-body">
            <a href="/home/manage/modify?homeNum=${manageList.homeNum}" class="card-link">수정</a>
            <a href="#" class="card-link">삭제</a>
          </div>
         <!--  <div class="card-footer text-muted">
            2 days ago
          </div> -->
        </div>
      </div>
     </c:forEach>
     
    </div>
  </div>

  <div style="bottom: 30px; width: 78rem; margin-left: auto; margin-right: auto;">
    <button type="button" class="btn btn-secondary mr-2 my-2" style="float: right;" onclick = "location.href = 'home/manage/registerHome' ">매물 등록</button>
  </div>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>