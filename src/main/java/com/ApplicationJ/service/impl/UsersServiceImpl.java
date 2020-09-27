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
import com.ApplicationJ.modelBO.FoodBO;
import com.ApplicationJ.modelBO.FoodTypeBO;
import com.ApplicationJ.modelBO.StatusBO;
import com.ApplicationJ.modelBO.UsersBO;
import com.ApplicationJ.modelTO.FoodTO;
import com.ApplicationJ.modelTO.FoodTypeTO;
import com.ApplicationJ.modelTO.StatusTO;
import com.ApplicationJ.modelTO.UsersTO;
import com.ApplicationJ.service.UsersService;

@Transactional
@Service
public class UsersServiceImpl implements UserDetailsService, UsersService {

	@Autowired
	private UsersDao userDao;

	@Autowired
	private ModelMapper modelMapper;

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
	public List<UsersTO> getActiveUsers() {
		List<UsersTO> usersToList = new ArrayList<UsersTO>();
		List<UsersBO> usersBoList = userDao.getActiveUsers();
		usersBoList.stream().filter(usersBO -> usersBO.getStatus().getStatus_id() == 1).forEach(usersBO -> {
			usersToList.add(modelMapper.map(usersBO, UsersTO.class));
		});
		/*
		 * List<UsersBO> it = userDao.findAll(); it.forEach(e -> {
		 * logger.debug(e.getId()+" fname "+e.getName()); });
		 * logger.debug("testing round 2"); UsersBO user= userDao.getUserById(2);
		 * logger.debug("data got from database "+user.getName());
		 */
		return usersToList;
	}

	@Override
	public UsersBO addUser(UsersBO userbo) {
		userbo.setPassword(bcryptEncoder.encode(userbo.getPassword()));
		return userDao.addUser(userbo);
	}

	@Override
	public UsersTO getUsersById(int id) {
		UsersBO obj = userDao.getUserById(id);
		return modelMapper.map(obj, UsersTO.class);
	}

	@Override
	public UsersBO updateUser(UsersBO userbo) {
		return userDao.updateUser(userbo);
	}

	@Override
	public List<StatusTO> getStatusList() {
		List<StatusTO> statusToList = new ArrayList<StatusTO>();
		List<StatusBO> statusBOList = userDao.getStatusList();
		statusBOList.forEach(statusBO -> {
			statusToList.add(modelMapper.map(statusBO, StatusTO.class));
		});
		return statusToList;
	}

	@Override
	public List<FoodTypeTO> getFoodTypeList() {
		List<FoodTypeTO> foodTypeList = new ArrayList<FoodTypeTO>();
		List<FoodTypeBO> foodTypeBOList = userDao.getFoodTypeList();
		foodTypeBOList.forEach(foodtypebo -> {
			foodTypeList.add(modelMapper.map(foodtypebo, FoodTypeTO.class));
		});
		return foodTypeList;
	}

	@Override
	public List<FoodTO> getFoodList() {
		List<FoodTO> foodList = new ArrayList<FoodTO>();
		List<FoodBO> foodBOList = userDao.getFoodList();
		foodBOList.forEach(foodbo -> {
			foodList.add(modelMapper.map(foodbo, FoodTO.class));
		});
		return foodList;
	}

	@Override
	public List<UsersTO> getTestGroupByList() {
		List<UsersTO> usersToList = new ArrayList<UsersTO>();
		List<UsersBO> usersBoList = userDao.getTestGroupBylList();
		usersBoList.forEach(usersBO -> {
			usersToList.add(modelMapper.map(usersBO, UsersTO.class));
		});
		return usersToList;
	}

	@Override
	public List<UsersTO> getActiveUsersNameEmail() {
		List<UsersTO> usersToList = new ArrayList<UsersTO>();
		List<UsersBO> usersBoList = userDao.getActiveUserNameEmailList();
		usersBoList.forEach(usersBO -> {
			usersToList.add(modelMapper.map(usersBO, UsersTO.class));
		});
		return usersToList;
	}
}