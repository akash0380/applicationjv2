package com.ApplicationJ.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ApplicationJ.config.Request;
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
	public List<UsersBO> getActiveUsers(Request request) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UsersBO> criteriaQuery = criteriaBuilder.createQuery(UsersBO.class);
		Root<UsersBO> entityRoot = criteriaQuery.from(UsersBO.class);// it is required
		//wildcard string search starts
		ArrayList<Predicate> searchFilter = new ArrayList<>();
		if(request.getSearchString()!=null && !request.getSearchString().toString().equals("")) {
			ArrayList<Predicate> searchFilterLocal = new ArrayList<>();
			Path<String> p1 = entityRoot.get(request.getSearchFieldName().toString());
			searchFilterLocal.add(criteriaBuilder.like(p1, "%" + request.getSearchString() + "%"));
			searchFilter.add(criteriaBuilder.or(searchFilterLocal.toArray(new Predicate[searchFilterLocal.size()])));
		}
		criteriaQuery.where(searchFilter.toArray(new Predicate[searchFilter.size()]));
		//wildcard string search ends
		//pagination and sorting starts
		if(request.getSortOrder()!=null && !request.getSortOrder()) {
			criteriaQuery.orderBy(criteriaBuilder.desc(entityRoot.get(request.getSortFieldName())));						
		}else {
			criteriaQuery.orderBy(criteriaBuilder.asc(entityRoot.get(request.getSortFieldName())));			
		}
		TypedQuery<UsersBO> query= entityManager.createQuery(criteriaQuery);
		if (request.getPageNo() != 0 && request.getPageSize() > 0) {
			query.setFirstResult((request.getPageNo() - 1) * request.getPageSize());
			query.setMaxResults(request.getPageSize());
		}
		//pagination and sorting ends
		List<UsersBO> userList = query.getResultList();
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
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StatusBO> criteriaQuery = criteriaBuilder.createQuery(StatusBO.class);
		Root<StatusBO> entityRoot = criteriaQuery.from(StatusBO.class);
		Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(entityRoot.get("status"),true));
		criteriaQuery.where(condition);
		List<StatusBO> statusList = entityManager.createQuery(criteriaQuery).getResultList();
		return statusList;
	}

	@Override
	public List<FoodTypeBO> getFoodTypeList() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<FoodTypeBO> criteriaQuery = criteriaBuilder.createQuery(FoodTypeBO.class);
		Root<FoodTypeBO> entityRoot = criteriaQuery.from(FoodTypeBO.class);
		Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(entityRoot.get("status"),true));
		criteriaQuery.where(condition);
		List<FoodTypeBO> foodtypeList = entityManager.createQuery(criteriaQuery).getResultList();
		return foodtypeList;
	}

	@Override
	public List<FoodBO> getFoodList() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<FoodBO> criteriaQuery = criteriaBuilder.createQuery(FoodBO.class);
		Root<FoodBO> entityRoot = criteriaQuery.from(FoodBO.class);
		Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(entityRoot.get("status"),true),criteriaBuilder.equal(entityRoot.get("type_id"),1));
		criteriaQuery.where(condition);
		List<FoodBO> foodList = entityManager.createQuery(criteriaQuery).getResultList();
		return foodList;
	}
	
	@Override
	public List<UsersBO> getActiveUserNameEmailList() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UsersBO> criteriaQuery = criteriaBuilder.createQuery(UsersBO.class);
		Root<UsersBO> entityRoot = criteriaQuery.from(UsersBO.class);
		ArrayList<Predicate> searchFilter = new ArrayList<>();
		Path<String> e1 = entityRoot.get("status");
		searchFilter.add(criteriaBuilder.and(criteriaBuilder.equal(e1,1)));
		criteriaQuery.where(searchFilter.toArray(new Predicate[searchFilter.size()]));
		criteriaQuery.multiselect(entityRoot.get("id"), entityRoot.get("name"), entityRoot.get("email"));
		List<UsersBO> results = entityManager.createQuery(criteriaQuery).getResultList();
		return results;
	}

	@Override
	public List<UsersBO> getTestGroupBylList() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UsersBO> criteriaQuery = criteriaBuilder.createQuery(UsersBO.class);
		Root<UsersBO> entityRoot = criteriaQuery.from(UsersBO.class);
		criteriaQuery.multiselect(entityRoot.get("name"), criteriaBuilder.count(entityRoot)).groupBy(entityRoot.get("name"));
		List<UsersBO> results = entityManager.createQuery(criteriaQuery).getResultList();
		return results;  
	}

}
