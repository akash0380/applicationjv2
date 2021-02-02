package com.ApplicationJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApplicationJ.config.ApplicationConstants;
import com.ApplicationJ.config.Request;
import com.ApplicationJ.config.Response;
import com.ApplicationJ.model.KnowledgeBO;
import com.ApplicationJ.service.KnowledgeService;
import com.ApplicationJ.utility.SupportUtility;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {
	
	@Autowired
	SupportUtility supportUtility;

	@Autowired
	KnowledgeService knowledgeService;
	
	@PostMapping("/list")
	public ResponseEntity<?> getKnowledgeList(@RequestHeader(value = "authKey") String authKey, @RequestBody Request request) throws Exception {
		List<KnowledgeBO> list = knowledgeService.getKnowledgeList(request);
		Response response = supportUtility.responseBuilder(ApplicationConstants.KNOWLEDGE001, list, "knowledge");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addKnowledge(@RequestHeader(value = "authKey") String authKey, @RequestBody Request request) throws Exception {
		KnowledgeBO KnowledgeBO = knowledgeService.addKnowledge((KnowledgeBO) request.getRequestPayLoad());
		Response response = supportUtility.responseBuilder(ApplicationConstants.KNOWLEDGE003, KnowledgeBO,
				"knowledge");
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

}
