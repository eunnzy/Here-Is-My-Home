<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community List</title>
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
            <form class="d-flex">
              <select class="form-select" id="condition" style="width: 10%;">
                <option>제목</option>
                <option>내용</option>
              </select>
              <input class="form-control me-sm-2" type="search" placeholder="Search">
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
                    <td><a href="/community/get?bno=<c:out value="${board.bno}" />" style="text-decoration:none;"><c:out value="${board.title}" /></a></td>
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
            <li class="page-item disabled">
              <a class="page-link" href="#">&laquo;</a>
            </li>
            <li class="page-item active">
              <a class="page-link" href="#">1</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">3</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">4</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">5</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">&raquo;</a>
            </li>
          </ul>
        </div>

        <!-- 하단 버튼 -->
        <span><button type="button" class="btn btn-info">내가 쓴 글</button></span>
        <span class="float-end">
          <a href="/community/register" style="text-decoration: none;"><button type="button" class="btn btn-info">글쓰기</button></a>
        </span>
        </span>
        <div><br><br></div>
    </div>
	
	<footer>
    	<jsp:include page="../footer.jsp"></jsp:include>
    </footer>
</body>
</html>