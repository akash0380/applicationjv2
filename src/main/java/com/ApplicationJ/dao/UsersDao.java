package com.ApplicationJ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ApplicationJ.dao.ext.UsersDaoExt;
import com.ApplicationJ.modelBO.UsersBO;

@Repository
@Transactional
public interface UsersDao extends JpaRepository<UsersBO, Long>, UsersDaoExt {
	
//	@Query("SELECT con FROM Contact con  WHERE con.phoneType=(:pType) AND con.lastName= (:lName)")
//	List<Contact> findByLastNameAndPhoneType(@Param("pType") PhoneType pType, @Param("lName") String lName);
	
	UsersBO findByUsername(String username);
	
}