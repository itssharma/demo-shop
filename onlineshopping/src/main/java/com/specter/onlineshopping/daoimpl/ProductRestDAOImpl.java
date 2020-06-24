package com.specter.onlineshopping.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.specter.onlineshopping.dao.productRestDAO;
import com.specter.onlineshopping.entity.Product;

@Repository
public class ProductRestDAOImpl implements productRestDAO {

	// for unwrapping session object
	private EntityManager entityManager;

	// constructor based dependency injection
	@Autowired
	public ProductRestDAOImpl(EntityManager theentitymanager) {
		this.entityManager = theentitymanager;
	}

	// return products from database
	@Override
	@Transactional
	public List<Product> listproducts() {

		Session currentsession = entityManager.unwrap(Session.class);

		List<Product> allproducts = null;
		Query<Product> thequery = currentsession.createQuery("from Product", Product.class);
		allproducts = thequery.getResultList();

		return allproducts;
	}

	//get products by selected category from database
	@Override
	@Transactional
	public List<Product> listproductsbycategory(int categoryId) {
		Session currentsession = entityManager.unwrap(Session.class);

		List<Product> products = null;
		Query<Product> thequery = currentsession.createQuery("from Product where categoryId = :cat_id", Product.class);
		thequery.setParameter("cat_id", categoryId);
		products = thequery.getResultList();
		return products;
	}

	@Override
	@Transactional
	public List<Product> listAllActiveproducts() {
		Session currentsession = entityManager.unwrap(Session.class);

		List<Product> allproducts = null;
		Query<Product> thequery = currentsession.createQuery("from Product where active = 1", Product.class);
		allproducts = thequery.getResultList();

		return allproducts;
	}

	@Override
	public List<Product> listAllActiveproductsbycategory(int categoryId) {
		Session currentsession = entityManager.unwrap(Session.class);

		List<Product> products = null;
		Query<Product> thequery = currentsession.createQuery("from Product where categoryId = :cat_id and active = 1", Product.class);
		thequery.setParameter("cat_id", categoryId);
		products = thequery.getResultList();
		return products;
	}

}
