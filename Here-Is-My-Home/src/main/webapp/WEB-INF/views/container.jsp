<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/carousel/">

    <link href="${pageContext.request.contextPath}/resources/css/carousel.css" rel="stylesheet"></link>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  
    <title>Document</title>

</head>
<body>






<div id="carouselExample" class="carousel slide">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img/1.png" class="d-block w-100" alt="img1">
    </div>
    <div class="carousel-item">
      <img src="img/2.png" class="d-block w-100" alt="img2">
    </div>
    <div class="carousel-item">
      <img src="img/3.png" class="d-block w-100" alt="img3">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>



<main>


<div>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
</div>

 


  <!-- Marketing messaging and featurettes
  ================================================== -->
  <!-- Wrap the rest of the page in another container to center all the content. -->

  <div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
      <div class="col-lg-4">
        <img src="img/point.jfif" class="bd-placeholder-img rounded-circle" width="140" height="140" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">

        <h2 class="fw-normal">지도찾기</h2>
        <p>원하는 방을 찾아보세요</p>
        <p><a class="btn btn-secondary" href="../home/searchHome">MAP &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
       <img src="img/mypage.png" class="bd-placeholder-img rounded-circle" width="140" height="140" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">
      
        <h2 class="fw-normal">마이페이지</h2>
        <p>내가 작성한 글과 댓글을 확인하세요</p>
        <p><a class="btn btn-secondary" href="#">My page &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
      <div class="col-lg-4">
             <img src="img/community.png" class="bd-placeholder-img rounded-circle" width="140" height="140" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">
   
             <h2 class="fw-normal">커뮤니티</h2>
        <p>다양한 콘텐츠들과 모임 커뮤니티, 분실/실종 커뮤니티까지 </p>
        <p><a class="btn btn-secondary" href="/community/list">Community &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette">
      <div class="col-md-7">
        <h2 class="featurette-heading fw-normal lh-1">내 조건에 맞는 방찾기<span class="text-muted">  </span></h2>
        <p class="lead">월세, 전세, 단기 임대 원하는 방을 찾아보세요. </p>
        <p class="lead">옥탑방,테라스 원룸,아파트,분양,원룸,빌라,오피스텔까지</p>
      </div>
      <div class="col-md-5">
      <img src="img/bedroom.jfif" class="bd-placeholder-img rounded-circle" width="400" height="400" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">
   
             </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
      <div class="col-md-7 order-md-2">
        <h2 class="featurette-heading fw-normal lh-1">지도로 매물찾기<span class="text-muted"></span></h2>
        <p class="lead">지도로 확인하세요.</p>
        <p class="lead">한 눈에 확인할 수 있는 매물찾기와 클릭 한번으로 비대면 예약까지 가능합니다.</p>
       
             </div>
      <div class="col-md-5 order-md-1">
       <img src="img/findmap.jpg" class="bd-placeholder-img rounded-circle" width="400" height="400" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">
      </div>
    </div>

    <hr class="featurette-divider">



    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->

  </div><!-- /.container -->


  <!-- FOOTER -->
  <footer class="container">
    <p class="float-end"><a href="#">Back to top</a></p>
  </footer>
</main>


    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

      


</body>
</html>