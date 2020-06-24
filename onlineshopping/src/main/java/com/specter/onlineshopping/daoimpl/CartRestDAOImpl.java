package com.specter.onlineshopping.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.specter.onlineshopping.dao.cartRestDAO;
import com.specter.onlineshopping.entity.Cart_Items;


@Repository
public class CartRestDAOImpl implements cartRestDAO {

	// for unwrapping session object
		private EntityManager entityManager;

		// constructor based dependency injection
		@Autowired
		public CartRestDAOImpl(EntityManager theentitymanager) {
			this.entityManager = theentitymanager;
		}
	
	@Override
	@Transactional
	public List<Cart_Items> listAllCartItems() {
		Session currentsession = entityManager.unwrap(Session.class);

		List<Cart_Items> cartItems = null;
		Query<Cart_Items> thequery = currentsession.createQuery("from Cart_Items", Cart_Items.class);
		cartItems = thequery.getResultList();

		return cartItems;
	}

}
