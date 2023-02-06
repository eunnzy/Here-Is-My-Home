<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>매물 검색</title>
	<link href="/css/searchHome.css"  type="text/css" rel="stylesheet" >
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="fa-solid fa-magnifying-glas" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
	<style>
		.home-card {
			padding: 15px 15px;
			display: flex;
			height: 200px;
			border-bottom: 1px solid;
		}
		.home-img-wrap {
		    flex: 0 0 auto;
		    display: flex;
			width: 150px;
			height: 165px;
			min-height: 140px;
			position:relative;
		}
		img {
			width:100%;
			height: 100%;
			object-fit: cover;
		}
		.home-content-wrap{
			padding-left: 20px;
		}
	</style>
</head>
<body>
	 <header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
	<div class="map-container">
		<div id="map"></div>	<!-- 지도 -->
		<!-- <ul id="category" style="padding-left:0px;">
	        <li id="BK9" data-order="0"> 
	            <span class="category_bg bank"></span>
	            은행
	        </li>       
	        <li id="MT1" data-order="1"> 
	            <span class="category_bg mart"></span>
	            마트
	        </li>  
	        <li id="PM9" data-order="2"> 
	            <span class="category_bg pharmacy"></span>
	            약국
	        </li>  
	        <li id="OL7" data-order="3"> 
	            <span class="category_bg oil"></span>
	            주유소
	        </li>  
	        <li id="CE7" data-order="4"> 
	            <span class="category_bg cafe"></span>
	            카페
	        </li>  
	        <li id="CS2" data-order="5"> 
	            <span class="category_bg store"></span>
	            편의점
	        </li> 
	        <li id="CS2" data-order="5"> 
	            <span class="category_bg store"></span>
	            편의점
	        </li>      
	    </ul>	 -->
	
		<div class="searchFilter">
			<div class="search-group-wrap">
				<div class="search-input">
					<input type="text" id="searchInput" placeholder="지역, 학교, 지하철역으로 검색"> 
					<button type="button" id="searchBtn"><i class="fa-solid fa-magnifying-glass"></i></button>
       			</div>
       			<div class="filter-div">
       				<label>검색 조건</label>
       				<button type="button" class="homeTypeFilter">매물 종류</button>
       				<button type="button" class="tradingFilter">거래 유형</button>
       				<button type="button" class="optionFilter" >옵션</button>
       				<button type="button" class="addInfoFilter">추가 필터</button>
       			</div>
       			<div class="homeType-content">
       				<div>
       					<h4>매물 종류</h4>
       					<p>중복 선택 가능</p>
       				</div>
       				<hr>
     				<div class="homeType">
     					<div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input" autocomplete="off" name="homeTypeCheck" value="원룸">
							<label class="form-check-label">원룸</label>
						</div>
                        <div class="form-check form-check-inline">
                        	<input type="checkbox" class="form-check-input"  autocomplete="off" name="homeTypeCheck" value="투룸">
 							<label class="form-check-label">투룸</label>
                        </div>
                        <div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input" autocomplete="off" name="homeTypeCheck" value="쓰리룸이상">
			 				<label class="form-check-label" >쓰리룸이상 </label>
                        </div>
                        <div class="form-check form-check-inline">
                         	<input type="checkbox" class="form-check-input" autocomplete="off" name="homeTypeCheck" value="오피스텔">
	 						<label class="form-check-label" >오피스텔</label>
                        </div>
                        <div class="form-check form-check-inline">
                             	<input type="checkbox" class="form-check-input" autocomplete="off" name="homeTypeCheck" value="빌라">
					 			<label class="form-check-label" >빌라 </label>
                        </div>
                        <div class="form-check form-check-inline">
                             	<input type="checkbox" class="form-check-input" autocomplete="off" name="homeTypeCheck" value="쉐어하우스">
					 			<label class="form-check-label" >쉐어하우스 </label>
                        </div>
       				</div>
       			</div>
       			
       			
       			<div class="trading-content">
       				<div>
       					<h4>거래 유형</h4>
       					<p>중복 선택 가능</p>
       				</div>
       				<hr>
     				<div class="homeType">
     					<div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input" autocomplete="off" name="homeTypeCheck" value="원룸">
							<label class="form-check-label">월세</label>
						</div>
                        <div class="form-check form-check-inline">
                        	<input type="checkbox" class="form-check-input"  autocomplete="off" name="homeTypeCheck" value="투룸">
 							<label class="form-check-label">전세</label>
                        </div>
       				</div>
       				<div class="range-div">
				        <label for="customRange1" class="form-label">보증금</label>
				        <input type="range" class="form-range" id="customRange1">
				        <label for="customRange3" class="form-label">월세</label>
				        <input type="range" class="form-range" min="0" max="5" step="0.5" id="customRange3">
					</div>
				</div>
				
				<div class="option-content">
       				<div>
       					<h4>옵션 선택</h4>
       					<p>중복 선택 가능</p>
       				</div>
       				<hr>
     				<div class="option-check">
     					<div class="form-check form-check-inline">
                        	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="세탁기">
						 	<label class="form-check-label">세탁기</label>
                        </div>
                        <div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input"  autocomplete="off" name="optionList" value="TV">
						 	<label class="form-check-label">TV</label>
                  		</div>
                        <div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="전자레인지">
						 	<label class="form-check-label" >전자레인지 </label>
                        </div>
                        <div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="인덕션">
						 	<label class="form-check-label" >인덕션</label>
                       	</div>
                        <div class="form-check form-check-inline">
                          	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="책상">
						 	<label class="form-check-label" >책상 </label>
                        </div>
                        <div class="form-check form-check-inline">
                          	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="침대">
						 	<label class="form-check-label" >침대 </label>
                        </div>
                        <div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="에어컨">
						 	<label class="form-check-label">에어컨 </label>
                        </div>
					 	<div class="form-check form-check-inline">
                          	<input type="checkbox" class="form-check-input"autocomplete="off" name="optionList" value="냉장고">
						 	<label class="form-check-label">냉장고 </label>
                        </div>
                        <div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="신발장">
						 	<label class="form-check-label">신발장 </label>
                        </div>
					 	<div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="옷장">
						 	<label class="form-check-label">옷장 </label>
                        </div>
                        <div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input"autocomplete="off" name="optionList" value="도어락">
						 	<label class="form-check-label" >도어락 </label>
                        </div>
                        <div class="form-check form-check-inline">
                          	<input type="checkbox" class="form-check-input"  autocomplete="off" name="optionList" value="비데">
						 	<label  class="form-check-label">비데</label>
                        </div>
       				</div>
				</div>
				<div class="addInfo-content">
       				<div>
       					<h4>추가 정보</h4>
       					<p>중복 선택 가능</p>
       				</div>
       				<hr>
     				<div class="homeType">
     					<div class="form-check form-check-inline">
                           	<input type="checkbox" class="form-check-input" autocomplete="off" name="homeTypeCheck" value="반려동물">
							<label class="form-check-label">반려동물</label>
						</div>
                        <div class="form-check form-check-inline">
                        	<input type="checkbox" class="form-check-input"  autocomplete="off" name="homeTypeCheck" value="투룸">
 							<label class="form-check-label">전세</label>
                        </div>
       				</div>
				</div>
				<!-- 메믈 리스트 -->
				<div class="home-wrap">
					<div class="home-list">
						<div class="home-card">
							<div class="home-img-wrap">
								<img src="/img/oneroom.jpg">
							</div>
							<div class="home-content-wrap">
								<h4>제목</h4>
							</div>
						</div>
						<div class="home-card">
							<div class="home-img-wrap">
								<img src="/img/oneroom.jpg">
							</div>
							<div class="home-content-wrap">
								<h4>제목</h4>
							</div>
						</div>
					</div>
				</div>
		</div>
		
		
		
	</div>
	
	<script>
		$("button").click(function() {
			let className = $(this).attr("class");
			console.log(className);
			
			switch(className) {
			case "homeTypeFilter":
				$(".homeType-content").toggle();
				break;
			case "tradingFilter":
				$(".trading-content").toggle();
				break;
			case "optionFilter":
				$(".option-content").toggle();
				break;
			case "addInfoFilter":
				$(".addInfo-content").toggle();
				break;
			}
							
		});
	</script>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a94d4863c9f7363e85ad81dac027db86"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨 
		    }; 
		
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
		if (navigator.geolocation) {
		    
		    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
		    navigator.geolocation.getCurrentPosition(function(position) {
		        var lat = position.coords.latitude, // 위도
		            lon = position.coords.longitude; // 경도
		        var locPosition = new kakao.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
		             // 인포윈도우에 표시될 내용입니다
		        // 마커와 인포윈도우를 표시합니다
		        displayMarker(locPosition);
		            
		      });
		    
		} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
		    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667)
		    displayMarker(locPosition);
		}
		
		// 지도에 마커와 인포윈도우를 표시하는 함수입니다
		function displayMarker(locPosition) {
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({  
		        map: map, 
		        position: locPosition
		    }); 
		   ;
		    // 지도 중심좌표를 접속위치로 변경합니다
		    map.setCenter(locPosition);      
		}  

</script>
</body>
</html>