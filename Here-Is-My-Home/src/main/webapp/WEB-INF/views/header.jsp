<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
              <a class="nav-link active" href="../home/search">search Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">MyPage</a>
            </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Community</a>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="/community/freeBoard">Free</a>
              <a class="dropdown-item" href="#">Meeting</a>
              <a class="dropdown-item" href="#">Lost</a>
            </div>
          </li>
        </ul>
          <a class="btn btn-secondary my-2 my-sm-0" href="/member/login">Login</a>
      </div>
    </div>
  </nav>

  </body>
</html>