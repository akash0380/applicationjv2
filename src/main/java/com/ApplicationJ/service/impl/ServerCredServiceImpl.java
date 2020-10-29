package com.ApplicationJ.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApplicationJ.dao.SeverCredDao;
import com.ApplicationJ.model.ServerCredBO;
import com.ApplicationJ.service.ServerCredService;

@Transactional
@Service
public class ServerCredServiceImpl implements ServerCredService {

	@Autowired
	SeverCredDao serverCredDao;

	public ServerCredServiceImpl() {
		super();
	}

	@Override
	public List<ServerCredBO> getServerCredList() {
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

}
