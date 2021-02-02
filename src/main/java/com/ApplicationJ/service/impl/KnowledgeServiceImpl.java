package com.ApplicationJ.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApplicationJ.config.Request;
import com.ApplicationJ.dao.KnowledgeDao;
import com.ApplicationJ.model.KnowledgeBO;
import com.ApplicationJ.service.KnowledgeService;
import com.ApplicationJ.utility.SupportUtility;

@Transactional
@Service
public class KnowledgeServiceImpl implements KnowledgeService {

	@Autowired
	KnowledgeDao knowledgeDao;

	@Autowired
	SupportUtility supportUtility;

	public KnowledgeServiceImpl() {
		super();
	}

	@Override
	public List<KnowledgeBO> getKnowledgeList(Request request) {
		return knowledgeDao.findAll();
	}

	@Override
	public KnowledgeBO getKnowledgeById(int id) {
		Optional<KnowledgeBO> KnowledgeBO = knowledgeDao.findById(new Long(id));
		if (KnowledgeBO.isPresent()) {
			return KnowledgeBO.get();
		} else {
			return null;
		}
	}

	@Override
	public KnowledgeBO addKnowledge(KnowledgeBO KnowledgeBO) {
		return knowledgeDao.save(KnowledgeBO);
	}

	@Override
	public KnowledgeBO updateKnowledge(KnowledgeBO KnowledgeBO) {
		return knowledgeDao.save(KnowledgeBO);
	}

	@Override
	public void removeKnowledgeById(int id) {
		knowledgeDao.deleteById(new Long(id));
	}

}
