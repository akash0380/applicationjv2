package com.ApplicationJ.service;

import java.util.List;

import com.ApplicationJ.modelBO.FoodBO;
import com.ApplicationJ.modelBO.FoodTypeBO;
import com.ApplicationJ.modelBO.StatusBO;
import com.ApplicationJ.modelBO.UsersBO;

public interface UsersService {

	List<UsersBO> getActiveUsers();

	UsersBO addUser(UsersBO userbo);

	UsersBO getUsersById(int id);

	List<StatusBO> getStatusList();

	List<FoodTypeBO> getFoodTypeList();

	List<FoodBO> getFoodList();

	UsersBO updateUser(UsersBO userbo);

	List<UsersBO> getActiveUsersNameEmail();

	List<UsersBO> getTestGroupByList();


}