package com.interest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.interest.dao.rainbow.RainbowDao;
import com.interest.service.RainbowService;

@Service
public class RainbowServiceImpl implements RainbowService {
	
	@Autowired
	public RainbowDao rainbowDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
	public String getResult() {
		return rainbowDao.getResult();
	}

}
