let homeTypeCheck = [];
let rentTypeCheck = [];
let optionCheck = [];
let addInfoCheck = [];
let btnFlag = false;

$(document).ready(function() {
	
	$("#filterBtn").click(function() {
		if($(".filter-content").css("display") == "none")	{
			$(".filter-content").css("display", "inline-block");
		}else {
			$(".filter-content").css("display", "none");
		}
	});
	
});

$("#cancelBtn").click(function() {

	});

$("#filterApplyBtn").click(function() {
		$("input[name=homeType]:checked").each(function() {
			if(!homeTypeCheck.includes($(this).val())) 
				homeTypeCheck.push($(this).val());
		});

		$("input[name=rentType]:checked").each(function() {
			if(!rentTypeCheck.includes($(this).val())) 
				rentTypeCheck.push($(this).val());
		});
		
		$("input[name=optionList]:checked").each(function() {
			if(!optionCheck.includes($(this).val())) 
				optionCheck.push($(this).val());
		});
		
		$("input[name=addInfoList]:checked").each(function() {
			if(!addInfoCheck.includes($(this).val())) 
				addInfoCheck.push($(this).val());
		});
		
		console.log(homeTypeCheck);
		console.log(rentTypeCheck);
		console.log(optionCheck);
		console.log(addInfoCheck);
		
		btnFlag=true;
		console.log(homeData);
			
		for(let i=0; i<homeData.length; i++) {
			console.log(homeData[i]);
			let check = checkFilter(homeData[i]);
			console.log(check);
			if(check === false) {
				let homeList = $(".home-list");  
			    homeList.children().remove();	// 기존의 리스트 목록 삭제
			    removeMarker();	// 기존의 마커 제거
			    alert("해당 카테고리에 해당하는 매물이 없습니다.");
			    continue;
			}
			else 
				showHomeList(homeData[i], i);
		}
		
		$(".filter-content").css("display", "none");
});



