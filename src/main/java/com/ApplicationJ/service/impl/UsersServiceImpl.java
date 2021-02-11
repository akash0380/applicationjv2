package com.ApplicationJ.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ApplicationJ.config.Request;
import com.ApplicationJ.config.security.JwtTokenUtil;
import com.ApplicationJ.dao.JwtTokenDao;
import com.ApplicationJ.dao.UsersDao;
import com.ApplicationJ.model.FoodBO;
import com.ApplicationJ.model.FoodTypeBO;
import com.ApplicationJ.model.UserToken;
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

	// for jwt
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtTokenDao jwtTokenDao;

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
	public List<UsersBO> getActiveUsers(Request request) {
		List<UsersBO> UsersBOListReturn = new ArrayList<UsersBO>();
		userDao.getActiveUsers(request).stream().filter(usersBO -> usersBO.getStatus().getStatus_id() == 1)
				.forEach(usersBO -> {
					UsersBOListReturn.add(usersBO);
				});
		return UsersBOListReturn;
	}

	@Override
	public UsersBO addUser(UsersBO userbo) throws Exception {
		userbo.setPassword(bcryptEncoder.encode(userbo.getPassword()));
		try {
			UsersBO user = userDao.addUser(userbo);
			final String token = jwtTokenUtil.generateToken(user);
			UserToken jwtToken = new UserToken();
			jwtToken.setToken(token);
			jwtToken.setUserbo(userbo);
			jwtTokenDao.save(jwtToken);
		} catch (DisabledException e) {
			throw new Exception("User Disabled", e);
		} catch (BadCredentialsException e) {
			throw new Exception("Wrong Credentials", e);
		}
		return userbo;
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