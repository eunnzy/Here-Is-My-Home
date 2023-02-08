let homeForm = $("#homeForm");
let homeImgList = [];    


let regex = new RegExp("(.*?)\.(jpg|png|gif|jpeg)$");	// 파일 확장자 -> jpg / pn / gif / jpeg만 가능
let maxSize = 1048576;	
function imgExtentionCheck(fileName, fileSize){	// 파일 확장자 체크 

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
		return
		
	let uploadResult = $(".resultImg");
	let str = "";
	
	$(resultArr).each(function(i, obj){
		// encodeURIComponent : 사진 이름이 한글이면 변환 해서 
		let imgPath = encodeURIComponent(obj.homeImgPath + "/t_" + obj.homeImgName);
		console.log("obj: " + obj.homeImgPath);
		
		str += "<div class='img-div' data-path='"+ obj.homeImgPath +"' data-imgname='"+obj.homeImgName +"'>";
   		str += "<img src='/home/manage/showHomeImg?homeImgName="+ imgPath +"'>";
   		str += "<div class='imgDelete' data-file='" + imgPath + "'>X</div>";
		str += "</div>";
		
	});
	uploadResult.append(str);
	
	// let obj = resultArr[0];
	// console.log(imgPath);
	// console.log(str);
}

	
// 이미지 추가 버튼 클릭시 발생
$(document).on("change", "input[type=file]", function(e){
	
	let formData = new FormData();
	let fileInput = $("input[name=homeImg]");
	let fileList = fileInput[0].files;
	
	console.log("fileList : " + fileList);
	
	if( homeImgList.length > 10) {
		alert("사진은 최대 10장까지 첨부가능합니다.");
		return false;
	} else {	
		for(var i=0; i<fileList.length; i++) {
			if(!imgExtentionCheck(fileList[i].name, fileList[i].size)){	// 파일 확장자 및 크기 검사
				return false;
			}
			formData.append("homeImg", fileList[i]);
		}
	}
		
		
		
	/* let target = $(this)[0];
	let index = 0;
	if(target != null){
		
		let img_div = $(this).parent();
		let imgList = target.files;
		
		var reader = new FileReader();    // 파일 위치 읽기
		reader.readAsDataURL(imgList [0]);
		
		//로드 한 후 이미지 요소 설정(스타일,url)
		reader.onload = function  (e) {
		    // 이미지 미리보기
		    img_div.children('label').css('background','url('+ e.target.result +') center no-repeat').css('background-size','105px 105px');
		};
		
		// 이미지 파일 첨부 버튼 추가 하기
		// 새로운 div 생성
		var div = document.createElement('div');
		
		index++;
		// 새로운 div의 className 지정
		div.className = 'img-div'+index+'';
		div.innerHTML = '<label for ="img-add'+index+'"></label>\<input type="file" id="img-add'+index+'" name="homeImg">';
		
		// 추가
		$('.img-select').append(div); */
	
	
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
	deleteImgFile();
});


function deleteImgFile() {
	let targetImg = $(".imgDelete").data("file");
	let targetDiv = $(".img-div");
	
	console.log(targetImg);
	
	$.ajax({
		url: "/home/manage/removeHomeImg",
		data: {homeImgName : targetImg},
		dataType: "text",
		type: "POST",
		success: function(result) {
			console.log(result);
			targetDiv.remove();
			$("input[type=file]").val("");
		},
		error: function(result) {
			console.log(result);
			console.log("삭제 못함");
		}
		
	});
}
	
	
$("#homeImg").change(function(){
	if(this.files && this.files[0]) {
		var reader = new FileReader;
		reader.onload = function(data) {
			$(".selectImg").attr("src", data.target.result).width(200);        
   		}
		reader.readAsDataURL(this.files[0]);
	}
});


	
$("#addBtn").on("click",function(e){	// 등록하기 버튼 클릭시 submit() 전송
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
	/*if(homeImgList.length < 2) {
		e.preventDefault();
		alert("사진은 최소 2장 첨부해야 합니다.");
		return false;
	}*/
		
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
				var msg = (data==1)? "글 등록 성공했습니다." : "실패";
				alert(msg);
				homeForm.reset();
	 		},
	 		error: function(xhr, status, error){console.log(xhr.status, status)}
		}); 
	
	
});
		
	