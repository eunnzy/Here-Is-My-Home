<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>매물 상세 보기</title>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<link href="/css/bootstrap.min.css" rel="stylesheet"></link>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<style>
		body {
			background-color: white;
		}
		.homeImg-div > .carousel-item > img{
			border: 1px solid gray;
			width: 100%;
			min-width: 100%;
      		min-height: 500px;
		}
		#reportBtn, #likeBtn, #qnaBtn {
			cursor: pointer;
		}
		.side-content {
			position: sticky;
			top: 5px;
		}
	</style>
</head>
<body style="background-color:white;">
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
	<div class="container mt-5">
		<div class="col-sm-10 mx-auto">
			<div class="row">
				<div class="col-sm-8 ">
					<div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false">
						<div class="carousel-inner homeImg-div">
							<c:forEach items="${home.homeImgList}" var="imgFile">
								<div class="carousel-item active">
									<img src="/home/getHomeImg?homeImgFile=${imgFile.homeImgPath}/${imgFile.homeImgName}" class="d-block w-100" height="450" alt="...">
								</div>
							</c:forEach>
						</div>
						<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
				<div class="col-sm-4 side-content">
					<div class="card bg-light">
						<div class="card-body">
					    	<h4 class="card-title">
					    		<c:choose>
					    			<c:when test="${home.rentType == '월세'}">
					    				<span class="badge bg-success">${home.rentType}</span>
										${home.deposit} / ${home.monthly}		
									</c:when>	   
									<c:otherwise>
										<span class="badge bg-info">${home.rentType}</span>
										${home.deposit}
									</c:otherwise> 
					    		</c:choose>
					    	</h4>
					    	<h6 class="card-subtitle mb-2 text-muted">${home.addr2 } ${home.addr3 } </h6>
					    	
					    	<div class="user-info mb-2">
						    	<p>
						    		---- User 정보 ------
						    	</p>
						    	<p class="card-text"> 이름 : 
						    	
						    	br</p>
						    	<p class="card-text"> 주소:  </p>
						    	---- User 정보 ------
					    	</div>
						   	<div class="col mb-3">
							    <!-- <a href="https://www.flaticon.com/kr/free-icons/" title=" 아이콘"> 아이콘  제작자: Freepik - Flaticon</a> -->
						    	<img src="/icon/siren.png" data-bs-toggle="modal" data-bs-target="#exampleModalLabel" name="reportBtn" id="reportBtn" onclick="report()"> <label for="sirenBtn">허위 매물 신고</label> 
						   	</div>
						    <div class="col mb-3">
							   	<!-- <a href="https://www.flaticon.com/kr/free-icons/" title="심장 아이콘">심장 아이콘  제작자: Freepik - Flaticon</a> -->
						    	<img src="/icon/heart.png" name="likeBtn" id="likeBtn" onclick="homeLike()"> <label for="likeBtn">찜하기</label> 
						    </div>
							<div class="col mb-3">
							    <!-- <a href="https://www.flaticon.com/kr/free-icons/" title=" 아이콘"> 아이콘  제작자: Freepik - Flaticon</a>  -->
						    	<img src="/icon/question.png" name="qnaBtn" id="qnaBtn" onclick="qna()"> <label for="qnaBtn">문의 남기기</label> 
							</div>
							
							<div class="d-flex text-center mx-auto mt-3">
								<button type="button" class="btn btn-primary"> 예약하기 </button>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-sm-8 mt-4">
					<div class="basic-info">
						<table class="table">
							<thead>
								<tr>
			                  		<th colspan="2"> <h3> <b>기본 정보</b> </h3> </th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td width="30%"> ${home.rentType} </td>
									<td> 
										<c:choose>
											<c:when test="${home.rentType == '월세'}">
												${home.deposit} / ${home.monthly}		
											</c:when>	 
											<c:otherwise>
												${home.deposit}원
											</c:otherwise> 
										</c:choose>
									</td>
								</tr>
								<tr>
									<td> 관리비 </td>
									<td> ${home.adminCost}원 </td>
								</tr>
								<tr>
									<td> 주차 </td>
									<c:if test="${home.parking > 0 }">
										<td> ${home.parking}대 가능 </td>
									</c:if>
								</tr>
								<tr>
									<td> 입주 가능일 </td>
									<td> <fmt:formatDate  value="${home.moveDate}" pattern="yyyy-MM-dd" /> </td>
								</tr>
							</tbody>
						</table>
					</div>
				
				<!-- 상세 정보  -->
					<div class="detail-info mt-3">
						<table class="table">
							<thead>
								<tr>
			                  		<th colspan="2"> <h3> <b>상세 정보</b> </h3> </th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td td width="30%"> 방 종류 </td>
									<td> ${home.homeType } </td>
								</tr>
								<tr>
									<td> 집 면적 </td>
									<td> ${home.homeArea } 평 </td>
								</tr>
								<tr>
									<td> 엘리베이터 </td>
									<td> ${home.elevator } </td>
								</tr>
								<tr>
									<td> 발코니 / 베란다 </td>
									<td> ${home.balcony } </td>
								</tr>
								<tr>
									<td> 반려 동물 </td>
									<td> ${home.pet } </td>
								</tr>
							</tbody>
						</table>
					</div>
				
					<div class="detail">
						<table class="table" >
							<tr>
								<td style="width: 30%;">제목</td>
								<td colspan="2">${home.homeTitle} </td>
							</tr>
					
							<tr>
								<td>내용</td>
								<td colspan="2"> ${home.homeDetail} </td>
							</tr>
						</table>
					</div>
				
			</div>
		</div>
	</div>
</body>
</html>