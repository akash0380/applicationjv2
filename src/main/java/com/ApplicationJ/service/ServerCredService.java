package com.ApplicationJ.service;

import java.util.List;

import com.ApplicationJ.config.Request;
import com.ApplicationJ.model.ServerCredBO;

public interface ServerCredService {

	ServerCredBO getServerCredById(int id);

	ServerCredBO addServerCred(ServerCredBO serverCredBO);

	ServerCredBO updateServerCred(ServerCredBO serverCredBO);
	
	List<ServerCredBO> getServerCredList(Request request);

	void removeServerCredById(int id);
}