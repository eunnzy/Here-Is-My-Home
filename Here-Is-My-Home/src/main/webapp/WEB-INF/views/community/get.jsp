<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="/js/board_reply.js"></script>
<script type="text/javascript" src="/js/board_getBT.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var bnoValue = '<c:out value="${board.bno}" />';
	var replyUL = $(".chat");
	var member = '<c:out value="${member.nickname}" />';
	
		
		// 댓글 목록 불러오기 
		showList(1);
		function showList(page) { 
			replyService.getList({ bno:bnoValue, page: page||1 }, 
					function(list) { var str="";  if(list == null || list.length == 0) { replyUL.html(""); return; }
					for (var i = 0, len = list.length || 0; i < len; i++) {
						str += "<div class='replydiv'> <h6 class='card-subtitle mb-2 text-muted' data-rno='" + list[i].rno + "'>";
						str += "<span>" + list[i].replyer + "</span>";
						str += "<span class='float-end'>" + replyService.displayTime(list[i].updateDate) + "</span></h6>";
						str += "<p class='card-text'>" + list[i].reply + "</p>";
						if (list[i].replyer == member) {
							str += "<div class='float-end'>";
							str += "<button type='button' class='btn btn-primary btn-sm float-end delBT' data-no='" + list[i].rno + "'>삭제</button>"; 
							str += "</div><br><br></div>";
						}
					}
					replyUL.html(str);
					
					// 댓글 삭제 
					$(".delBT").on("click", function(e) {
						var no = $(this).data("no");
						replyService.remove(no, function(result) { 
							alert("댓글이 삭제되었습니다.");
							showList(1);
					});
					}); 		
		});
		}
		
		// 댓글 입력 
		var regBt = $("#replyregBT");
		regBt.on("click", function(e) {
			if($("#reply").val() == null || $("#reply").val() == "") {
				alert("댓글 내용을 입력해주세요.");
			} else {
				var reply = {reply:$("#reply").val(), replyer:member, bno:bnoValue};
				replyService.add(reply, function(result) { 
					showList(1); 
					$("#reply").val('');
				});
			}
		});
		
});			
</script>
<script type="text/javascript">
$(document).ready(function() {
 	var imchanick = '<c:out value="${member.nickname}" />';
 	var boardnick = '<c:out value="${board.nickname}" />';
	
	if(imchanick != boardnick || imchanick == '' || imchanick == null) {
		$("#modifyBT").hide();
		$("#deleteBT").hide();
	} else {
		$("#modifyBT").show();
		$("#deleteBT").show();
	}
	
	if(imchanick == '' || imchanick == null) {
		$("#reply").attr("disabled", "").attr("value", "     로그인 후 댓글 입력이 가능합니다 ;(");
		$("#replyregBT").attr("disabled", "");
	}
	
	
});
</script>
</head>
<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
		<!-- 본문 -->
		<div class="container"><br>
		<!-- 조회시작 -->
	    <div class="card mb-3" style="background-color: white;">
	      <h3 class="card-header"><c:out value="${board.title}" /></h3>
	      <div class="card-footer text-muted">
	        <span><c:out value="${board.nickname}" /></span>
	        <span class="float-end">최근 수정일 : <fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></span>
	      </div>
	      <div class="card-body">
	        <p class="card-text" style="color: black;"><c:out value="${board.content}" /></p>
	      </div>
	      
	      	<input type="hidden" name="bno" value="<c:out value="${board.bno}" />" >
	      	<input type="hidden" name="likec" value="<c:out value="${board.likec}" />" >
	      	<div class="card-body">
	        <span><c:out value="${board.views}" /> 조회</span>
	        <span class="float-end"><span class="like"><c:out value="${board.likes}" /></span> 좋아요</span>
	      	</div>
	
	    </div>

	    <!-- 댓글 -->
	   <div class="card card-body" style="background-color: white;">
	       <div class = "chat"></div>
	    	
	       <!-- 댓글 작성 창 -->
		   <div><br></div>
	       <div class="input-group mb-3 replyreg">
	         <input type="text" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2" style="80%" name="reply" id="reply" required>
	         <button class="btn btn-secondary" type="button" id="replyregBT">등록</button>
	       </div>
	   </div>
	   <div><br></div>
    

	  <!-- 하단 버튼 -->
      <span><button type="button" class="btn btn-info" id="BackBT">목록으로</button></span>
      <span class="float-end"><div class="btn-group" role="group" aria-label="Basic example">
      <button type="button" class="btn btn-secondary" id="modifyBT">수정</button>
	  <button type="button" class="btn btn-secondary" id="deleteBT">삭제</button>
	  </div></span>

 	    <!-- 페이지이동 Form -->
	    <form id = "operForm" action="/community/modify" method="get" >
	   		<input type="hidden" id="bno" name="bno" value="<c:out value="${board.bno}" />" >
 	    	<input type="hidden" name="pageNum" value="<c:out value="${cri.pageNum }" />" >
	    	<input type="hidden" name="amount" value="<c:out value="${cri.amount }" />"  >
	    	<input type="hidden" name="keyword" value="<c:out value="${cri.keyword }" />"  >
	    	<input type="hidden" name="type" value="<c:out value="${cri.type }" />"  > 
	    </form> 
	    
      <div><br><br></div>
    </div>
	
	<footer>
    	<jsp:include page="../footer.jsp"></jsp:include>
    </footer>
</body>
</html>