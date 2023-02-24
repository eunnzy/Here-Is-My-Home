$(document).ready(function() {
		// x아이콘 클릭시 서버에서 파일 삭제 
		$(".uploadResult").on("click", "button", function(e) {
			console.log("delete file");
			if(confirm("Remove this file?")) {
				var targetTd = $(this).closest("td");
				targetTd.remove();
			}
		});
		
		// 파일 확장자와 크기 사전 처리 
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		var maxSize = 5242880;		// 5MB
		
		function checkExtension(fileName, fileSize) {
			if(fileSize >= maxSize) {
				alert("파일 사이즈 초과");
				return false;
			}
			if(regex.test(fileName)) {
				alert("해당 종류의 파일은 업로드 할 수 없습니다. ");
				return false;
			}
			return true;
		}
		
		
		// 업로드 결과 처리 
		function showUploadResult(uploadResultArr) {
			if(!uploadResultArr || uploadResultArr.length == 0) {return;}
			var uploadUL = $(".uploadResult");
			var str="";
			
			$(uploadResultArr).each(function(i, obj) {
				if(obj.image) {
					var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
					str+= "<td class='uploadfile' data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.fileName + "'><div>";
					str+= "<img src='/community/display?fileName=" + fileCallPath + "'>";
					str+= "<button type='button' data-file=/'"+fileCallPath+"/' data-type='image' class='btn btn-primary btn-sm'>x</button><br>";
					str+= "</div>";
					str+ "</td>";
				} else {
					var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
	                var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");
					str+= "<td class='uploadfile' data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.fileName + "'><div>";
					str+= "<img src='/img/attach.png'>";
					str+= "<button type='button' data-file=/'"+fileCallPath +"/' data-type='file' class='btn btn-primary btn-sm'>x</button><br>";
					str+= "</div>";
					str+ "</td>";
				}
			});
			uploadUL.append(str);
		}
		
		var modifyForm = $("#modifyForm");
		$("#subBT").on("click", function(e) {
			e.preventDefault();
	        console.log("submit clicked");
	        var str = "";
	        $(".uploadResult .uploadfile").each(function (i, obj) {
	           str += "<input type='hidden' name='attachList[" + i + "].fileName' value='" + $(obj).data("filename") + "'>";
	           str += "<input type='hidden' name='attachList[" + i + "].uuid' value='" + $(obj).data("uuid") + "'>";
	           str += "<input type='hidden' name='attachList[" + i + "].uploadPath' value='" + $(obj).data("path") + "'>";
	           str += "<input type='hidden' name='attachList[" + i + "].fileType' value='" + $(obj).data("type") + "'>";
	           
//	           let uploadfilename = $(obj).data("filename");
//	           let uploaduuid = $(obj).data("uuid");
//	           let uploadpath = $(obj).data("path");
//	           let uploadtype = $(obj).data("type");
	           
	           var formData = new FormData();
	           var uploadfil = $(".uploadfil");
	           var files = uploadfil[0].files;
	           for(var i = 0; i < files.length; i++){
	        	   formData.append("uploadFile", files[i]);
	           }
	           
//	            let homeImgName = $(obj).data("imgname"); 
//				let homeImgPath = $(obj).data("path");
//					homeImgData = { homeImgPath : homeImgPath, homeImgName: homeImgName };
//				let homeImgData = homeImgPath + " " + homeImgName;
//				homeImgList.push(homeImgData);
	           
	        });
	        modifyForm.append(str).submit();
	    });
		
		// 업로드 할 파일 배열로 생성 및 추가 
		$("input[type='file']").change(function (e) {
			var formData = new FormData();
            var inputFile = $("input[name='uploadFile']");
            var files = inputFile[0].files;
			for(var i = 0; i < files.length; i++) {
				if(!checkExtension(files[i].name, files[i].size)) {
					return false;
				} 
				formData.append("uploadFile", files[i]);
			}
			
			$.ajax({
				url: '/community/uploadAjaxAction',
				processData: false,
				contentType: false,
				data: formData, 
				type: 'POST', 
				dataType: 'json',
				success: function(result){
					console.log(result);
					showUploadResult(result);
					}
			});
		});

		// 취소하고 목록으로 버튼 
		var actionForm = $("#actionForm");
		$("#listBT").on("click", function(e) {
			e.preventDefault();
			actionForm.submit();
		});
	});