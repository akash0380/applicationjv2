package com.ApplicationJ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ApplicationJ.modelBO.ServerCredBO;

@Repository
@Transactional
public interface SeverCredDao extends JpaRepository<ServerCredBO, Long> {

}