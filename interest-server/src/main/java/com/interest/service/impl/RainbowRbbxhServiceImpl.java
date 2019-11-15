package com.interest.service.impl;

import com.interest.dao.rainbow.RainbowRbbxhDao;
import com.interest.dao.rainbow.RainbowYjzbDao;
import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowRbbxhService;
import com.interest.service.RainbowYjzbService;
import com.interest.utils.RainbowUtil;
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
	public PageResult rbxhjkpjytj(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  rainbowRbbxhDao.rbxhjkpjytj(pageWrapper, filterMap);
		int size = rainbowRbbxhDao.rbxhjkpjytj_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public List<HashMap> rbxhjkpjy50(HashMap filterMap) {
		return RainbowUtil.decodeList(rainbowRbbxhDao.rbxhjkpjy50(filterMap));
	}

	@Override
	public PageResult mrzwsbsl(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  rainbowRbbxhDao.rbxhsbyxqk(pageWrapper, filterMap);
		int size = rainbowRbbxhDao.rbxhsbyxqk_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult mrxrwsbsl(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  rainbowRbbxhDao.mrxrwsbsl(pageWrapper, filterMap);
		int size = rainbowRbbxhDao.mrxrwsbsl_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult mrwkjsl(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  rainbowRbbxhDao.mrwkjsl(pageWrapper, filterMap);
		int size = rainbowRbbxhDao.mrwkjsl_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult cjsbs(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  rainbowRbbxhDao.cjsbs(pageWrapper, filterMap);
		int size = rainbowRbbxhDao.cjsbs_count(filterMap);
		return new PageResult<>(list, size);
	}
}
