package com.ApplicationJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.ApplicationJ.model.FoodBO;
import com.ApplicationJ.model.FoodTypeBO;
import com.ApplicationJ.model.StatusBO;
import com.ApplicationJ.model.UsersBO;
import com.ApplicationJ.service.UsersService;
import com.ApplicationJ.utility.SupportUtility;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UsersRestController {

	@Autowired
	SupportUtility supportUtility;

	@Autowired
	UsersService usersservice;
	

	@PostMapping("/list")
	public ResponseEntity<?> getActiveUsers(@RequestHeader(value = "authKey") String authKey, @RequestBody Request request) throws Exception {
		List<UsersBO> list = usersservice.getActiveUsers(request);
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR001, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@RequestHeader(value = "authKey") String authKey, @PathVariable("id") int id) throws Exception {
		UsersBO user = usersservice.getUsersById(id);
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR002, user, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody UsersBO userbo) throws Exception {
		userbo = usersservice.addUser(userbo);		
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR003, userbo, "users");
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestHeader(value = "authKey") String authKey, @RequestBody Request request) throws Exception {
		UsersBO returnObj = usersservice.updateUser((UsersBO)request.getRequestPayLoad());
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR004, returnObj, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/statusList")
	public ResponseEntity<?> getStatusList(@RequestHeader(value = "authKey") String authKey) throws Exception {
		List<StatusBO> list = usersservice.getStatusList();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR005, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/foodTypeList")
	public ResponseEntity<?> getFoodTypeList(@RequestHeader(value = "authKey") String authKey) throws Exception {
		List<FoodTypeBO> list = usersservice.getFoodTypeList();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR006, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/foodList")
	public ResponseEntity<?> getFoodList(@RequestHeader(value = "authKey") String authKey) throws Exception {
		List<FoodBO> list = usersservice.getFoodList();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR007, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/activeUsersNameEmail")
	public ResponseEntity<?> getActiveUsersNameEmail(@RequestHeader(value = "authKey") String authKey) throws Exception {
		List<UsersBO> list = usersservice.getActiveUsersNameEmail();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR001, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/testGroupBy")
	public ResponseEntity<?> getTest(@RequestHeader(value = "authKey") String authKey) throws Exception {
		List<UsersBO> list = usersservice.getTestGroupByList();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR008, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}