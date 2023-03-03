<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/bootstrap.min.css" rel="stylesheet"></link>
    <link href="/css/imchaLogin.css" rel="stylesheet"></link>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script>
  	$(function() {
  		$("#find_id_btn").click(function(){
  			location.href="../member/findId";
  		})
  	})
  </script>
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
  <!-- 네브바 -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="/index"><img src="/img/house.png"></a>
      <div class="collapse navbar-collapse" id="navbarColor03">
        
        <!-- <a href="/index" class="btn btn-secondary my-2 my-sm-0" type="submit">Login</a> -->
      </div>
    </div>
  </nav>
  <!-- 네브바 끝 -->
  
  <div class="container">
  	<form id="login_form" method="post">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h1 style="text-align:center;"  class="mb-3">로그인</h1>
        <form class="validation-form" novalidate>
        
          <!-- <fieldset class="form-group">
            <div class="form-check">
              <input class="form-check-input" type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
              <label class="form-check-label" for="optionsRadios1">일반회원</label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
              <label class="form-check-label" for="optionsRadios2">중개인회원</label>
            </div>
          </fieldset> -->

          <div class="row">
            <div class="mb-3">
    
              <label for="id">아이디</label>
              <div class="id_input_box">
              <input type="text" class="id-input" id="imchaId" name="imchaId" required />
              <div class="invalid-feedback">
                아이디를 입력해주세요.
                </div>
              </div>
            </div>
          <div class="mb-3">
            <label for="login_password">비밀번호</label>
            <div class="pw_input_box">
            <input type="password" class="password-input" id="imchaPw" name="imchaPw" placeholder="****" required>
            <div class="invalid-feedback">
              비밀번호를 입력해주세요.
              </div>
            </div>
          </div>

          <p><a href="${pageContext.request.contextPath }/member/findId" id="findId">아이디 찾기</a></p>
          <p><a href="${pageContext.request.contextPath }/member/findPw" id="findPw">비밀번호 찾기</a></p>
        </div>
      <div class="mb-4"></div>
      <div class="col-md-6 mb-3"  >    </div>  
      <button class="btn btn-primary btn btn-block" type="submit">로그인</button> &nbsp;
      <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
        <button type="button" class="btn btn-primary">회원가입</button>
        <div class="btn-group" role="group">
          <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
          <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
            <a class="dropdown-item" href="/member/imchaJoin">일반회원가입</a>
            <a class="dropdown-item" href="/member/lessorJoin">중개인회원가입</a>
          </div>
        </div>
      </div>

      <button type="button" class="btn btn-outline-warning" style="text-decoration: none;">카카오 로그인</button>
</form>
</div>
</div>

</form>
  </div>


        <footer class="my-3 text-center text-small">
          <p>   &nbsp; </p>
              </footer>
            </div>
           <!--  <script>
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
            </script> -->



      <footer>
       <jsp:include page="../footer.jsp"></jsp:include>
    </footer>
    
    <br><br><br><br>
  </div>
  <script type="text/javascript"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
  <title>Animated Login Form</title>
  
  <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/a81368914c.js"></script>
 <link href="/css/imchaLogin.css" rel="stylesheet"></link>
 <link href="/css/bootstrap.min.css" rel="stylesheet"></link>
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

  <!-- 네브바 -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="/index"><img src="/img/house.png"></a>
      <div class="collapse navbar-collapse" id="navbarColor03">
        
        <!-- <a href="/index" class="btn btn-secondary my-2 my-sm-0" type="submit">Login</a> -->
      </div>
    </div>
  </nav>
  <!-- 네브바 끝 -->

  <img class="wave" src="/img/adminhome.png">
  <div class="container">
    <div class="img">
      <img src="">
    </div>
    <div class="login-content">
  <form id="login_form" method="post">
        <img src="/img/homes.png">
        <h2 class="title">Welcome</h2>
              <div class="input-div one">
                 <div class="i">
                    <i class="fas fa-user"></i>
                 </div>
                 <div class="div">
                    <h5>ID</h5>
                    <label id="id"></label>
                    <input type="text" class="input" id="imchaId" name="imchaId" required />
                 </div>
              </div>
              <div class="input-div pass">
                 <div class="i"> 
                    <i class="fas fa-lock"></i>
                 </div>
                 <div class="div">
                    <h5>Password</h5>
                    <input type="password" class="input" id="imchaPw" name="imchaPw" required />
                 </div>
              </div>
             <div style="display: inline-block; float:left;">
             <a href="/member/findId" id="findId">아이디</a></div>
             <div style="display: inline-block; float:left;">
             <p>&</p>
             </div>
             <div style="display: inline-block; float:left;">
             <a href="/member/findPw" id="findPw">비밀번호 찾기</a>
             </div>
             <div style="float:right;">
             <a href="/member/imchaJoin">회원가입</a>
             </div>
             
              <button type="submit" class="btn2" value="Login">Login</button>
            </form> 
        </div>
    </div>

    <script type="text/javascript">
    const inputs = document.querySelectorAll(".input");


    function addcl(){
      let parent = this.parentNode.parentNode;
      parent.classList.add("focus");
    }

    function remcl(){
      let parent = this.parentNode.parentNode;
      if(this.value == ""){
        parent.classList.remove("focus");
      }
    }


    inputs.forEach(input => {
      input.addEventListener("focus", addcl);
      input.addEventListener("blur", remcl);
    });
    </script>
    
    <footer>
       <jsp:include page="../footer.jsp"></jsp:include>
    </footer>
</body>
</html>