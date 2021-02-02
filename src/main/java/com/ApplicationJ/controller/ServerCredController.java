package com.ApplicationJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApplicationJ.config.ApplicationConstants;
import com.ApplicationJ.config.Request;
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

	@PostMapping("/list")
	public ResponseEntity<?> getServerCredList(@RequestHeader(value = "authKey") String authKey, @RequestBody Request request) throws Exception {
		List<ServerCredBO> list = serverCredService.getServerCredList(request);
		Response response = supportUtility.responseBuilder(ApplicationConstants.SERVERCRED001, list, "servercred");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getServerCredById(@RequestHeader(value = "authKey") String authKey, @PathVariable("id") int id) throws Exception {
		ServerCredBO ServerCredBO = serverCredService.getServerCredById(id);
		Response response = supportUtility.responseBuilder(ApplicationConstants.SERVERCRED002, ServerCredBO,
				"servercred");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addServerCred(@RequestHeader(value = "authKey") String authKey, @RequestBody Request request) throws Exception {
		ServerCredBO ServerCredBO = serverCredService.addServerCred((ServerCredBO) request.getRequestPayLoad());
		Response response = supportUtility.responseBuilder(ApplicationConstants.SERVERCRED003, ServerCredBO,
				"servercred");
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateServerCred(@RequestHeader(value = "authKey") String authKey, @RequestBody Request request) throws Exception {
		ServerCredBO ServerCredBO = serverCredService.updateServerCred((ServerCredBO) request.getRequestPayLoad());
		Response response = supportUtility.responseBuilder(ApplicationConstants.SERVERCRED004, ServerCredBO,
				"servercred");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeServerCredById(@RequestHeader(value = "authKey") String authKey, @PathVariable("id") int id) throws Exception {
		serverCredService.removeServerCredById(id);
		Response response = supportUtility.responseBuilder(ApplicationConstants.SERVERCRED002, null, "servercred");
		return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
	}

}
