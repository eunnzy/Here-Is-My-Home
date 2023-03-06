<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/bootstrap.min.css" rel="stylesheet"></link>
<link href="/css/lessorLogin.css" rel="stylesheet"></link>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
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
		</div>
	</nav>
	<!-- 네브바 끝 -->

	<div class="container">
		<form id="login_form" method="post">
			<div class="input-form-backgroud row">
				<div class="input-form col-md-12 mx-auto">
					<h1 style="text-align: center;" class="mb-3">중개인 로그인</h1>
					<form class="validation-form" novalidate>


						<div class="row">
							<div class="mb-3">

								<label for="id">아이디</label>
								<div class="id_input_box">
									<input type="text" class="id-input" id="lessorId"
										name="lessorId" required />
									<div class="invalid-feedback">아이디를 입력해주세요.</div>
								</div>
							</div>
							<div class="mb-3">
								<label for="login_password">비밀번호</label>
								<div class="pw_input_box">
									<input type="password" class="password-input" id="lessorPw"
										name="lessorPw" placeholder="****" required>
									<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
								</div>
							</div>


							<div class="d-inline mr-5 mb-4">
								<a 	href="${pageContext.request.contextPath }/member/findLessorId" id="findLessorId">아이디 찾기</a> 
								<a  href="${pageContext.request.contextPath }/member/findLessorPw" id="findLessorPw">비밀번호 찾기</a>
							</div>

						</div>
						
						<div class="d-grid gap-2 mx-auto mb-2">
							<button type="button" class="btn btn-outline-warning" style="text-decoration: none;">카카오 로그인</button>
							<button class="btn btn-primary btn btn--md-block" type="submit">로그인</button>
							<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
								<button type="button" class="btn btn-primary">회원가입</button>
								<div class="btn-group" role="group">
									<button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle dropdown-menu-end" data-bs-toggle="dropdown" aria-expanded="false"></button>
									<div class="dropdown-menu dropdown-menu-end" aria-labelledby="btnGroupDrop1">
										<a class="dropdown-item" href="/member/userJoin">일반회원가입</a> 
										<a class="dropdown-item" href="/member/lessorJoin">중개인회원가입</a>
									</div>
								</div>
							</div>	
						</div>
						
					</form>
				</div>
			</div>

		</form>
	</div>


	<footer class="my-3 text-center text-small">
		<p>&nbsp;</p>
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



	<!-- footer -->
	<footer>
       <jsp:include page="../footer.jsp"></jsp:include>
    </footer>

	<br>
	<br>
	<br>
	<br>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>