/*$(function() {
	// solving active menu problem
	switch (menu) {
	case 'About':
		$('#nav_about').addClass('active');
		break;

	case 'Contact':
		$('#nav_contact').addClass('active');
		break;

	default:
		if(menu == "Home") break;
		$('#nav_products').addClass('active');
		$('#sb_'+category_id).addClass('active');
		break;
	}
});*/

$(document).ready(function(){
	
	// solving active menu problem
	switch (menu) {
	case 'About':
		$('#nav_about').addClass('active');
		break;

	case 'Contact':
		$('#nav_contact').addClass('active');
		break;

	case 'Manage Products':
		$('#nav-manage-products').addClass('active');
		break;
		
	case 'My Cart':
		$('#nav-cart').addClass('active');
		break;
		
	default:
		if(menu == "Home") break;
		$('#nav_products').addClass('active');
		$('#sb_'+category_id).addClass('active');
		break;
	}
	
	//displaying products table
	var jsonURL = "";
	if(menu == "ALL Products"){
		if(category_id==""){
			jsonURL = contextRoot + "/api/products";
		}else{
			jsonURL = contextRoot + "/api/category/" + category_id + "/products";
		}
	}else if(menu == "My Cart"){
		jsonURL = contextRoot + "/api/cartitems/show";
		console.log("api url veridied");
	}else{
		if(category_id==""){
			jsonURL = contextRoot + "/api/manage/products";
			
		}else{
			jsonURL = contextRoot + "/api/manage/category/" + category_id + "/products";
		}
	}
	
	console.log(category_id);
	/*$('#products-table').DataTable({
		pageLength: 5,
		"lengthMenu": [ [-1,5,10], ["All Rec", "5 Rec", "10 Rec"]],
		
		ajax:{
			url: jsonURL,
			dataSrc: ""
		},
		dom: 'Bfrtip',
	    buttons: [
	        'excel'
	    ],
		columns:[
			{"data": "name"},
			{"data": "brand"},
			{"data": "description"},
			{"data": "unitPrice",
				"render": function(data, type, row, meta){
					return '<span>&#8377;' + data + '</span>';
				}
			},
			{"data": "quantity"},
			{data: "id",
			 bSortable: false,
				render: function(data, type, row, meta){
					var icon_view = '<a href="' + contextRoot + '/show/product/' + data + '" type="button" class="btn btn-danger"><span class="glyphicon glyphicon-eye-open" > </span> </a>';
					var icon_cart = '<a href="' + contextRoot + '/cart/add/' + data + '" type="button" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart" > </span> </a>';
						return icon_view + '&#x2003;' + icon_cart;
				}
			}
		]
	});*/
	
	//cart-table
	$('#cart-table').DataTable({
		pageLength: 5,
		"lengthMenu": [ [-1,5,10], ["All Rec", "5 Rec", "10 Rec"]],
		
		ajax:{
			url: jsonURL,
			dataSrc: ""
		},
		columns:[
			{
	               'orderable': false,
	               'data': null,
	               'className': 'text-center',
	               'render': function(data, type, full, meta){
	                  if (type === 'display'){
	                     data = '<i class="fa fa-user fa-fw"></i>';
	                     data = '<img src="https://i.pravatar.cc/150?name=' + encodeURIComponent(full['name']) + '" class="avatar border rounded-circle">';
	                  }
	                  
	                  return data;
	               }
	           },
			{"data": "product",
				bSortable:false,
				render: function(data, type, row, meta){
					var product_description = data.name + '<br>' + data.brand + '<br>' + data.description;
					return product_description;
				}
			},
			{"data": "product",
				"render": function(data, type, row, meta){
					return '<span>&#8377;' + data.unitPrice + '</span>';
				}
			},
			{"data": "productCount"},
			{"data": "productCount",
				bSortable:false,
				"render": function(data, type, row, meta){
					return '<span>&#8377;' + data * row.product.unitPrice + '</span>';
				}
			},
			{"data": "id",
			 bSortable: false,
				render: function(data, type, row, meta){
					var icon_view = '<a href="' + contextRoot + '/show/product/' + data + '" type="button" class="btn btn-danger"><span class="glyphicon glyphicon-eye-open" > </span> </a>';
					var icon_cart = '<a href="' + contextRoot + '/cart/add/' + data + '" type="button" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart" > </span> </a>';
						return icon_view + '&#x2003;' + icon_cart;
				}
			}
		]
	});
	
	//toggling-card-table
//	$(document).ready(function () {

		   var table = $('#products-table-test').DataTable({
		         'dom':'lBfrtip',
//		            "<'row'<'col-sm-12 col-md-6'l><'col-sm-12 col-md-6'<'float-md-right ml-2'B>f>>" +
//		            "<'row'<'col-sm-12'tr>>" +
//		            "<'row'<'col-sm-12 col-md-5'i><'col-sm-12 col-md-7'p>>",
		            'ajax':{
		    			url: jsonURL,
		    			dataSrc: ""
		    		},
		         'buttons': [ 'csv', {
		            //'text': '<i class="fa fa-id-badge fa-fw" aria-hidden="true"></i>',
 					'text': '<span class="glyphicon glyphicon-align-justify" id="btn-change-view" aria-hidden="true">Change View</span>',
		            'action': function (e, dt, node) {

		               $(dt.table().node()).toggleClass('cards');
		               $('#btn-change-view', node).toggleClass('glyphicon-th glyphicon-align-justify');

		               dt.draw('page');
		            },
		            'className': 'btn-sm btn-info',
		            'attr': {
		               'title': 'Change views',
		            }
		         }],
		         'select': 'single',
		         'columns': [
		            {
		               'orderable': false,
		               'data': null,
		               'className': 'text-center',
		               'render': function(data, type, full, meta){
		                  if (type === 'display'){
		                     data = '<i class="fa fa-user fa-fw"></i>';
		                     data = '<img src="https://i.pravatar.cc/150?name=' + encodeURIComponent(full['name']) + '" class="avatar border rounded-circle">';
		                  }
		                  
		                  return data;
		               }
		            },
		        	 {"data": "name"},
		            {"data": "brand"},
					{"data": "description"},
					{"data": "unitPrice",
						"render": function(data, type, row, meta){
							return '<span>&#8377;' + data + '</span>';
						}
					},
					{"data": "quantity"},
					{data: "id",
					 bSortable: false,
						render: function(data, type, row, meta){
							var icon_view = '<a href="' + contextRoot + '/show/product/' + data + '" type="button" class="btn btn-danger"><span class="glyphicon glyphicon-eye-open" > </span> </a>';
							var icon_cart = '<a href="' + contextRoot + '/cart/add/' + data + '" type="button" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart" > </span> </a>';
								return icon_view + '&#x2003;' + icon_cart;
						}
					}
		         ],
		         'drawCallback': function (settings) {
		            var api = this.api();
		            var $table = $(api.table().node());
		            
		            if ($table.hasClass('cards')) {

		               // Create an array of labels containing all table headers
		               var labels = [];
		               $('thead th', $table).each(function () {
		                  labels.push($(this).text());
		               });

		               // Add data-label attribute to each cell
		               $('tbody tr', $table).each(function () {
		                  $(this).find('td').each(function (column) {
		                     $(this).attr('data-label', labels[column]);
		                  });
		               });

		               var max = 0;
		               $('tbody tr', $table).each(function () {
		                  max = Math.max($(this).height(), max);
		               }).height(max);

		            } else {
		               // Remove data-label attribute from each cell
		               $('tbody td', $table).each(function () {
		                  $(this).removeAttr('data-label');
		               });

		               $('tbody tr', $table).each(function () {
		                  $(this).height('auto');
		               });
		            }
		         }
		      })
		      .on('select', function (e, dt, type, indexes) {
		         var rowData = table.rows(indexes).data().toArray()
		         $('#row-data').html(JSON.stringify(rowData));
		      })
		      .on('deselect', function () {
		         $('#row-data').empty();
		      })
		      
		      table.buttons().container()
		      	.appendTo($('#test-button'));
	
	
	//manage products table
	$('#admin-products-table').DataTable({
		pageLength: 10,
		"lengthMenu": [ [-1,2,1], ["All Rec", "2 Rec", "1 Rec"]],
		
		ajax:{
			url: jsonURL,
			dataSrc: ""
		},
		columns:[
			{"data": "id"},
			{"data": "name"},
			{"data": "brand"},
			{"data": "unitPrice",
				"render": function(data, type, row, meta){
					return '<span>&#8377;' + data + '</span>';
				}
			},
			{"data": "quantity"},
			{data: "active",
				render: function(data, type, row, meta){
					var str = '';
					str += '<label class="switch">  <input type="checkbox">  <span class="slider round"></span> </label>';
					return str;
				}},
			{data: "id",
				 bSortable: false,
					render: function(data, type, row, meta){
						var edit_view = '<a href="' + contextRoot + '/manage/products/' + data + '" type="button" class="btn btn-info"><span class="glyphicon glyphicon-edit" > </span> </a>';
					
							return '&#x2003;' + edit_view;
					}
				}
		]
	});
	
	
	var $alert = $('#alert');
		if($alert.length){
			setTimeout(function(){
				$alert.fadeOut("slow");
			}, 2000);
		}
		
	var $error = $('.help-block');
		if($error.length){
			$error.parent().addClass('has-warning');
		}
});