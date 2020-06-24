<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>${title} - ShoppingPlatform</title>

<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap core CSS -->
<link href="${contextRoot}/css/bootstrap.css" rel="stylesheet">

<!-- Bootstrap cerulean theme bootswatch -->
<link href="${contextRoot}/css/bootstrap-cerulean-theme.min.css" rel="stylesheet">

<!-- datatable Bootstrap CSS-->
<link href="${contextRoot}/css/dataTables.bootstrap.min.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${contextRoot}/css/shop-homepage.css" rel="stylesheet">


</head>

<body>

	<!-- Navigation -->
	<div class="wrapper">
		<%@ include file="./shared/navbar.jsp"%>
		<div class="container">


	
	</div>
        

	</div>
	
	<!-- JavaScript -->
	
	<!-- unstyled bootstrap template JavaScript -->
	<script src="${contextRoot}/js/jquery-shop-homepage.js"></script>
	
	<!-- bootstrap JavaScript -->
	<script src="${contextRoot}/js/bootstrap.js"></script>
	
	<!-- Jquery datatable plugin JavaScript -->
	<script src="${contextRoot}/js/jquery.dataTables.min.js"></script>
	
	<!-- Jquery datatable bootstrap JavaScript -->
	<script src="${contextRoot}/js/dataTables.bootstrap.min.js"></script>
	
	<!-- bootbox cdn -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.0.0/bootbox.min.js"></script>
	
	<!-- self local JavaScript -->
	<script src="${contextRoot}/js/home.js"></script>
</body>

</html>
