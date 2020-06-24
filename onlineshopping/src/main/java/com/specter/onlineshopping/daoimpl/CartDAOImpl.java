package com.specter.onlineshopping.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specter.onlineshopping.dao.cartDAO;
import com.specter.onlineshopping.entity.Cart_Items;
import com.specter.onlineshopping.entity.Product;

@Repository
public class CartDAOImpl implements cartDAO {

	//for unwrapping session object
		private EntityManager entityManager;
		private Logger logger = LoggerFactory.getLogger(CartDAOImpl.class);

		@Autowired
		public CartDAOImpl(EntityManager entitymanager) {
			entityManager = entitymanager;
		}
	
		//get all cart items
	@Override
	public List<Cart_Items> showAllCartItems() {
		Session currentsession = entityManager.unwrap(Session.class);
		Query<Cart_Items> thequery = currentsession.createQuery("from Cart_Items", Cart_Items.class);
		List<Cart_Items> cartItems = thequery.getResultList();
		
		return cartItems;
	}

	//add product into cartview database
	@Override
	public void addproduct(Product product) {
		Session currentsession = entityManager.unwrap(Session.class);
		currentsession.save(product);
		logger.info("product updated in cartview db");
	}

}
