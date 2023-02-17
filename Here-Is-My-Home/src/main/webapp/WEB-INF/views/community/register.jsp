<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	// 파일 업로드를 위해 기본 동작 막기 
	var formObj = $("#regForm");
	$("#regBT").on("click", function(e) {
		e.preventDefault();
		console.log("submit clicked");
		
		var str = "";
		$(".uploadResult ul li").each(function(i, obj){
			var jobj = $(obj);
			console.dir(jobj);
			str += "<input type='hidden' name='attachList[" + i + "].fileName' value='" + jobj.data("filename") + "'>";
			str += "<input type='hidden' name='attachList[" + i + "].uuid' value='" + jobj.data("uuid") + "'>";
			str += "<input type='hidden' name='attachList[" + i + "].uploadPath' value='" + jobj.data("path") + "'>";
			str += "<input type='hidden' name='attachList[" + i + "].fileType' value='" + jobj.data("type") + "'>";
		});
		formObj.append(str).submit();
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
	
	// 업로드 할 파일 배열로 생성 및 추가 
	$("input[type='file']").change(function(e) {
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		
		for(var i = 0; i < files.length; i++) {
			if(!checkExtension(files[i].name, files[i].size)) {
				return false;
			} formData.append("uploadFile", files[i]);
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
	
	
	// 업로드 결과 처리 
	function showUploadResult(uploadResultArr) {
		if(!uploadResultArr || uploadResultArr.length == 0) {return;}
		var uploadUL = $(".uploadResult ul");
		var str="";
		
		$(uploadResultArr).each(function(i, obj) {
			if(obj.image) {
				var fileCallPath = encodeURIComponent (obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
				str+= "<li data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "'";
				str+= " data-type='" + obj.image + "'><div>";
				str+= "<span> " + obj.fileName + "</span>";
				str+= "<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' class='btn btn-primary btn-sm'>x</button><br>";
				str+= "<img src='/community/display?fileName=" + fileCallPath + "'>";
				str+= "</div>";
				str+ "</li>";
			} else {
				var fileCallPath = encodeURIComponent (obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
				var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
				str+= "<li data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "'data-filename='" + obj.fileName + "'";
				str+= " data-type='" + obj.image + "'><div>";
				str+= "<span> " + obj.fileName + "</span>";
				str+= "<button type='button' data-file=\'"+fileCallPath +"\' data-type='file' class='btn btn-primary btn-sm'>x</button><br>";
				str+= "<img src='/img/attach.png'>";
				str+= "</div>";
				str+ "</li>";
			}
		});
		uploadUL.append(str);
	}
	
		// x아이콘 클릭시 서버에서 파일 삭제 
		$(".uploadResult").on("click", "button", function(e) {
			console.log("delete file");
			var targetFile = $(this).data("file");
			var type = $(this).data("type");
			var targetLi = $(this).closest("li");
			
			$.ajax({
				url: '/community/deleteFile',
				data: {fileName: targetFile, type:type},
				dataType: 'text',
				type: 'POST',
				success: function(result){
					alert(result);
					targetLi.remove();
				}
			});
		});
});
</script>
</head>
<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
   <div class="container">
    <div class="bs-docs-section row">
     <div class="col-lg-12"><br><br>
       <h1 id="tables">글쓰기</h1>
       
     <form action="insertBoard.do" method="post" enctype="multipart/form-data" id="regForm">
       <input type='hidden' name='imchaid' value='<c:out value="${member.imchaId}" />'>
       	
	   <div class="bs-component">
        <table class="table table-hover">
         <tr>
          <th scope="col" class="col col-lg-1">카테고리</th>
          <td>
           <select class="form-select" id="condition" name="category">
            <option value="동네소식">동네소식</option>
            <option value="동네질문">동네질문</option>
            <option value="동네맛집">동네맛집</option>
            <option value="취미생활">취미생활</option>
            <option value="자취꿀팁">자취꿀팁</option>
            <option value="도와줘요">도와줘요</option>
            <option value="분실실종">분실실종</option>
           </select>
          </td>
         </tr>
         <tr>
          <th scope="col" class="col col-lg-1">제목</th>
           <td><input type="text" class="form-control" id="title" name="title" required></td>
          </tr>
          <tr>
           <th scope="col" class="col col-lg-1">첨부파일</th>
           <td><input class="form-control" type="file" id="file" name="uploadFile" multiple></td>
          </tr>
          <tr>
           <th scope="col" class="col col-lg-1"></th>
            <td class="uploadResult"><ul></ul></td> 
          </tr>
          <tr>
           <th scope="col" class="col col-lg-1">내용</th>
           <td><textarea class="form-control" id="content" rows="10" name="content" required></textarea></td>
          </tr>
         </table>
        </div>
        
	     <!-- 하단 버튼 -->
	     <a href="/community/list"><button type="button" class="btn btn-info">취소</button></a>
	     <span class="float-end">
	     	<button type="submit" class="btn btn-info" id="regBT">등록</button>
	     </span>
     </form>
      </div>
     </div>
	</div>

	
	<footer>
    	<jsp:include page="../footer.jsp"></jsp:include>
    </footer>
</body>
</html>