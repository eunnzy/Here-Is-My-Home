<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var actionForm = $("#actionForm");
	$("#listBT").on("click", function(e) {
		e.preventDefault();
		actionForm.submit();
	});
	
/* 	$("#deleteBT").on("click", function(e) {
		e.preventDefault();
		actionForm.attr("action", "delete.do");
		actionForm.submit();
	}); */
});
</script>
</head>
<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
	<!-- 본문 -->
	<div class="container"><br>
    <div class="card mb-3" style="background-color: white;">
      <h3 class="card-header"><c:out value="${board.title}" /></h3>
      <div class="card-footer text-muted">
        <span>작성자</span>
        <span class="float-end">최근 수정일 : <fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></span>
      </div>
      <div class="card-body">
        <p class="card-text" style="color: black;"><c:out value="${board.content}" /></p>
      </div>
      <div class="card-body">
        <span><c:out value="${board.views}" /> 조회</span>
        <span class="float-end"><c:out value="${board.likes}" /> 좋아요</span>
      </div>
    </div>

    <!-- 댓글 -->
    <div class="card card-body" style="background-color: white;">
        <h6 class="card-subtitle mb-2 text-muted">
          <span>작성자</span>
          <span class="float-end">작성일</span>
        </h6>
        <p class="card-text">내용</p>
        <h6 class="card-subtitle mb-2 text-muted">
          <span>작성자</span>
          <span class="float-end">작성일</span>
        </h6>
        <p class="card-text" style="color: black;">내용</p>

        <div class="input-group mb-3">
          <input type="text" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2" style="80%">
          <button class="btn btn-primary" type="button" id="button-addon2">등록</button>
        </div>
    </div>
    <div><br></div>

	  <!-- 하단 버튼 -->
	  <!-- 페이지이동 Form -->
	  
      <span><button type="button" class="btn btn-info" id="listBT">뒤로</button></span>
      
      <span class="float-end"><div class="btn-group" role="group" aria-label="Basic example">
      <button type="button" class="btn btn-secondary" id="modifyBT" onclick="location.href='/community/modify?bno=<c:out value="${board.bno}" />'">수정</button>
	  <button type="button" class="btn btn-secondary" id="deleteBT" onclick="location.href='delete.do?bno=<c:out value="${board.bno}" />'">삭제</button>
	  </div></span>
		
		<form id = "actionForm" action="/community/list" method="get">
	    	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"></c:out>' >
	    	<input type="hidden" name="amount" value="<c:out value="${cri.amount }"></c:out>" >
	    	<input type="hidden" name="keyword" value="<c:out value="${cri.keyword}" />" >
	    	<input type="hidden" name="type" value="<c:out value="${cri.type}" />" >
	    </form>
	    
      <div><br><br></div>
    </div>
	
	<footer>
    	<jsp:include page="../footer.jsp"></jsp:include>
    </footer>

</body>
</html>