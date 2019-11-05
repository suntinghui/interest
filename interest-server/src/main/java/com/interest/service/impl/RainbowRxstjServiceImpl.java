package com.interest.service.impl;

import com.interest.dao.rainbow.RainbowRbbxhDao;
import com.interest.dao.rainbow.RainbowRxstjDao;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowRbbxhService;
import com.interest.service.RainbowRxstjService;
import com.interest.utils.RainbowUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RainbowRxstjServiceImpl implements RainbowRxstjService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public RainbowRxstjDao rainbowRxstjDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


	@Override
	public PageResult xstj(PageWrapper pageWrapper, String startDate, String endDate) {
		List<HashMap> list =  rainbowRxstjDao.xstj(pageWrapper, startDate, endDate);
		int size = rainbowRxstjDao.xstj_count(startDate, endDate);
		return new PageResult<>(list, size);
	}

}
