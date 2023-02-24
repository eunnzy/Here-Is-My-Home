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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<link href="/css/bootstrap.min.css" rel="stylesheet"></link>
	<link href="/css/detailHome.css" rel="stylesheet"></link>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
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
							<c:forEach items="${home.homeImgList}" var="imgFile" varStatus="status">
								<c:choose> 
									<c:when test="${status.first}">
										<div class="carousel-item active">
									</c:when>
									<c:otherwise>
										<div class="carousel-item">
									</c:otherwise> 
								</c:choose>
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
					    	<hr>
					    	<div class="user-info mt-3">
				    		<div class="text-center">
					    		 ${home.jgsName} <br> 
					    		중개사 등록번호:  ${home.jgsNum} <br>
						    	 대표명 : ${home.jgsName }  <br>
						    	전화번호: ${home.phone }  <br>
						    	주소:  ${home.lessorAddr }</div>
				    		</div>
				    		<hr>
						   	<div class="col mb-3">
							    <!-- <a href="https://www.flaticon.com/kr/free-icons/" title=" 아이콘"> 아이콘  제작자: Freepik - Flaticon</a> -->
						    	<img src="/icon/siren.png" data-bs-toggle="modal" data-bs-target="#exampleModalLabel" name="reportBtn" id="reportBtn" onclick="report()"> <label for="sirenBtn">허위 매물 신고</label> 
						   	</div>
						    <div class="col mb-3">
							   	<!-- <a href="https://www.flaticon.com/kr/free-icons/" title="심장 아이콘">심장 아이콘  제작자: Freepik - Flaticon</a> -->
						    	<img src="/icon/heart.png" name="likeBtn" id="likeBtn" onclick="homeLike()"> <label for="likeBtn">찜하기</label> 
						    </div>
							    <input type="hidden" name="homeNum" id="homeNum" value="${home.homeNum}">
							    <input type="hidden" name="imchaId" id="imchaId" value="${member.imchaId}">
								<div class="col mb-3">
							    <!-- <a href="https://www.flaticon.com/kr/free-icons/" title=" 아이콘"> 아이콘  제작자: Freepik - Flaticon</a>  -->
						    	<img src="/icon/question.png" name="qnaBtn" id="qnaBtn" onclick="qna()"> <label for="qnaBtn">문의 남기기</label> 
							</div>
							
							<div class="d-grid gap-2 mx-auto mt-3">
								<button type="button" class="btn btn-md btn-success" id="modalBtn"> 예약하기 </button>
							</div>
							</div>
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
									<c:choose>
										<c:when test="${home.rentType == '월세'}">
											<td> ${home.deposit} / ${home.monthly} </td>
										</c:when>	 
										<c:otherwise>
											<td> ${home.deposit}원 </td>
										</c:otherwise> 
									</c:choose>
								</tr>
								<tr>
									<td> 관리비 </td>
									<td> ${home.adminCost}원 </td>
								</tr>
								<tr>
									<td> 주차 </td>
									<c:choose>
										<c:when test="${home.parking > 0 }">
											<td> ${home.parking}대 가능 </td>	
										</c:when>	 
										<c:otherwise>
											<td> 이용 불가 </td>
										</c:otherwise> 
									</c:choose>
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
									<td width="30%"> 방 종류 </td>
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
					
				<div class="location mt-3 mb-2">
					 <h3> <b>위치 정보</b> </h3>
					<div id="map" style="width:100%; height: 350px"></div>
				</div>
				
			</div>
		</div>
		
		<div class="reserv-modal">
			<div class="reserv-wrap">
				<div class="reserv-title">집 방문 예약</div>
				<div class="reserv-close"><i class='bi bi-x-lg'></i></div>
				<div class="reserv-content">
					<table class="table">
						<tr>
							<td style="color: white;"> 이름 </td>
							<td> <input type="text" class="form-control" name="reservName"></td>
						</tr>
						<tr>
							<td style="color: white;"> 방문 날짜 </td>
							<td> <input type="date" class="form-control" name="reservName"></td>
						</tr>
						<tr>
							<td style="color: white;"> 방문 시간 </td>
							<td> <input type="text" class="form-control" name="reservName"></td>
						</tr>
					</table>
				</div>
				<div class="d-grid gap-3 mx-auto">
					<button type="button" class="btn btn-md btn-success" id="reservBtn">예약하기</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a94d4863c9f7363e85ad81dac027db86"></script>
	<script>
		let latitude = ${home.latitude};
		let logitude = ${home.longitude};
	// 위치 정보 표시
	</script>
	<script src="/js/detailHome.js" ></script>
	<script>
		$(document).ready(function() {
			$("#likeBtn").on("click", function(e){
				const $imchaId = $('#imchaId').val();
				const $homeNum = $('#homeNum').val();
				
				$.ajax({
					type : 'get',
					url : 'like/insetLike?imchaId='+ $imchaId + '&homeNum=' + $homeNum,
					success : function (data) {
						if (data===1) {
							alert('찜 목록에 등록되었습니다.');
						} else {
							alert('오류가 발생하였습니다.');
						}
							
						}
				});
			});
		});
	</script>
</body>
</html>