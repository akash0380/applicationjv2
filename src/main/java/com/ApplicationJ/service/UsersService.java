package com.ApplicationJ.service;

import java.util.List;

import com.ApplicationJ.modelBO.UsersBO;
import com.ApplicationJ.modelTO.FoodTO;
import com.ApplicationJ.modelTO.FoodTypeTO;
import com.ApplicationJ.modelTO.StatusTO;
import com.ApplicationJ.modelTO.UsersTO;

public interface UsersService {

	List<UsersTO> getActiveUsers();

	UsersBO addUser(UsersBO userbo);

	UsersTO getUsersById(int id);

	List<StatusTO> getStatusList();

	List<FoodTypeTO> getFoodTypeList();

	List<FoodTO> getFoodList();

	UsersBO updateUser(UsersBO userbo);

	List<UsersTO> getActiveUsersNameEmail();

	List<UsersTO> getTestGroupByList();


}