<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
</head>
<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	
   <div class="container">
    <div class="bs-docs-section row">
     <div class="col-lg-12"><br><br>
       <h1 id="tables">수정하기</h1>
       
     <form action="updateBoard.do?bno=<c:out value="${updateboard.bno}" />" method="post" enctype="multipart/form-data">
  	   	
	   <div class="bs-component">
        <table class="table table-hover">
         <tr>
          <th scope="col" class="col col-lg-1">카테고리</th>
          <td>
           <select class="form-select" id="condition" name="category">
            <option value="<c:out value="${updateboard.category}" />"><c:out value="${updateboard.category}" /></option>
            <option value="동네소식">동네소식</option>
            <option value="동네질문">동네질문</option>
            <option value="동네맛집">동네맛집</option>
            <option value="취미생활">취미생활</option>
            <option value="자취꿀팁">자취꿀팁</option>
            <option value="도와줘요">도와줘요</option>
            <option value="분실실종">분실실종</option>
           </select>
          </td>
         </tr>
         <tr>
          <th scope="col" class="col col-lg-1">제목</th>
           <td><input type="text" class="form-control" id="title" name="title" value="<c:out value="${updateboard.title}" />" required></td>
          </tr>
          <!-- <tr>
           <th scope="col" class="col col-lg-1">첨부파일</th>
           <td><input class="form-control" type="file" id="file"></td>
          </tr> -->
          <tr>
           <th scope="col" class="col col-lg-1">내용</th>
           <td><textarea class="form-control" id="content" rows="10" name="content" required><c:out value="${updateboard.content}" /></textarea></td>
          </tr>
         </table>
        </div>
        

	     <!-- 하단 버튼 -->
	     <a href="/community/list"><button type="button" class="btn btn-info">취소하고 목록으로</button></a>
	     <span class="float-end">
	     	<button type="submit" class="btn btn-info">수정</button>
	     </span>
     </form>
      </div>
     </div>
	</div>

	
	<footer>
    	<jsp:include page="../footer.jsp"></jsp:include>
    </footer>
</body>
</html>