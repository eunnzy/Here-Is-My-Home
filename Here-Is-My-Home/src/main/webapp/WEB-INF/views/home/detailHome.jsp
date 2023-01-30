<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>매물 상세 보기</title>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<link href="/css/bootstrap.min.css" rel="stylesheet"></link>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<style>
		body {
			background-color: white;
		}
		.homeImg-div {
			border: 1px solid gray;
		}
	</style>
</head>
<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-8 homeImg-div">
				<div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="/img/b.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="..." class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="..." class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
			<div class="col-sm-4">
				
			</div>
		</div>
		
		<div class="col-sm-8">
			
		</div>
		
		
	</div>
</body>
</html>