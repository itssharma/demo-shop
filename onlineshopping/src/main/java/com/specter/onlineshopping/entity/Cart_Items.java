package com.specter.onlineshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class Cart_Items {
	
	//generating fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@Column(name = "cart_id")
	private int cartId;	
	
	@Column(name = "product_count")
	private int productCount;
	
	@Column(name = "total")
	private double total;
	
//	@Column(name = "product_price")
//	private double productPrice;
	
	@Column(name = "is_available")
	private int available = 1;
	
	@OneToOne
	private Product product;

	
	
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart_Items() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param cartId
	 * @param productCount
	 * @param total
	 * @param productPrice
	 * @param available
	 * @param product
	 */
	public Cart_Items(int id, int cartId, int productCount, double total, double productPrice, int available,
			Product product) {
		this.id = id;
		this.cartId = cartId;
		this.productCount = productCount;
		this.total = total;
//		this.productPrice = productPrice;
		this.available = available;
		this.product = product;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the productCount
	 */
	public int getProductCount() {
		return productCount;
	}

	/**
	 * @param productCount the productCount to set
	 */
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the productPrice
	 */
//	public double getProductPrice() {
//		return productPrice;
//	}

	/**
	 * @param productPrice the productPrice to set
	 */
//	public void setProductPrice(double productPrice) {
//		this.productPrice = productPrice;
//	}

	/**
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}
	
	
	
}
