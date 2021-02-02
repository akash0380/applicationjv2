package com.ApplicationJ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ApplicationJ.model.KnowledgeBO;

@Repository
@Transactional
public interface KnowledgeDao extends JpaRepository<KnowledgeBO, Long> {

}
