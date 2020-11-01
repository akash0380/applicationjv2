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
import com.ApplicationJ.config.Request;
import com.ApplicationJ.config.Response;
import com.ApplicationJ.model.FoodBO;
import com.ApplicationJ.model.FoodTypeBO;
import com.ApplicationJ.model.ServerCredBO;
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

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ResponseEntity<?> getActiveUsers(@RequestBody Request request) throws Exception {
		List<UsersBO> list = usersservice.getActiveUsers(request);
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR001, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws Exception {
		UsersBO user = usersservice.getUsersById(id);
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR002, user, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody Request request) throws Exception {
		UsersBO returnObj = usersservice.addUser((UsersBO)request.getRequestPayLoad());
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR003, returnObj, "users");
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody Request request) throws Exception {
		UsersBO returnObj = usersservice.updateUser((UsersBO)request.getRequestPayLoad());
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR004, returnObj, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/statusList", method = RequestMethod.GET)
	public ResponseEntity<?> getStatusList() throws Exception {
		List<StatusBO> list = usersservice.getStatusList();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR005, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/foodTypeList", method = RequestMethod.GET)
	public ResponseEntity<?> getFoodTypeList() throws Exception {
		List<FoodTypeBO> list = usersservice.getFoodTypeList();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR006, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/foodList", method = RequestMethod.GET)
	public ResponseEntity<?> getFoodList() throws Exception {
		List<FoodBO> list = usersservice.getFoodList();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR007, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/activeUsersNameEmail", method = RequestMethod.GET)
	public ResponseEntity<?> getActiveUsersNameEmail() throws Exception {
		List<UsersBO> list = usersservice.getActiveUsersNameEmail();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR001, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/testGroupBy", method = RequestMethod.GET)
	public ResponseEntity<?> getTest() throws Exception {
		List<UsersBO> list = usersservice.getTestGroupByList();
		Response response = supportUtility.responseBuilder(ApplicationConstants.USR008, list, "users");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}