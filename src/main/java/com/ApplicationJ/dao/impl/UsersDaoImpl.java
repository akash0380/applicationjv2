package com.ApplicationJ.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ApplicationJ.dao.ext.UsersDaoExt;
import com.ApplicationJ.model.FoodBO;
import com.ApplicationJ.model.FoodTypeBO;
import com.ApplicationJ.model.StatusBO;
import com.ApplicationJ.model.UsersBO;

@Repository
public class UsersDaoImpl implements UsersDaoExt {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UsersBO> getActiveUsers() {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UsersBO> criteriaQuery = queryBuilder.createQuery(UsersBO.class);
		Root<UsersBO> entityRoot = criteriaQuery.from(UsersBO.class);// it is required
		List<UsersBO> userList = entityManager.createQuery(criteriaQuery).getResultList();
		return userList;
	}
	
	@Override
	public UsersBO addUser(UsersBO userbo) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(userbo);
		entityManager.flush();
		entityManager.clear();
		return userbo; 
	}
	
	@Override
	public UsersBO getUserById(int id) {
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		List<UsersBO> list = (List<UsersBO>) session
		.createQuery("FROM UsersBO as a where a.id=" + id + "").list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public UsersBO updateUser(UsersBO userbo) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(userbo);
		entityManager.flush();
		entityManager.clear();
		return userbo; 
	}

	@Override
	public List<StatusBO> getStatusList() {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StatusBO> criteriaQuery = queryBuilder.createQuery(StatusBO.class);
		Root<StatusBO> entityRoot = criteriaQuery.from(StatusBO.class);
		Predicate condition = queryBuilder.and(queryBuilder.equal(entityRoot.get("status"),true));
		criteriaQuery.where(condition);
		List<StatusBO> statusList = entityManager.createQuery(criteriaQuery).getResultList();
		return statusList;
	}

	@Override
	public List<FoodTypeBO> getFoodTypeList() {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<FoodTypeBO> criteriaQuery = queryBuilder.createQuery(FoodTypeBO.class);
		Root<FoodTypeBO> entityRoot = criteriaQuery.from(FoodTypeBO.class);
		Predicate condition = queryBuilder.and(queryBuilder.equal(entityRoot.get("status"),true));
		criteriaQuery.where(condition);
		List<FoodTypeBO> foodtypeList = entityManager.createQuery(criteriaQuery).getResultList();
		return foodtypeList;
	}

	@Override
	public List<FoodBO> getFoodList() {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<FoodBO> criteriaQuery = queryBuilder.createQuery(FoodBO.class);
		Root<FoodBO> entityRoot = criteriaQuery.from(FoodBO.class);
		Predicate condition = queryBuilder.and(queryBuilder.equal(entityRoot.get("status"),true),queryBuilder.equal(entityRoot.get("type_id"),1));
		criteriaQuery.where(condition);
		List<FoodBO> foodList = entityManager.createQuery(criteriaQuery).getResultList();
		return foodList;
	}
	
	@Override
	public List<UsersBO> getActiveUserNameEmailList() {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UsersBO> criteriaQuery = queryBuilder.createQuery(UsersBO.class);
		Root<UsersBO> entityRoot = criteriaQuery.from(UsersBO.class);
		ArrayList<Predicate> searchFilter = new ArrayList<>();
		Path<String> e1 = entityRoot.get("status");
		searchFilter.add(queryBuilder.and(queryBuilder.equal(e1,1)));
		criteriaQuery.where(searchFilter.toArray(new Predicate[searchFilter.size()]));
		criteriaQuery.multiselect(entityRoot.get("id"), entityRoot.get("name"), entityRoot.get("email"));
		List<UsersBO> results = entityManager.createQuery(criteriaQuery).getResultList();
		return results;
	}

	@Override
	public List<UsersBO> getTestGroupBylList() {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UsersBO> criteriaQuery = queryBuilder.createQuery(UsersBO.class);
		Root<UsersBO> entityRoot = criteriaQuery.from(UsersBO.class);
		criteriaQuery.multiselect(entityRoot.get("name"), queryBuilder.count(entityRoot)).groupBy(entityRoot.get("name"));
		List<UsersBO> results = entityManager.createQuery(criteriaQuery).getResultList();
		return results;  
	}

}
