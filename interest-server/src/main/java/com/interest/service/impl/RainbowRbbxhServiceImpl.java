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
	public PageResult rbxhjkpjytj(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel) {
		List<HashMap> list =  rainbowRbbxhDao.rbxhjkpjytj(pageWrapper, startDate, endDate, deviceModel);
		int size = rainbowRbbxhDao.rbxhjkpjytj_count(startDate, endDate, deviceModel);
		return new PageResult<>(list, size);
	}

	@Override
	public List<HashMap<String, String>> rbxhjkpjy50() {
		return RainbowUtil.decodeList(rainbowRbbxhDao.rbxhjkpjy50());
	}

	@Override
	public PageResult mrzwsbsl(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel) {
		List<HashMap> list =  rainbowRbbxhDao.rbxhsbyxqk(pageWrapper, startDate, endDate, deviceModel);
		int size = rainbowRbbxhDao.rbxhsbyxqk_count(startDate, endDate, deviceModel);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult mrxrwsbsl(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel) {
		List<HashMap> list =  rainbowRbbxhDao.mrxrwsbsl(pageWrapper, startDate, endDate, deviceModel);
		int size = rainbowRbbxhDao.mrxrwsbsl_count(startDate, endDate, deviceModel);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult mrwkjsl(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel) {
		List<HashMap> list =  rainbowRbbxhDao.mrwkjsl(pageWrapper, startDate, endDate, deviceModel);
		int size = rainbowRbbxhDao.mrwkjsl_count(startDate, endDate, deviceModel);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult cjsbs(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel) {
		List<HashMap> list =  rainbowRbbxhDao.cjsbs(pageWrapper, startDate, endDate, deviceModel);
		int size = rainbowRbbxhDao.cjsbs_count(startDate, endDate, deviceModel);
		return new PageResult<>(list, size);
	}
}
