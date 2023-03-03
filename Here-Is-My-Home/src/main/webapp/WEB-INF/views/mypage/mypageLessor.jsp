<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="./bootstrap.min.css" rel="stylesheet"></link>
    <title>Document</title>
</head>
<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>

<!-- body -->

  <form>
    <h2 style="text-align: center; font-weight: bold;" class="my-5">My Page</h2>
    <div class="d-flex  mx-auto ">
    <table style="margin-left: auto; margin-right: auto;" class="my-5" >
      <tr>
      	<td>
          <button class="btn btn-secondary btn-lg mx-5" type="button" onclick = "location.href = '/mypage/getLessor'">회원 정보 수정</button>
        </td>
        <td>
          <button class="btn btn-secondary btn-lg mx-5 my-5" type="button" onclick = "location.href = '/home/manage/list'">매물 관리</button>
        </td>
        <td>
          <button class="btn btn-secondary btn-lg mx-5" type="button" onclick = "location.href = '/home/reservation/lessorList?lessorId=${lessor.lessorId}'">예약 확인</button>
        </td>
        <td>
          <button class="btn btn-secondary btn-lg mx-5" type="button" onclick = "location.href = 'Answer_Borad.html'">1대1 문의</button>
        </td>
        <td>
          <button class="btn btn-secondary btn-lg mx-5" type="button" onclick = "location.href = 'QNA_LESSOR.html'">관리자 문의</button>
        </td>
      </tr>
    </table>
  </div>
  </form>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>