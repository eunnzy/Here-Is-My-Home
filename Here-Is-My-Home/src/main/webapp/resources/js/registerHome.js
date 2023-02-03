let homeForm = $("#homeForm")
    	
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
		}); 
	
	homeForm.append(str);
	homeForm.submit();
});
		
	
	// 이미지 추가 버튼 클릭시 발생
	$(document).on("change", "input[type=file]", function(e){
		
		/* if($(".imgDelete").length > 0){	// 이미지가 있을 때 
			deleteImgFile();
		}		 */
		
		let formData = new FormData();
		let fileInput = $("input[name=homeImg]");
		let fileList = fileInput[0].files;
		// let fileObj = fileList[0];
		
		console.log("fileList : " + fileList);
		
		for(var i=0; i<fileList.length; i++) {
			if(!fileInfoCheck(fileList[i].name, fileList[i].size)){	// 파일 확장자 및 크기 검사
				return false;
			}
			formData.append("homeImg", fileList[i]);
			
			console.log("fileObj: " + fileList[i]);
			console.log("fileName : " + fileList[i].name);
			console.log("fileSize : " + fileList[i].size);
			console.log("fileType(MimeType) : " + fileList[i].type);
			
		}
		// formData.append("homeImg", fileObj);	//한장의 사진파일 일 때
		
		for(let i = 0; i < fileList.length; i++){	// 여러장의 사진 파일을 전송할 때 
			formData.append("homeImg", fileList[i]);
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
	
	let regex = new RegExp("(.*?)\.(jpg|png|gif|jpeg)$");	// 파일 확장자 -> jpg / pn / gif / jpeg만 가능
	let maxSize = 1048576;	
	
	function fileInfoCheck(fileName, fileSize){	// 파일 정보 체크 

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
			
			console.log(obj.homeImgPath);
			str += "<div class='img-div' data-path='"+ obj.homeImgPath +"' data-imgname='"+obj.homeImgName +"'>";
       		str += "<img src='/home/manage/showHomeImg?homeImgName="+ imgPath +"'>";
       		str += "<div class='imgDelete' data-file='" + imgPath + "'>X</div>";
			str += "</div>";
		})
		uploadResult.append(str);
		
		
		// let obj = resultArr[0];
		
		// console.log(imgPath);
		
		// console.log(str);
		
		
	}
	
	
	
	// 이미지 삭제
	$(".resultImg").on("click", ".imgDelete", function(e){
		deleteImgFile();
	});
	
	
	function deleteImgFile() {
		let targetImg = $(".imgDelete").data("file");
		let targetDiv = $(".img-div");
		
		console.log(targetImg);
		
		$.ajax({
			url: "/home/manage/deleteHomeImg",
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
	
	/*
	$("#addBtn").on("click",function(e){
		e.preventDefault();
		
		
		/* let homeData= {
	    		"homeType" : $("input[name=homeType]").val(),
	    		"addr1" : $("input[name=addr1]").val(),
	    		"addr2" : $("input[name=addr2]").val(),
	    		"addr3" : $("input[name=addr3]").val(),
	    		"homeArea" : $("input[name=homeArea]").val(),
	    		"tradingType" : $("input[name=tradingType]").val(),
	    		"deposit" : $("input[name=deposit]").val(),
	    		"monthly" : $("input[name=monthly]").val(),
	    		"rentPeriods" : $("input[name=rentPeriods]").val(),
	    		"roomCount" : $("input[name=roomCount]").val(),
	    		"adminCost" : $("input[name=adminCost]").val(),
	    		"parking" : $("input[name=parking]").val(),
	    		"pet" : $("input[name=pet]").val(),
	    		"elevator" : $("input[name=elevator]").val(),
	    		"balcony" : $("input[name=balcony]").val(),
	    		"moveDate" : $("input[name=moveDate]").val(),
	    		"floor" : $("input[name=floor]").val(),
	    		"optionList" : $("input[name=optionList]").val(),
	    		"homeTitle" : $("input[name=homeTitle]").val(),
	    		"homeDetail" : $("input[name=homeDetail]").val()
	    	}
	    	
		
    	$.ajax({
			type:'post',
			url: '/home/manage/register',
			data: "text",
            dataType: "json",
            contentType: "application/json",
			success:function(data, status, xhr){
				var mesg = (data==1)? "성공" : "실패";
				alert(mesg);
				$("input").each(function(idx,ele){
					$(ele).prop("readonly", true);
				});
				$("textarea").each(function(idx,ele){
					$(ele).prop("readonly", true);
				});
	 		},
	 		error: function(xhr, status, error){console.log(xhr.status, status)}
		});  
	
	});   */
	
	
  $("#homeImg").change(function(){
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $(".selectImg").attr("src", data.target.result).width(200);        
    }
    reader.readAsDataURL(this.files[0]);
   }
  });

