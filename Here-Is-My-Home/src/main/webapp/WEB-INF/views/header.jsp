<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/bootstrap.min.css" rel="stylesheet"></link>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="/index"><img src="/img/house.png"></a>
      <div class="collapse navbar-collapse" id="navbarColor03">
        <ul class="navbar-nav me-auto" >
          <li class="nav-item">
             <a class="nav-link" href="../home/searchHome">search Home</a>
          </li>
          	<li class="nav-item">
          	 	<c:if test="${member.userRoll == '일반회원' }"> 
             		<a class="nav-link" href="../mypage/mypageImcha">MyPage</a>
            	</c:if>
            	<c:if test="${lessor.userRoll == '중개인' }"> 
             		<a class="nav-link" href="../mypage/mypageLessor">MyPage</a>
            	</c:if> 
            </li>
          <li class="nav-item">
             <a class="nav-link" href="/community/list">Community</a>
          </li>
         </ul>
         
         </ul>
          <c:if test = "${member == null && lessor == null}">
         <!-- <div><a class="btn btn-secondary my-2 my-sm-0" href="/member/login">Login</a></div> -->
         <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
         <button type="button" class="btn btn-primary">Login</button>
        <div class="btn-group" role="group">
          <button id="navbarDropdownMenuLink" type="button" class="btn btn-primary dropdown-toggle dropdown-menu-end" data-bs-toggle="dropdown" aria-expanded="false"></button>
          <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="/member/login">일반회원 로그인</a>
            <a class="dropdown-item" href="/member/lessorLogin">중개인 로그인</a>
          </div>
        </div>
        </div>
          </c:if>
 
          <c:if test = "${member != null || lessor != null}">
          <div><a class="btn btn-secondary my-2 my-sm-0" href="/member/logout.do">Log-out</a></div>
          </c:if>
     </div>
	     </div>
	    </div>

  </nav>
</body>
</html>