package com.ApplicationJ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ApplicationJ.model.UsersToken;

@Repository
public interface UsersTokenDao extends JpaRepository<UsersToken, Long> {

}
