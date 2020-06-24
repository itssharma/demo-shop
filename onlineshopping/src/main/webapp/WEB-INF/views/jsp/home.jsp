<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	window.category_id = '${category.id}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${contextRoot}/css/bootstrap.css" rel="stylesheet">

<!-- Bootstrap cerulean theme bootswatch -->
<link href="${contextRoot}/css/bootstrap-cerulean-theme.min.css" rel="stylesheet">

<!-- datatable Bootstrap CSS-->
<link href="${contextRoot}/css/dataTables.bootstrap.min.css" rel="stylesheet">

<!-- datatable buttons Bootstrap CSS-->
<link href="${contextRoot}/css/buttons.bootstrap.min.css" rel="stylesheet">

<!-- datatable select Bootstrap CSS-->
<link href="${contextRoot}/css/select.dataTables.min.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${contextRoot}/css/shop-homepage.css" rel="stylesheet">
<link href="${contextRoot}/css/shop-homepage-test.css" rel="stylesheet">



</head>

<body>

	<!-- Navigation -->
	<div class="wrapper">
		<%@ include file="./shared/navbar.jsp"%>


		<!-- Page Content -->
		<div class="content">
			<!-- loading page content on user click - home -->
			<c:if test="${userClickHome == true}">
				<%@ include file="./shared/pagecontent.jsp"%>
			</c:if>

			<!-- loading page content on user click - about -->
			<c:if test="${userClickAbout == true}">
				<%@ include file="./shared/about.jsp"%>
			</c:if>

			<!-- loading page content on user click - contact -->
			<c:if test="${userClickContact == true}">
				<%@ include file="./shared/contact.jsp"%>
			</c:if>
			
			<!-- loading page content on user click - all products -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@ include file="./shared/allproducts.jsp"%>
			</c:if>
			
			<!-- loading product on user click - selected product -->
			<c:if test="${userClickProduct == true}">
				<%@ include file="./shared/product.jsp"%>
			</c:if>
			
			<!-- loading admin mange product on user click - manage product -->
			<c:if test="${userClickManageProduct == true}">
				<%@ include file="./shared/manageproducts.jsp"%>
			</c:if>
			
			<!-- loading cart on user click - my cart -->
			<c:if test="${userClickShowCart == true}">
				<%@ include file="./shared/cart.jsp"%>
			</c:if>
		</div>

		<!-- footer -->
		<%@ include file="./shared/footer.jsp"%>

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
	
	<!-- Jquery datatable buttons plugin JavaScript -->
	<script src="${contextRoot}/js/datatables.buttons.min.js"></script>
	
	<!-- Jquery datatable select plugin JavaScript -->
	<script src="${contextRoot}/js/datatables.select.min.js"></script>
	
	<!-- Jquery datatable buttons bootstrap JavaScript -->
	<script src="${contextRoot}/js/buttons.bootstrap.min.js"></script>
	
	
	<!-- bootbox cdn -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.0.0/bootbox.min.js"></script>
	
	<!-- self local JavaScript -->
	<script src="${contextRoot}/js/home.js"></script>
</body>

</html>
