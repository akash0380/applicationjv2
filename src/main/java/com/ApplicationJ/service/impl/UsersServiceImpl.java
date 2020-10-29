package com.ApplicationJ.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ApplicationJ.dao.UsersDao;
import com.ApplicationJ.model.FoodBO;
import com.ApplicationJ.model.FoodTypeBO;
import com.ApplicationJ.model.StatusBO;
import com.ApplicationJ.model.UsersBO;
import com.ApplicationJ.service.UsersService;

@Transactional
@Service
public class UsersServiceImpl implements UserDetailsService, UsersService {

	@Autowired
	private UsersDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public UsersServiceImpl() {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersBO user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	@Override
	public List<UsersBO> getActiveUsers() {
		List<UsersBO> UsersBOListReturn = new ArrayList<UsersBO>();
		List<UsersBO> usersBoList = userDao.getActiveUsers();
		usersBoList.stream().filter(usersBO -> usersBO.getStatus().getStatus_id() == 1).forEach(usersBO -> {
			UsersBOListReturn.add(usersBO);
		});
		/*
		 * List<UsersBO> it = userDao.findAll(); it.forEach(e -> {
		 * logger.debug(e.getId()+" fname "+e.getName()); });
		 * logger.debug("testing round 2"); UsersBO user= userDao.getUserById(2);
		 * logger.debug("data got from database "+user.getName());
		 */
		return UsersBOListReturn;
	}

	@Override
	public UsersBO addUser(UsersBO userbo) {
		userbo.setPassword(bcryptEncoder.encode(userbo.getPassword()));
		return userDao.addUser(userbo);
	}

	@Override
	public UsersBO getUsersById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public UsersBO updateUser(UsersBO userbo) {
		return userDao.updateUser(userbo);
	}

	@Override
	public List<StatusBO> getStatusList() {
		return userDao.getStatusList();
	}

	@Override
	public List<FoodTypeBO> getFoodTypeList() {
		return userDao.getFoodTypeList();
	}

	@Override
	public List<FoodBO> getFoodList() {
		return userDao.getFoodList();
	}

	@Override
	public List<UsersBO> getTestGroupByList() {
		return userDao.getTestGroupBylList();
	}

	@Override
	public List<UsersBO> getActiveUsersNameEmail() {
		return userDao.getActiveUserNameEmailList();
	}
}