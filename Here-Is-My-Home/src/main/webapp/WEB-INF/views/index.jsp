<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
	 <header>
		<jsp:include page="header.jsp"></jsp:include>
 	 </header>
	
	<div style="background-color: white;">
	<jsp:include page="container.jsp"></jsp:include>

	</div>

    <footer>
    	<jsp:include page="footer.jsp"></jsp:include>
    </footer>
</body>
</html>