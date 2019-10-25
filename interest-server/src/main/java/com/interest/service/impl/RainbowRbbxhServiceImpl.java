package com.interest.service.impl;

import com.interest.dao.rainbow.RainbowRbbxhDao;
import com.interest.dao.rainbow.RainbowYjzbDao;
import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowRbbxhService;
import com.interest.service.RainbowYjzbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class RainbowRbbxhServiceImpl implements RainbowRbbxhService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public RainbowRbbxhDao rainbowRbbxhDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


	@Override
	@Transactional
	public List<HashMap> rbxhjkpjytj() {
		return rainbowRbbxhDao.rbxhjkpjytj();
	}

	@Override
	public List<HashMap> rbxhjkpjy50() {
		return rainbowRbbxhDao.rbxhjkpjy50();
	}

	@Override
	public List<HashMap> rbxhsbyxqk() {
		return rainbowRbbxhDao.rbxhsbyxqk();
	}

	@Override
	public List<HashMap> rbxhmrxrwsl() {
		return rainbowRbbxhDao.rbxhmrxrwsl();
	}

	@Override
	public List<HashMap> rbxhmrwkjsl() {
		return rainbowRbbxhDao.rbxhmrwkjsl();
	}

	@Override
	public List<HashMap> rbxhcjsbs() {
		return rainbowRbbxhDao.rbxhcjsbs();
	}
}