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
      $(function() {
        var $mymodal = $("#mymodal");
        $mymodal.hide();
        $("#deleteBT").on("click",function(){
          $mymodal.show();
          $("#Y").on("click", function() {
            self.location = "delete.do?bno=<c:out value="${board.bno}" />"
          });
          $("#N").on("click", function() {
            return;
          });
      });
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
      <span><a href="/community/list"><button type="button" class="btn btn-info" >목록</button></a></span>
      <span class="float-end">
        <div class="btn-group" role="group" aria-label="Basic example">
          <a href="/community/modify?bno=<c:out value="${board.bno}" />" style="text-decoration: none;">
            <button type="button" class="btn btn-secondary">수정</button>
          </a>
          
          <%-- <a href="delete.do?bno=<c:out value="${board.bno}" />" style="text-decoration: none;"> --%>
            <button type="button" class="btn btn-secondary" id="deleteBT">삭제</button>
          <!-- </a> -->
          
        <!-- 삭제 모달 -->
        
        <div class="modal" id="mymodal">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Modal title</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true"></span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p>작성하신 글을 삭제하시겠어요?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" id="N">Yes</button>
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="N">No</button>
		      </div>
		    </div>
		  </div>
		</div>
        </div>
      </span> <!-- 하단 버튼 끝 -->
      
      <div><br><br></div>
    </div>
	
	<footer>
    	<jsp:include page="../footer.jsp"></jsp:include>
    </footer>

</body>
</html>