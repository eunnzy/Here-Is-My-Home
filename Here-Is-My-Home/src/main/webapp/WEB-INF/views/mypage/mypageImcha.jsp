<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./bootstrap.min.css" rel="stylesheet"></link>
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
<!--  
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#"><img src="./home.png"></a>
      <div class="collapse navbar-collapse" id="navbarColor03">
        <ul class="navbar-nav me-auto" >
          <li class="nav-item">
              <a class="nav-link active" href="#">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">MyPage</a>
            </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Community</a>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="#">Free</a>
              <a class="dropdown-item" href="#">Meeting</a>
              <a class="dropdown-item" href="#">Lost</a>
            </div>
          </li>
        </ul>
          <button class="btn btn-secondary my-2 my-sm-0" type="submit">Login</button>
      </div>
    </div>
  </nav>
-->

<!-- body -->
  <form action="mypage">
    <h2 style="text-align: center; font-weight: bold;" class="my-5">My Page</h2>
    <div class="d-flex  mx-auto ">
    <table style="margin-left: auto; margin-right: auto;" class="my-5" >
      <tr>
      	<td>
          <button class="btn btn-secondary btn-lg mx-5" type="button" onclick = "location.href = '/mypage/getMember'">회원정보수정</button>
        </td>
        <td>
          <button class="btn btn-secondary btn-lg mx-5 my-5" type="button" onclick = "location.href = '/like/likeList?imchaId=${member.imchaId}'">찜 목록</button>
        </td>
        <!-- <td>
          <button class="btn btn-secondary btn-lg mx-5" type="button" onclick = "location.href = 'MyHome.html'">내 집</button>
        </td> -->
        <td>
          <button class="btn btn-secondary btn-lg mx-5" type="button" onclick = "location.href = 'reservation_IMCHA.html'">예약 확인</button>
        </td>
        <td>
          <button class="btn btn-secondary btn-lg mx-5" type="button" onclick = "location.href = 'QNA_IMCHA.html'">문의 하기</button>
        </td>
        
      </tr>
    </table>
  </div>
  </form>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>