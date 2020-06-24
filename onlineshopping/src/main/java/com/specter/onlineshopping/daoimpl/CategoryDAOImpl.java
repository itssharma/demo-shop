package com.specter.onlineshopping.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.specter.onlineshopping.dao.categoryDAO;
import com.specter.onlineshopping.entity.Category;

@Repository
public class CategoryDAOImpl implements categoryDAO {

	//for unwrapping session object
	private EntityManager entityManager;

	@Autowired
	public CategoryDAOImpl(EntityManager entitymanager) {
		entityManager = entitymanager;
	}

	//getting categories from database
	@Override
	@Transactional
	public List<Category> listCategories() {
		
		Session currentsession = entityManager.unwrap(Session.class);
		Query<Category> thequery = currentsession.createQuery("from Category", Category.class);
		List<Category> category = thequery.getResultList();
		
		return category;
	}

	//get category based products
	@Override
	@Transactional
	public Category listCategoryProducts(int cat_id) {
		Session currentsession = entityManager.unwrap(Session.class);
		Category category = currentsession.get(Category.class, cat_id);
		return category;
	}

	@Override
	public List<Category> listAllActiveCategories() {
		Session currentsession = entityManager.unwrap(Session.class);
		Query<Category> thequery = currentsession.createQuery("from Category where active = 1", Category.class);
		List<Category> category = thequery.getResultList();
		
		return category;
	}


}
