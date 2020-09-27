package com.ApplicationJ.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApplicationJ.dao.SeverCredDao;
import com.ApplicationJ.modelBO.ServerCredBO;
import com.ApplicationJ.modelTO.ServerCredTO;
import com.ApplicationJ.service.ServerCredService;

@Transactional
@Service
public class ServerCredServiceImpl implements ServerCredService {
	
	@Autowired
	SeverCredDao serverCredDao;

	@Autowired
	private ModelMapper modelMapper;
	
	public ServerCredServiceImpl() {
		super();
	}

	@Override
	public List<ServerCredTO> getServerCredList() {
		List<ServerCredBO> serverCredBOList= serverCredDao.findAll();
		List<ServerCredTO> serverCredTOList = new ArrayList<ServerCredTO>();
		serverCredBOList.forEach(ServerCredBO -> {
			serverCredTOList.add(modelMapper.map(ServerCredBO, ServerCredTO.class));
		});
		return serverCredTOList;
	}

	@Override
	public ServerCredTO getServerCredById(int id) {
		Optional<ServerCredBO> ServerCredBO = serverCredDao.findById(new Long(id));
        if(ServerCredBO.isPresent()){    
            return modelMapper.map(ServerCredBO, ServerCredTO.class);
        }else  
            return null;  
	}

	@Override
	public ServerCredTO addServerCred(ServerCredBO serverCredBO) {
		return modelMapper.map(serverCredDao.save(serverCredBO), ServerCredTO.class);
	}

	@Override
	public ServerCredTO updateServerCred(ServerCredBO serverCredBO) {
		return modelMapper.map(serverCredDao.save(serverCredBO), ServerCredTO.class);
	}
	
	

}
