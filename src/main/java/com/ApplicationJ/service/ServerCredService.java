package com.ApplicationJ.service;

import java.util.List;

import com.ApplicationJ.modelBO.ServerCredBO;
import com.ApplicationJ.modelTO.ServerCredTO;

public interface ServerCredService {
	
	List<ServerCredTO> getServerCredList();

	ServerCredTO getServerCredById(int id);

	ServerCredTO addServerCred(ServerCredBO serverCredBO);

	ServerCredTO updateServerCred(ServerCredBO serverCredBO);
}