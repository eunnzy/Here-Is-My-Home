<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>분실 게시판</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/bootstrap.min.css" rel="stylesheet"></link>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	
</head>
<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
	<div class="container">
        <div class="bs-docs-section row">
          <div class="col-lg-12">
            <br><br>
              <h1 id="tables">LostBoard</h1>
              <form class="d-flex">
                <input class="form-control me-sm-2" type="search" placeholder="Search">
                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
              </form>

            <div class="bs-component">
              <table class="table table-hover" style="text-align: center;">
                <thead>
                  <tr>
                    <th scope="col" class="col col-lg-6">Title</th>
                    <th scope="col" class="col col-lg-2">Name</th>
                    <th scope="col" class="col col-lg-2">Time</th>
                    <th scope="col" class="col col-lg-2">Views</th>
                  </tr>
                </thead>
                <tbody>
                    <tr class="table-light">
                      <th scope="row"><a href="/Front/LostView.html" style="text-decoration: none;">TEST게시판글</a></th>
                      <td>쏭쓰</td>
                      <td>2023.01.23 23:00</td>
                      <td>100</td>
                    </tr>
                    <tr class="table-light">
                      <th scope="row">제목</th>
                      <td>작성자</td>
                      <td>작성일</td>
                      <td>조회수</td>
                    </tr>
                </tbody>
              </table>
            </div>
        </div>
        </div>
        
        <!-- 페이지 수 -->
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
        <span class="float-end"><a href="/Front/LostWrite.html" style="text-decoration: none;"><button type="button" class="btn btn-info">글쓰기</button></a></span>
        <div><br><br></div>
    </div>
      <!-- footer -->
  <div style="background-color: #dbe2f0; text-align: center;">
    <br><br>
    <dib>
        <a href="#">이용약관</a>   
        <a href="#">개인정보처리방침</a>
        <a href="#">프로젝트소개</a><hr>
        <a href="https://icons8.com/illustrations/author/zD2oqC8lLBBA">Icons 8</a> from <a href="https://icons8.com/illustrations">Ouch!</a>
    </div>
    
    <br><br><br><br>
  </div>

</body>
</html>