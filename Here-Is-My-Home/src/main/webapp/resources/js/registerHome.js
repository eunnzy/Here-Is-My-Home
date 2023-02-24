let index = 0;
let homeForm = $("#homeForm");
let homeImgList = [];    


let regex = new RegExp("(.*?)\.(jpg|png|gif|jpeg)$");	// 파일 확장자 -> jpg / pn / gif / jpeg만 가능
let maxSize = 10485760;	
function imgExtentionCheck(fileName, fileSize){	// 파일 확장자 및 크기 체크 

	if(fileSize >= maxSize){
		alert("파일 사이즈 초과");
		return false;
	}
		  
	if(!regex.test(fileName)){
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
	
	return true;		
}
	
// 첨부한 이미지 출력
function showImage(resultArr) {
	if(!resultArr || resultArr.length == 0)	// 데이터 받지 못한경우
		return;
		
	let uploadResult = $(".resultImg");
	let str = "";
	
	$(resultArr).each(function(i, obj){
		// encodeURIComponent : 사진 이름이 한글이면 변환 해서 
		let imgPath = encodeURIComponent(obj.homeImgPath + "/t_" + obj.homeImgName);
		console.log("obj: " + obj.homeImgPath);
		
		str += "<div class='img-div col-sm-3' data-path='"+ obj.homeImgPath +"' data-imgname='"+obj.homeImgName +"'>";
		str += "<div class='imgDelete' data-file='" + imgPath + "'><i class='bi bi-x-lg'></i></div>";
   		str += "<img src='/home/manage/showHomeImg?homeImgName="+ imgPath +"'>";
		str += "</div>";
		
	});
	uploadResult.append(str);
	
}

	
// 이미지 추가 버튼 클릭시 발생
$(document).on("change", "input[type=file]", function(e){
	e. preventDefault();
	
	let formData = new FormData();
	let fileInput = $("input[name=homeImg]");
	let fileList = fileInput[0].files;
	
	if(fileList.length > 10) {
		alert("사진은 최대 10장까지 첨부가능합니다.");
		return false;
	}
	
	console.log("fileList : " + fileList);
	
	for(var i=0; i<fileList.length; i++) {
		if(!imgExtentionCheck(fileList[i].name, fileList[i].size)){	// 파일 확장자 및 크기 검사
			return false;
		}
		formData.append("homeImg", fileList[i]);
	}
		
	
	// 서버에 사진 전송
	$.ajax({
		url: '/home/manage/homeImgUpload',
    	processData : false,
    	contentType : false,
    	data : formData,
    	type : 'POST',
    	dataType : 'json',
    	success: function(result) {
    		console.log(result);
    		showImage(result);	// 사진 업로드 결과
    	}
	});
});
	
	
// 이미지 삭제
$(".resultImg").on("click", ".imgDelete", function(e){
	
	let targetImg = $(this).data("file");
	let targetDiv = $(this).parent();
	
	console.log(targetImg);
	console.log(targetDiv);
	
	$.ajax({
		url: "/home/manage/removeHomeImg",
		data: {homeImgName : targetImg},
		dataType: "text",
		type: "POST",
		success: function(result) {
			console.log(result);
			targetDiv.remove();
		},
		error: function(result) {
			console.log(result);
			console.log("삭제 못함");
		}
	});
	
	
	
});
	
function overlay() {
	
}	
	
	
// 등록하기 버튼 클릭시 submit() 전송	
$("#updateBtn").on("click",function(e){	
	e.preventDefault();
	
	let optionList = [];	// 옵션 체크 한 것 배열로 넘기기.
	$("input[name=optionList]:checked").each(function() {
		optionList.push($(this).val());
	});

	let str="";
	$(".resultImg .img-div").each(function(i, obj) {
			console.log("resultImg.each() 함수 실행 ");
			
			str += "<input type='hidden' name='homeImgList[" + i + "].homeImgName' value='"+ $(obj).data("imgname") +"'>";
			str += "<input type='hidden' name='homeImgList[" + i + "].homeImgPath' value='"+ $(obj).data("path") +"'>";	
	
			let homeImgName = $(obj).data("imgname");
			let homeImgPath = $(obj).data("path");
			
			// homeImgData = { homeImgPath : homeImgPath, homeImgName: homeImgName };
			
			let homeImgData = homeImgPath + " " + homeImgName;
			homeImgList.push(homeImgData);
		}); 
	
	homeForm.append(str);
	
	// 유효성 확인.
	if(homeImgList.length < 2) {
		e.preventDefault();
		alert("사진은 최소 2장 첨부해야 합니다.");
		return false;
	}
		
	let homeData= {
	    		"homeType" : $("input[name=homeType]").val(),
	    		"addr1" : $("input[name=addr1]").val(),
	    		"addr2" : $("input[name=addr2]").val(),
	    		"addr3" : $("input[name=addr3]").val(),
	    		"latitude" : $("input[name=latitude]").val(),
	    		"longitude": $("input[name=longitude]").val(),
	    		"homeArea" : $("input[name=homeArea]").val(),
	    		"rentType" : $("input[name=rentType]").val(),
	    		"deposit" : $("input[name=deposit]").val() * 10000,
	    		"monthly" : $("input[name=monthly]").val() * 10000,
	    		"rentPeriods" : $("input[name=rentPeriods]").val(),
	    		"roomCount" : $("input[name=roomCount]").val(),
	    		"adminCost" : $("input[name=adminCost]").val()  * 10000,
	    		"parking" : $("input[name=parking]").val(),
	    		"pet" : $("input[name=pet]").val(),
	    		"elevator" : $("input[name=elevator]").val(),
	    		"balcony" : $("input[name=balcony]").val(),
	    		"moveDate" : $("input[name=moveDate]").val(),
	    		"floor" : $("input[name=floor]").val(),
	    		"optionList" : optionList,
	    		"homeImgList": homeImgList,
	    		"homeTitle" : $("input[name=homeTitle]").val(),
	    		"homeDetail" : $("textarea[name=homeDetail]").val()
		}
	
	console.log(homeData);
	$.ajax({
			type:'post',
			url: '/home/manage/register',
			data: JSON.stringify(homeData),
            contentType: "application/json",
			success:function(data, status, xhr){
				var msg = (data==1) ? "글 등록 성공했습니다." : "실패";
				alert(msg);
				homeForm[0].reset();
	 		},
	 		error: function(xhr, status, error){console.log(xhr.status, status)}
		}); 
	
	
});
		
