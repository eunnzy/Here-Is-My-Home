<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매물 검색</title>
<style>
	html, body{ 
		font-family: 'Noto Sans KR', sans-serif;
	}
	h1 { font-size: 40px; }
	
	.add-notice {
		border: 1px solid #ddd;
		background-color: white;
	}
	.form-section {
		justify-content: center;
		padding: 10px 10px;
		margin: 20px 200px;
	}
	
	.addBtn{
		margin: auto;
		display: block;
		padding: 15px 40px;
		font-size: 20px;
		border: none;
		cursor:pointer;
		background-color: #BEE9FB;
	}
	
	.btn-div {
		text-align: center;
		margin: 80px 0;
	}
	.map-container {
	    position: relative;
		width:100%;
		height: calc(100vh - 77px);
	}
	#map {
		width:75%;
		height:100%;
	}
	body {margin: 0;}

	ul.topnav {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    overflow: hidden;
	    background-color: #BEE9FB;
	}
	
	ul.topnav li {float: left;}
	
	ul.topnav li a {
	    display: block;
	    color: #7E7E7E;
	    text-align: center;
	    padding: 14px 16px;
	    text-decoration: none;
	}
	
	ul.topnav li a:hover:not(.active) {background-color: #111;}
	
	/* ul.topnav li a.active {background-color: #f6fc5f;} */
	
	ul.topnav li.right {float: right;}
	
	li a, .dropbtn {
	    display: inline-block;
	    color: white;
	    text-align: center;
	    padding: 14px 16px;
	    text-decoration: none;
	}
	
	li a:hover, .dropdown:hover .dropbtn {
	    background-color: red;
	}
	
	li.dropdown {
	    display: inline-block;
	}
	
	.dropdown-content {
	    display: none;
	    position: absolute;
	    background-color: #f9f9f9;
	    min-width: 160px;
	    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	    z-index: 1;
	}
	
	.dropdown-content a {
	    color: black;
	    padding: 12px 16px;
	    text-decoration: none;
	    display: block;
	    text-align: left;
	}
	
	.dropdown-content a:hover {background-color: #f1f1f1;}
	
	.dropdown:hover .dropdown-content {
	    display: block;
	}
	
	@media screen and (max-width: 600px) {
	    ul.topnav li.right, 
    	ul.topnav li {float: none;}
	}
</style>
</head>
<body>
	 <header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
	<div class="map-container">
		<div class="map-seacrh-bar"></div>
		<div id="map"></div>	<!-- 지도 -->
		
	</div>
	
	
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