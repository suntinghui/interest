package com.interest.service.impl;

import com.interest.dao.rainbow.RainbowParamDao;
import com.interest.model.entity.ParamEntity;
import com.interest.service.RainbowParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RainbowParamServiceImpl implements RainbowParamService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public RainbowParamDao rainbowParamDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
	public List<ParamEntity> areaList() {
		return rainbowParamDao.areaList();
	}

	@Override
	public List<ParamEntity> shopTypeList() {
		return rainbowParamDao.shopTypeList();
	}

	@Override
	public List<ParamEntity> shopList() {
		return rainbowParamDao.shopList();
	}

	@Override
	public List<ParamEntity> deviceTypeList() {
		return rainbowParamDao.deviceTypeList();
	}

	@Override
	public List<ParamEntity> channelList() {
		return rainbowParamDao.channelList();
	}



}
