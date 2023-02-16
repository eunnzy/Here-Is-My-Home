var map;
let homeList = [];
let homeMarker = [];	// 매물 표시할 마커를 담을 배열
let content = [];
let homeData;

$(document).ready(function() {

	let mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = { 
	    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨 
	}; 
	
	map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	let zoomControl = new kakao.maps.ZoomControl(); // 지도 줌 컨트롤러
	map.addControl(zoomControl, kakao.maps.ControlPosition.LEFT);
	
	/*------------ searchHome 페이지 들어갈 때 사용자의 현재 위치 받아와서 그 위치에 있는 매물 리스트 보여줌 -------------*/
	// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
	if (navigator.geolocation) {	 // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	
	    navigator.geolocation.getCurrentPosition(function(position) {
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        var locPosition = new kakao.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	             // 인포윈도우에 표시될 내용입니다
			
	     //  displayMarker(locPosition);	// 사용자 현재 위치 표시	
	       map.setCenter(locPosition);	      	
	       getHomeInBounds(map);
	
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
         
}  


// 사용자의 현재 위치에서 지도 경계까지 매물 정보 가져오기
function getHomeInBounds(map) {
	let bounds = map.getBounds();	// 지도 범위 가져오기
	
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
	
	// 지도 경계까지의 매물 정보들을 서버에 요청.
	$.ajax({
		url: '/home/homeInBounds',
    	data : mapBounds,
    	type : 'Post',
    	dataType : 'json',
    	success: function(data) {	
    		if(data != null) {
    			map.setBounds(bounds);	// 주어진 영역이 화면 안에 전부 나타날 수 있도록 지도의 중심 좌표와 확대 수준을 설정
				homeData = data;
				// showHomeList(data);
				for(let i=0; i<data.length; i++) {
    				showHomeList(data[i], i);	// 매물 정보 리스트 출력
				}
			}else {
				alert("해당하는 위치에 매물 정보가 없습니다.");
			}
    	}
	});
}

function getPositionBounds(data) {
    let bounds = new kakao.maps.LatLngBounds();
	displayPlaces(data);
	bounds.extend(new kakao.maps.LatLng(data.latitude, data.longitude));
}


function checkFilter(data) {
	console.log("checkFilter : " + data);
	let checkFlag = false;
	
	for(let i=0; i<homeTypeCheck.length; i++) {
		console.log(data.homeType);
		console.log(homeTypeCheck[i]);
		if(data.homeType == homeTypeCheck[i]) {
			checkFlag = true;
		}
	}
	/*console.log(checkFlag);
	
	if(checkFlag == false) return false;*/
	
	for(let i=0; i<rentTypeCheck.length; i++) {
		console.log(data.rentType);
		if(data.rentType == rentTypeCheck[i])
			checkFlag = true;
	}
	
	// if(checkFlag == false) return false;
	
	console.log(checkFlag);
	
	// 옵션 체크
	let optionCount = 0;
	for(let i=0; i<optionCheck.length; i++) {
		console.log(data.optionList[i]);
		for(let j=0; j<data.optionList.length; j++) {
			console.log(data.optionList[j]);
			if(data.optionList[j] == optionCheck[i]) {
				optionCount++;	
			}
		}	
	}
	
	console.log(checkFlag);
	
	console.log("optionCheck.length: " + optionCheck.length);
	console.log("optionCount: " + optionCount);
	console.log(optionCheck.length == optionCount);
	
	if(optionCheck.length != optionCount) { // 하나라도 같지 않으면 false
		return false;
	}
	
	console.log(checkFlag);
	
	// 추가 정보
	let addInfoCount=0;
	for(let i=0; i<addInfoCheck.length; i++) {
		switch(addInfoCheck[i]) {
		case "반려동물":
			data.pet.includes("가능");
			addInfoCount++;
			break;
		case "엘리베이터":
			data.elevator.includes("가능");
			addInfoCount++;
			break;
		case "주차":
			console.log(data.parking);
			if(data.parking >= 1) 
				addInfoCount++;
			break;
		case "발코니":
			data.balcony.includes("가능");
			addInfoCount++;
			break;
		default:
			break;
		}
	}
	
	console.log("addInfoCheck.length : " + addInfoCheck.length);
	console.log("addInfoCount: " + addInfoCount);
	
	if(addInfoCheck.length != addInfoCount) {
		return false;
	}
	
	console.log(checkFlag);
	
	
	return checkFlag;
}



//매물 리스트 출력하기
function showHomeList(data, i) {
	if(btnFlag == true) {
		let homeList = $(".home-list");  
	    homeList.children().remove();	// 기존의 리스트 목록 삭제
	    removeMarker();	// 기존의 마커 제거
	}
		
	console.log("showHomeList " + data);
	let homeItemCheck = false; 
	let homeDiv = $(".home-list");
	
		let placePosition = new kakao.maps.LatLng(data.latitude, data.longitude);
        let marker = addMarker(placePosition, i);
        	console.log(data);
        	
        /*	if(btnFlag == true)	{
        		homeItemCheck = filterCheck(data)
        	}
           	
           	if(homeItemCheck == false) {
           		continue;
       		}*/
       		
            homeItem = getHomeList(data);
            
            var content = "<div class='overlay-info'>";
            content += "<div class='info'>";
            content += "<div class='title'>";
            content += "</div>";
            
			(function(marker, title) {
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                displayInfowindow(marker, title);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });

        })(marker, data.homeType);
	
		homeDiv.append(homeItem);	
}



function getHomeList(data) {
	console.log(data);
	
	// console.log(filterCheck(data));
	
	homeImgFile = data.homeImg.homeImgPath + "/" + data.homeImg.homeImgName;	// 사진경로
	console.log(homeImgFile);
	
	let monthly = convertMoney(data.monthly);
	let deposit = convertMoney(data.deposit);
	let adminCost = convertMoney(data.adminCost);
	
	let homeStr = "";
	homeStr += "<div class='home-card' onclick='detailHome("+ data.homeNum + ")'> <div class='home-img-wrap'>"
	homeStr += "<img src='/home/getHomeImg?homeImgFile=" + homeImgFile + "'> </div>"
	homeStr += "<div class='home-content-wrap'> <h4>" + data.rentType + " " ;
	if(data.rentType == "월세")
		homeStr  += deposit +  "/" + monthly + "</h4>";
	else 			
		homeStr  += deposit +  "</h4>";
	homeStr += "<p>" + data.homeArea + "평 " + data.floor +"층" + "</p>";
	homeStr += "<p>"+ data.addr2  +"</p>"	
	homeStr += "<p>"+ data.homeTitle  +"</p> </div> </div>"	
	
	return homeStr;
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
	
	if (!searchInput.replace(/^\s+|\s+$/g, " ")) {	// 어떠한 검색 키워드 값도 입력 안 됐을 때
		alert("검색어를 입력해주세요!");
		return false;
	}
	ps.keywordSearch(searchInput, placesSearchCB);
});


var ps = new kakao.maps.services.Places(); 

// 장소검색이 완료됐을 때 호출되는 콜백함수
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
		
       	displayPlaces(data);	// 검색한 장소 찾기

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
    let homeList = $(".home-list");  
    
    homeList.children().remove();	// 기존의 리스트 목록 삭제
    removeMarker();	// 기존의 마커 제거
 
 	var bounds = new kakao.maps.LatLngBounds(); 	// 지도 범위 재 설정
    var placePosition = new kakao.maps.LatLng(places[0].y, places[0].x);
    bounds.extend(placePosition);
    
    // 검색된 장소 위치를 기준으로 지도 범위를 재설정
  	map.setBounds(bounds);
  	map.setLevel(3);
  	getMapBounds(map);
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

