$(document).ready(function() {
		let basicInfo = $(".basic-info")
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
		
		let mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = { 
		    center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표
		    level: 4 // 지도의 확대 레벨 
		};
		
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		var markerPosition  = new kakao.maps.LatLng(latitude, longitude); 	// 마커 위치
			
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);

});


