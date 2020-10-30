package com.ApplicationJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ApplicationJ.config.ApplicationConstants;
import com.ApplicationJ.config.Response;
import com.ApplicationJ.model.ServerCredBO;
import com.ApplicationJ.service.ServerCredService;
import com.ApplicationJ.utility.SupportUtility;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/servercred")
public class ServerCredController {

	@Autowired
	SupportUtility supportUtility;

	@Autowired
	ServerCredService serverCredService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> getServerCredList() throws Exception {
		List<ServerCredBO> list = serverCredService.getServerCredList();
		Response response = supportUtility.responseBuilder(200, ApplicationConstants.SERVERCRED001, list, "servercred");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getServerCredById(@PathVariable("id") int id) throws Exception {
		ServerCredBO ServerCredBO = serverCredService.getServerCredById(id);
		Response response = supportUtility.responseBuilder(200, ApplicationConstants.SERVERCRED002, ServerCredBO,
				"servercred");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addServerCred(@RequestBody ServerCredBO serverCredBO) throws Exception {
		ServerCredBO ServerCredBO = serverCredService.addServerCred(serverCredBO);
		Response response = supportUtility.responseBuilder(200, ApplicationConstants.SERVERCRED003, ServerCredBO,
				"servercred");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateServerCred(@RequestBody ServerCredBO serverCredBO) throws Exception {
		ServerCredBO ServerCredBO = serverCredService.updateServerCred(serverCredBO);
		Response response = supportUtility.responseBuilder(200, ApplicationConstants.SERVERCRED004, ServerCredBO,
				"servercred");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
