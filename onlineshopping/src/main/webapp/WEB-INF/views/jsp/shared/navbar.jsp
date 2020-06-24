<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextRoot }/home">Shopping Platform</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li id="nav_about"><a href="${contextRoot }/about">About</a></li>
					<li id="nav_products"><a href="${contextRoot }/show/all/products">View Products</a></li>
					<li id="nav_contact"><a href="${contextRoot }/contact">Contact</a></li>
					<li id="nav-manage-products"><a href="${contextRoot }/manage/products">Manage Product</a></li>
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					<li ><a href="${contextRoot}/logout" >Logout</a></li>
					<li id="nav-cart"><a href="${contextRoot}/cart/show" >My Cart</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
