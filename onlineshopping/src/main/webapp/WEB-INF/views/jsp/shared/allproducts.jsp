<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

<div class="container">
	
	<div class="row">
		<div class="col-md-3">
			<%@ include file="./sidebar.jsp"%>
		</div>


		<!-- Products content -->
		<div class="col-md-9">
			<nav aria-label="breadcrumb">

				<!-- All products breadcrumb menu -->
				<c:if test="${userClickAllProducts == true}">
					
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
						<c:forEach var="category" items="${allcategories}">
							<li class="breadcrumb-item"><a
								href="${contextRoot }/show/category/${category.id}/products">${category.name }</a></li>
						</c:forEach>
					</ol>



				</c:if>

				<!-- Category based products breadcrumb menu -->
				<c:if test="${userClickCategoryProducts == true}">

					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextRoot }/home">Home</a></li>
						<li class="breadcrumb-item">Category</a></li>
						<li class="breadcrumb-item">${category.name}</a>
						</li>
					</ol>
				</c:if>

			</nav>

			<!-- table content -->
			<!-- <div class="table-responsive">
				<table id="products-table" class="table table-hover table-bordered"
					style="width: 100%">
					<thead>
						<tr>
							<td>Name</td>
							<td>Brand</td>
							<td>Description</td>
							<td>Price</td>
							<td>Qnt. Available</td>
							<td></td>
						</tr>
					</thead>
				</table>
			</div>
			
			<hr>
			<hr> -->
			<!-- product added to cart msg -->\
			<c:if test="${not empty message }">
				<div class="col-md-offset-1 col-md-10">
					<div class="bg-info" id="alert">
						${message }
						<hr>
					</div>
				</div>
			</c:if>
			
			<div id="test-button" style="float:right;">
			
			</div>
			
			<div class="alert alert-primary" role="alert">
				Row data: <span id="row-data"></span>
	
			</div>
			
			


			<!-- table content all products view test-->
			<div class="table-responsive">
				<table id="products-table-test" class="display table table-hover table-bordered"
					 style="width: 100%">
					<thead>
						<tr>
						<td></td>
							<td>Name</td>
							<td>Brand</td>
							<td>Description</td>
							<td>Price</td>
							<td>Qnt. Available</td>
							<td></td>
						</tr>
					</thead>
				</table>
				
				
			</div>

		</div>
	</div>

</div>