package com.ApplicationJ.dao.ext;

import java.util.List;

import com.ApplicationJ.model.FoodBO;
import com.ApplicationJ.model.FoodTypeBO;
import com.ApplicationJ.model.StatusBO;
import com.ApplicationJ.model.UsersBO;

public interface UsersDaoExt {

	List<UsersBO> getActiveUsers();

	UsersBO addUser(UsersBO userbo);

	UsersBO getUserById(int id);

	List<StatusBO> getStatusList();

	List<FoodTypeBO> getFoodTypeList();

	List<FoodBO> getFoodList();

	List<UsersBO> getActiveUserNameEmailList();

	UsersBO updateUser(UsersBO userbo);

	List<UsersBO> getTestGroupBylList();

}