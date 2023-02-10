var map;
let homeMarker = [];	// 매물 표시할 마커를 담을 배열

$("#searchBtn").click(function() {
	let searchKeyword = $("#searchInput").val();
		
});

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
			
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition);
	        getMapBounds(map);
	
	      });
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667)
	    displayMarker(locPosition);
	}
	/*------------ 사용자의 현재 위치 -------------*/
	
	
	
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
	

});


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


// 지도 경계 안에 매물 리스트 가져오기
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
	imgPath = ""; 
	imgPath += "/" + data.homeImgVO.homeImgPath + "/" + data.homeImgVO.homeImgName;	// 사진경로
	console.log(imgPath);
		
	let homeList = "";
			
	homeList += "<div class='home-card' onclick='detailHome("+ data.homeNum + ")'> <div class='home-img-wrap'> <img src=" + imgPath + "> </div>"
	homeList += "<div class='home-content-wrap'> <h4>" + data.rentType ;
	if(data.rentType == "월세")
		homeList += data.deposit +  "/" + data.monthly + "</h4>";
	else 			
		homeList += data.deposit +  "</h4>";
	homeList += "<p>"+ data.addr2  +"</p>"	
	homeList += "<p>"+ data.homeTitle  +"</p>"	
	
	return homeList;
}

function detailHome(homeNum) {
	location.href = "/home/detail?homeNum=" + homeNum;
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


/*let ps = new kakao.maps.services.Places();
ps.keywordSearch('입력 값', placesSearchCB);
*/

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
		
		// 검색된 장소 위치를 기준으로 지도 범위 재설정.
		let bounds = new kako.maps.LatLngBounds(); 
	
		
        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}


