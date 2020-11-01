package com.ApplicationJ.dao.ext;

import java.util.List;

import com.ApplicationJ.config.Request;
import com.ApplicationJ.model.FoodBO;
import com.ApplicationJ.model.FoodTypeBO;
import com.ApplicationJ.model.StatusBO;
import com.ApplicationJ.model.UsersBO;

public interface UsersDaoExt {

	UsersBO addUser(UsersBO userbo);

	UsersBO getUserById(int id);

	List<StatusBO> getStatusList();

	List<FoodTypeBO> getFoodTypeList();

	List<FoodBO> getFoodList();

	List<UsersBO> getActiveUserNameEmailList();

	UsersBO updateUser(UsersBO userbo);

	List<UsersBO> getTestGroupBylList();

	List<UsersBO> getActiveUsers(Request request);

}