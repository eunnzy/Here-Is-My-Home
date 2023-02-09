<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Community List</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#regBT").on("click", function() {
		self.location = "/community/register";
	});
	
	var actionForm = $("#actionForm");
	$(".page-item a").on("click", function(e) {
		e.preventDefault();
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	$(".move").on("click", function(e) {
		e.preventDefault();
		actionForm.append("<input type='hidden' name='bno' value='" + $(this).attr("href") + "'>");
		actionForm.attr("action", "/community/get");
		actionForm.submit();
	});
	
	history.replaceState({}, null, null);
	
	var searchForm = $("#searchForm");
	$("#searchForm button").on("click", function(e) {
		searchForm.find("input[name='pageNum']").val(1);
		e.preventDefault();
		searchForm.submit();
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
            <h1 id="tables">Community</h1>
            <p>이매동</p>
                
            <span class="float-end">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">카테고리</a>
            	<div class="dropdown-menu">
                 <a class="dropdown-item" href="#">동네소식</a>
                 <a class="dropdown-item" href="#">동네질문</a>
                 <a class="dropdown-item" href="#">동네맛집</a>
                 <a class="dropdown-item" href="#">도와줘요</a>
                 <a class="dropdown-item" href="#">분실/실종센터</a>
                 <a class="dropdown-item" href="#">전국취미생활</a>
                 <a class="dropdown-item" href="#">전국자취꿀팁</a>
                </div>
            </span><br><br>
            
            <!-- 검색창 -->
            <form class="d-flex" id="searchForm" action="/community/list" method="get">
              <select class="form-select" id="condition" style="width: 25%;" name="type" required>
              	<option value="" <c:out value="${pageMaker.cri.type == null?'selected':''}" />> Search List </option>
                <option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}" />> Title </option>
                <option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}" />> Content </option>
                <option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}" />> Title or Content </option>
              </select>
              
              <input class="form-control me-sm-2" type="search" placeholder="Search" name="keyword"
               value='<c:out value="${pageMaker.cri.keyword}" />' required>
               <input type="hidden" name="pageNum" value="<c:out value="${pageMaker.cri.pageNum }" />" >
               <input type="hidden" name="amount" value="<c:out value="${pageMaker.cri.amount }" />" >
              <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
            </form><br>

            <!-- 게시판시작 -->
            <div class="bs-component">
              <table class="table table-hover" style="text-align: center;">
                  <tr>
                    <th scope="col" style="width: 10%;">Category</th>
                    <th scope="col" style="width: 40%;">Title</th>
                    <th scope="col" style="width: 15%;">Name</th>
                    <th scope="col" style="width: 15%;">Time</th>
                    <th scope="col" style="width: 10%;">Views</th>
                    <th scope="col" style="width: 10%;">Likes</th>
                  </tr>
                  <!-- 공지 -->
                  <tr class="table-warning">
                    <td></td>
                    <td><a href="/Front/New/View.html" style="text-decoration: none;">공지제목</a></td>
                    <td></td>
                    <td>작성일</td>
                    <td></td>
                    <td></td>
                  </tr>
                  <!-- 목록리스트 -->
                  <c:forEach items="${list}" var="board">
                  <tr class="table-light">
                    <td><c:out value="${board.category}" /></td>
                    <td><a class="move" href="<c:out value="${board.bno}" />" style="text-decoration:none;"><c:out value="${board.title}" /></a></td>
                    <td><c:out value="${board.imchaid}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
                    <td><c:out value="${board.views}" /></td>
                    <td><c:out value="${board.likes}" /></td>
                  </tr>
                  </c:forEach>
              </table>
            </div>
        </div>
        </div>
        
        <!-- 페이징 -->
        <div>
          <ul class="pagination pagination-sm">
          
          	<c:if test="${pageMaker.prev}">
          	  <li class="page-item">
                <a class="page-link" href="${pageMaker.startPage -1}">&laquo;</a>
              </li>
          	</c:if>
          	
          	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
          		<li class="page-item ${pageMaker.cri.pageNum == num ? "active" : ""} " >
          		<a class="page-link" href="${num}">${num}</a>
          		</li>
          	</c:forEach>
          	
          	<c:if test="${pageMaker.next}">
          	  <li class="page-item">
                <a class="page-link" href="${pageMaker.endPage +1 }">&raquo;</a>
              </li>
          	</c:if>
          </ul>
        </div>

        <!-- 하단 버튼 -->
        <span><button type="button" class="btn btn-info">내가 쓴 글</button></span>
        <span class="float-end"><button type="button" class="btn btn-info" id="regBT">글쓰기</button></span>
        <div><br><br></div>
    </div>
    
    <!-- 페이지이동 Form -->
    <form id = "actionForm" action="/community/list" method="get" >
    	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }" >
    	<input type="hidden" name="amount" value="${pageMaker.cri.amount }" >
    	<input type="hidden" name="keyword" value="<c:out value="${pageMaker.cri.keyword}" />" >
    	<input type="hidden" name="type" value="<c:out value="${pageMaker.cri.type}" />" >
    </form>
	
	<footer>
    	<jsp:include page="../footer.jsp"></jsp:include>
    </footer>
</body>
</html>