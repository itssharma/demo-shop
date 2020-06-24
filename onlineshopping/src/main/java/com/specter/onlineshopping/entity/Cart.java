package com.specter.onlineshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	@Column(name = "grand_total")
	private double grandTotal;
	
	@Column(name = "cart_views")
	private int cartViews;

	// linking the cart with a user
	@OneToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 */
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param grandTotal
	 * @param cartViews
	 * @param user
	 */
	public Cart(double grandTotal, int cartViews, User user) {
		
		this.grandTotal = grandTotal;
		this.cartViews = cartViews;
		this.user = user;
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
	 * @return the grandTotal
	 */
	public double getGrandTotal() {
		return grandTotal;
	}

	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	/**
	 * @return the cartViews
	 */
	public int getCartViews() {
		return cartViews;
	}

	/**
	 * @param cartViews the cartViews to set
	 */
	public void setCartViews(int cartViews) {
		this.cartViews = cartViews;
	}
	
	
	
}