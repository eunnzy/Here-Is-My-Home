var map;
let homeMarker = [];	// 매물 표시할 마커를 담을 배열


$(document).ready(function() {

	let mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = { 
	    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨 
	}; 
	
	map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	let zoomControl = new kakao.maps.ZoomControl(); // 지도 줌 컨트롤러
	map.addControl(zoomControl, kakao.maps.ControlPosition.LEFT);
	
	
	/*------------ 사용자의 현재 위치 -------------*/
	// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
	if (navigator.geolocation) {
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        var locPosition = new kakao.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	             // 인포윈도우에 표시될 내용입니다
			
	        displayMarker(locPosition);	
	        getMapBounds(map);
	
	      });
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667)
	    displayMarker(locPosition);
	}
	
});


// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition) {	// 현재 위치 표시
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
   ;
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}  


// 사용자의 현재 위치에서 지도 경계까지 매물 정보 가져오기
function getMapBounds(map) {
	// 지도 범위 가져오기
	 var center = map.getCenter(); 
	 console.log("center:" + center);
	
	let bounds = map.getBounds();
	
	// 북동쪽 위도 경도
	let neLat = bounds.getNorthEast().getLat();
	let neLng = bounds.getNorthEast().getLng();
	
	// 남서쪽 위도, 경도
	let swLat = bounds.getSouthWest().getLat();
	let swLng = bounds.getSouthWest().getLng();
	
	console.log(bounds.getSouthWest());
	console.log(bounds.getNorthEast());
	
	let mapBounds = { 
					"neLat" : neLat,
    				"neLng" : neLng,
    			 	"swLat" : swLat,
    			 	"swLng" : swLng
    				};
	
	$.ajax({
		url: '/home/homeInBounds',
    	data : mapBounds,
    	type : 'Post',
    	dataType : 'json',
    	success: function(data) {
    		if(data != null) {
    			showHomeList(data);
			}else {
				alert("해당하는 위치에 매물 정보가 없습니다.");
			}
    	}
	});
}


//매물 리스트 출력하기
function showHomeList(data) {
	let homeDiv = $(".home-list");

	for(let i=0; i<data.length; i++) {
		let placePosition = new kakao.maps.LatLng(data[i].latitude, data[i].longitude),
            marker = addMarker(placePosition, i), 
            homeItem = getHomeList(data[i]);
		
		(function(marker, title) {
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                displayInfowindow(marker, title);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });

        })(marker, data[i].homeType);
	
		homeDiv.append(homeItem);	
	}
	
}


function getHomeList(data) {
	console.log(data);
		// console.log(data[i].homeImgVO.homeImgName);
	
	homeImgFile = data.homeImgVO.homeImgPath + "/" + data.homeImgVO.homeImgName;	// 사진경로
	console.log(homeImgFile);
	
	let monthly = convertMoney(data.monthly);
	let deposit = convertMoney(data.deposit);
	let adminCost = convertMoney(data.adminCost);
	
	console.log(monthly);
	console.log(deposit);
	console.log(adminCost);	

	
	let homeList = "";
	homeList += "<div class='home-card' onclick='detailHome("+ data.homeNum + ")'> <div class='home-img-wrap'>"
	homeList += "<img src='/home/getHomeImg?homeImgFile=" + homeImgFile + "'> </div>"
	homeList += "<div class='home-content-wrap'> <h4>" + data.rentType + " " ;
	if(data.rentType == "월세")
		homeList += deposit +  "/" + monthly + "</h4>";
	else 			
		homeList += deposit +  "</h4>";
	homeList += "<p>"+ data.addr2  +"</p>"	
	homeList += "<p>"+ data.homeTitle  +"</p>"	
	
	return homeList;
}


// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = '/icon/homeMarker.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(40,40),  // 마커 이미지의 크기
        imgOptions =  {
            // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    homeMarker.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < homeMarker.length; i++ ) {
        homeMarker[i].setMap(null);
    }   
    homeMarker = [];
}


// 검색 키워드 입력 후 검색 버튼 클릭시 
$("#searchBtn").click(function() {
	let searchInput = $("#searchInput").val();	// 검색 키워드 값 
	console.log(searchInput);
	
	if (!searchInput.replace(/^\s+|\s+$/g, "")) {	// 어떠한 검색 키워드 값도 입력 안 됐을 때
		alert("검색어를 입력해주세요!");
		return false;
	}
	ps.keywordSearch(searchInput, placesSearchCB);
});


var ps = new kakao.maps.services.Places(); 

// 장소검색이 완료됐을 때 호출되는 콜백함수
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
		
		/*let bounds = new kakao.maps.LatLngBounds();
		bounds.extend(new kakao.maps.LatLng(data[0].y, data[0].x)); // 지도 범위 재 설정
		
		map.setCenter(bounds);*/
/*		map.setCenter(bounds);*/
		
		// displayMarker(bounds);
		
		/*map.setCenter
		map.setBounds(map);*/
		// getMapBounds(map);
		//console.log(bounds);
		
        // 정상적으로 검색이 완료됐으면 검색 목록과 마커를 표출합니다
       	displayPlaces(data);

        // 페이지 번호를 표출합니다
        // displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}


// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {
    let homeList = $(".home-list"), 
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(), 
    bounds = new kakao.maps.LatLngBounds(), 
    listStr = '';
    
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    // removeAllChildNods(homeList);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    for ( var i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x);

        bounds.extend(placePosition);

        
    }


    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
    map.setCenter(bounds);
}


// 돈 format
function convertMoney(money) {	
	let convert = ""; 
	money = money / 10000;
	if(money == 0) {
		convert = "없음";
	}else if(money >= 10000) {
		console.log(money); 
		convert += Math.floor(money/10000) + "억";
		
		if(money % 10000 != 0 ) {
			money = money % 10000;
			convert +=  money + "만";
		}
	}else {
		convert = money + "만";
	}
	
	return convert;
}


// 상세보기 페이지 이동
function detailHome(homeNum) {
	location.href = "/home/detail?homeNum=" + homeNum;
}
