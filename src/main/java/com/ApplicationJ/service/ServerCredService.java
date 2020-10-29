package com.ApplicationJ.service;

import java.util.List;

import com.ApplicationJ.model.ServerCredBO;

public interface ServerCredService {
	
	List<ServerCredBO> getServerCredList();

	ServerCredBO getServerCredById(int id);

	ServerCredBO addServerCred(ServerCredBO serverCredBO);

	ServerCredBO updateServerCred(ServerCredBO serverCredBO);
}