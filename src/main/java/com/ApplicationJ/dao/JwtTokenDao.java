package com.ApplicationJ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ApplicationJ.model.UserToken;

@Repository
public interface JwtTokenDao extends JpaRepository<UserToken, Long> {

}
