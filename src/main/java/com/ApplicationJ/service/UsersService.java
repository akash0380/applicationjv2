package com.ApplicationJ.service;

import java.util.List;

import com.ApplicationJ.config.Request;
import com.ApplicationJ.model.FoodBO;
import com.ApplicationJ.model.FoodTypeBO;
import com.ApplicationJ.model.StatusBO;
import com.ApplicationJ.model.UsersBO;

public interface UsersService {

	List<UsersBO> getActiveUsers(Request request);

	UsersBO addUser(UsersBO userbo) throws Exception;

	UsersBO getUsersById(int id);

	List<StatusBO> getStatusList();

	List<FoodTypeBO> getFoodTypeList();

	List<FoodBO> getFoodList();

	UsersBO updateUser(UsersBO userbo);

	List<UsersBO> getActiveUsersNameEmail();

	List<UsersBO> getTestGroupByList();


}