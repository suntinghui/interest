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
	public PageResult xstj(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  rainbowRxstjDao.xstj(pageWrapper, filterMap);
		int size = rainbowRxstjDao.xstj_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult sblxtj(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowRxstjDao.sblxtj(pageWrapper, filterMap));
		int size = rainbowRxstjDao.sblxtj_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult acztj(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowRxstjDao.acztj(pageWrapper, filterMap));
		int size = rainbowRxstjDao.acztj_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult dtpjxstj(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowRxstjDao.dtpjxstj(pageWrapper, filterMap));
		int size = rainbowRxstjDao.dtpjxstj_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult dtxlpm(PageWrapper pageWrapper, HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowRxstjDao.dtxlpm(pageWrapper, filterMap));
		int size = rainbowRxstjDao.dtxlpm_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public List<HashMap> lxlsbzbtj(HashMap filterMap) {
		List<HashMap> list = rainbowRxstjDao.lxlsbzbtj(filterMap);
		 return list;
	}

}
