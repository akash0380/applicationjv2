package com.ApplicationJ.service;

import java.util.List;

import com.ApplicationJ.config.Request;
import com.ApplicationJ.model.KnowledgeBO;

public interface KnowledgeService {

	KnowledgeBO getKnowledgeById(int id);

	KnowledgeBO addKnowledge(KnowledgeBO KnowledgeBO);

	KnowledgeBO updateKnowledge(KnowledgeBO KnowledgeBO);

	List<KnowledgeBO> getKnowledgeList(Request request);

	void removeKnowledgeById(int id);

}