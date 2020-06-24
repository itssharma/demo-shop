package com.specter.onlineshopping.daoimpl;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.specter.onlineshopping.dao.productDAO;
import com.specter.onlineshopping.entity.Product;

@Repository
public class ProductDAOImpl implements productDAO {

	@Autowired
	public EntityManager entityManager;
	private Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	//get product from database
	@Override
	@Transactional
	public Product getproduct(int id) {
		Session currentsession = entityManager.unwrap(Session.class);
		Product product = null;
		product = currentsession.get(Product.class, id);
		return product;
	}

	//add product into database
	@Override
	@Transactional
	public void addproduct(Product theproduct) {
		Session currentsession = entityManager.unwrap(Session.class);
		//currentsession.saveOrUpdate(theproduct);
		if(theproduct.getId()==0) {
			currentsession.save(theproduct);
			logger.info("product saved into db");
		}else {
			currentsession.update(theproduct);
			logger.info("product updated");
		}
		
	}

}
