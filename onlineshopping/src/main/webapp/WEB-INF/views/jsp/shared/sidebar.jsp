<p class="lead">Categories</p>
<div class="list-group">
	<c:forEach items="${allcategories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="sb_${category.id}">${category.name}</a>
	</c:forEach>
</div>