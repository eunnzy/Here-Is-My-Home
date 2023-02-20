let homeTypeCheck = [];
let rentTypeCheck = [];
let optionCheck = [];
let addInfoCheck = [];
let deposit = 0;
let monthly = 0;
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
		
		
		deposit = $("#deposit").val();
		if(deposit == 1) {
			deposit = 5000;
		}else if(deposit == 2){
			deposit = 10000;
		}else {
			deposit = 999999;
		}
		
		monthly = $("#monthly").val();
		if(monthly == 1) {
			monthly = 50;
		}else if(monthly == 2){
			monthly = 100;
		}else {
			monthly = 999999;
		}
		
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
				displayHomeList(homeData[i], i);
		}
		
		$(".filter-content").css("display", "none");
});



