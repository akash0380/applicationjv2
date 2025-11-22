package com.ApplicationJ.service.impl;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApplicationJ.config.Request;
import com.ApplicationJ.dao.SeverCredDao;
import com.ApplicationJ.model.ServerCredBO;
import com.ApplicationJ.service.ServerCredService;
import com.ApplicationJ.utility.SupportUtility;

@Transactional
@Service
public class ServerCredServiceImpl implements ServerCredService {

	@Autowired
	SeverCredDao serverCredDao;
	
	@Autowired
	SupportUtility supportUtility;
	
	public ServerCredServiceImpl() {
		super();
	}

	@Override
	public List<ServerCredBO> getServerCredList(Request request) {
		return serverCredDao.findAll();
	}

	@Override
	public ServerCredBO getServerCredById(int id) {
		Optional<ServerCredBO> ServerCredBO = serverCredDao.findById(new Long(id));
		if (ServerCredBO.isPresent()) {
			return ServerCredBO.get();
		} else {
			return null;
		}
	}

	@Override
	public ServerCredBO addServerCred(ServerCredBO serverCredBO) {
		return serverCredDao.save(serverCredBO);
	}

	@Override
	public ServerCredBO updateServerCred(ServerCredBO serverCredBO) {
		return serverCredDao.save(serverCredBO);
	}

	@Override
	public void removeServerCredById(int id) {
		serverCredDao.deleteById(new Long(id));
	}

}
