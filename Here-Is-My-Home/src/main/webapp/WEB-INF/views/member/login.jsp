<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/css/bootstrap.min.css" rel="stylesheet"></link>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <style>
      .input-form {
        max-width: 680px;
  
        margin-top: 80px;
        padding: 32px;
  
        background: #fff;
        -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
        -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
        -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
        box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
      }
    </style>
    <title>Document</title>
</head>
<body>
  <header>
		<jsp:include page="../header.jsp"></jsp:include>
  </header>
  
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h1 style="text-align:center;"  class="mb-3">   </h1>
        <h1 style="text-align:center;"  class="mb-3">로그인</h4>
        <form class="validation-form" novalidate>

          <fieldset class="form-group">
            <div class="form-check">
              <input class="form-check-input" type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
              <label class="form-check-label" for="optionsRadios1">일반회원</label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
              <label class="form-check-label" for="optionsRadios2">중개인회원</label>
            </div>
          </fieldset>

          <div class="row">
            <div class="mb-3">
              <label for="name">아이디</label>
              <input type="text" class="form-control" id="name" placeholder="" value="" required>
              <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div>
            </div>
          <div class="mb-3">
            <label for="password">비밀번호</label>
            <input type="password" class="form-control" id="password" placeholder="****" required>
            <div class="invalid-feedback">
              비밀번호를 입력해주세요.
            </div>
          </div>
          <p><a href="아이디찾기.html">아이디/비밀번호찾기</a></p>
        </div>
      <div class="mb-4"></div>
      <div class="col-md-6 mb-3"  >    </div>  
      <button class="btn btn-primary btn btn-block" type="submit">로그인</button> &nbsp;
      <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
        <button type="button" class="btn btn-primary">회원가입</button>
        <div class="btn-group" role="group">
          <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
          <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
            <a class="dropdown-item" href="/Front/일반회원가입.html">일반회원가입</a>
            <a class="dropdown-item" href="/Front/중개인회원가입.html">중개인회원가입</a>
          </div>
        </div>
      </div>

      <button type="button" class="btn btn-outline-warning" style="text-decoration: none;">카카오 로그인</button>
</form>
  </div>

</div>
</div>
        <footer class="my-3 text-center text-small">
          <p>   &nbsp; </p>
              </footer>
            </div>
            <script>
              window.addEventListener('load', () => {
                const forms = document.getElementsByClassName('validation-form');
          
                Array.prototype.filter.call(forms, (form) => {
                  form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                      event.preventDefault();
                      event.stopPropagation();
                    }
          
                    form.classList.add('was-validated');
                  }, false);
                });
              }, false);
            </script>



  <!-- footer -->
  <div style="background-color: #dbe2f0; text-align: center;">
    <br><br>
    <div>
        <a href="#">이용약관</a>   
        <a href="#">개인정보처리방침</a>
        <a href="#">프로젝트소개</a><hr>
        <a href="https://icons8.com/illustrations/author/zD2oqC8lLBBA">Icons 8</a> from <a href="https://icons8.com/illustrations">Ouch!</a>
    </div>
    
    <br><br><br><br>
  </div>

 </body>
</html>