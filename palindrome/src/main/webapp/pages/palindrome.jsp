<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>
 
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="${pageContext.request.contextPath}/pages/css/bootstrap.css" />" rel="stylesheet">
	
    <!-- Custom styles for this template -->
    <link href="<c:url value="${pageContext.request.contextPath}/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="asd" style="display: inline-flex;">
		<div class="jumbotron" style="width: 300px;height: 300px; margin-left: 60px; margin-top: 40px;">
			<form action="/count" method=POST>
			
			  <div class="form-group">
			    	<label for="exampleInputEmail1">Nubmer</label>
			    	<input type="text" name="number" class="form-control" placeholder="Number" pattern="^[0-9]+$">
			  </div>
			  <div class="form-group">
			    	<label for="exampleInputPassword1">Number or palindromes</label>
			    	<input type=text name="numberOfPalindromes" class="form-control" placeholder="Number or palindromes" pattern="^[0-9]+$">
			  </div>
			  <button type="submit" class="btn btn-primary">Find</button>
			</form>
		</div>
		<div class="jumbotron" style="width: 450px; margin-left: 400px; margin-top: 40px;">
		<h1 styly="margin-top:0px;">History</h1>
		<p>Number = ${NUMBER}</p>
		<p>Result:</p>
			<c:forEach var="listOfPalindromes" items="${listOfPalindromes}">   	
			   	<p><c:out value="${listOfPalindromes}"/></p>
			</c:forEach>
		</div>
	</div>
</body>
</html>