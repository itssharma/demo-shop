<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<div class="container">

	<div class="row">
		
		<!-- checking if any product added -->
			<c:if test="${not empty message }">
				<div class="col-md-offset-1 col-md-10">
					<div class="bg-danger" id="alert">
						${message }
						<hr>
					</div>
				</div>
			</c:if>
	
		<div class="col-md-offset-2 col-md-8">
		
		<!-- adding panel view -->
			<div class="panel panel-success">
				<div class="panel-heading panel-title">Add Product</div>
				<div class="panel-body">
				
				<!-- form for adding product -->
					<sf:form class="form-horizontal" action="${contextRoot }/manage/products/add" method="POST" 
						enctype="multipart/form-data" modelAttribute="product">
						
						<!-- hidden fields -->
								<sf:hidden path="id"/>	
								<sf:hidden path="code"/>
								<sf:hidden path="active"/>
								<sf:hidden path="supplierId"/>
								<sf:hidden path="purchases"/>
								<sf:hidden path="views"/>
						
						<div class="form-group">
							<sf:label class="control-label col-sm-3" path="name">Product Name</sf:label> 
							<div class="col-sm-9">
								<sf:input type="text" path="name" placeholder="Enter product name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group">
							<sf:label class="control-label col-sm-3" path="brand">Product Brand</sf:label> 
							<div class="col-sm-9">
								<sf:input type="text" path="brand" placeholder="Enter product brand" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group">
							<sf:label class="control-label col-sm-3" path="description">Product Description</sf:label> 
							<div class="col-sm-9">
								<sf:textarea rows="3" path="description" placeholder="Enter product description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group">
							<sf:label class="control-label col-sm-3" path="unitPrice">Product Price</sf:label> 
							<div class="col-sm-4">
								<sf:input type="number" path="unitPrice" placeholder="Enter product price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group">
							<sf:label class="control-label col-sm-3" path="quantity">Product Qnt. Available</sf:label> 
							<div class="col-sm-3">
								<sf:input type="number" path="quantity"  class="form-control" />
								<sf:errors path="quantity" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="file">Upload Product image</label> 
							<div class="col-sm-6">
								<sf:input type="file" path="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group">
							<sf:label class="control-label col-sm-3" path="categoryId">Category</sf:label> 
							<div class="col-sm-6">
								<sf:select class="form-control" path="categoryId"
									items="${categories}" itemValue="id"
									itemLabel="name">

								</sf:select>
							</div>
						</div>
						
						<div class="form-group">
							 
							<div class="col-md-offset-4">
								<input type="submit" value="Submit" class="btn btn-success"/>
								
							</div>
						</div>
						
			
					</sf:form>

				</div>
			</div>
		</div>
	</div>

	<!-- showing all products -->
	<div class="row">
		<div class="col-sm-offset-1 col-sm-10">
			<h2> Products list</h2>
		</div>
		
		<!-- table content -->
		<div class="col-sm-offset-1 col-sm-10 table-responsive">
			
			<table id="admin-products-table" class="table table-bordered"
				style="overflow:auto">
				<thead>
					<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Brand</td>
					<td>Price</td>
					<td>Qnt available</td>
					<td>Active State</td>
					<td></td>
					</tr>
				</thead>
				
			</table>
			
		</div>
	</div>
</div>

