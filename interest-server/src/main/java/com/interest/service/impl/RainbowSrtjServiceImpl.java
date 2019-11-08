package com.interest.service.impl;

import com.interest.dao.rainbow.RainbowKcqktjDao;
import com.interest.dao.rainbow.RainbowSrtjDao;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowKcqktjService;
import com.interest.service.RainbowSrtjService;
import com.interest.utils.RainbowUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RainbowSrtjServiceImpl implements RainbowSrtjService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public RainbowSrtjDao rainbowSrtjDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
	public List<HashMap> xsetjy(String startMonth, String endMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowSrtjDao.xsetjy(startMonth, endMonth));
		return list;
	}

	@Override
	public PageResult srtjr(PageWrapper pageWrapper, String queryMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowSrtjDao.srtjr(pageWrapper, queryMonth));
		int size = rainbowSrtjDao.srtjr_count(queryMonth);
		return new PageResult<>(list, size);
	}

	@Override
	public List<HashMap> fqdsbsl(String startDate, String endDate) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowSrtjDao.fqdsbsl(startDate, endDate));
		return list;
	}

	@Override
	public PageResult mdfcjer(PageWrapper pageWrapper, String queryMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowSrtjDao.mdfcjer(pageWrapper, queryMonth));
		int size = rainbowSrtjDao.mdfcjer_count(queryMonth);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult qdfcjer(PageWrapper pageWrapper, String queryMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowSrtjDao.qdfcjer(pageWrapper, queryMonth));
		int size = rainbowSrtjDao.qdfcjer_count(queryMonth);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult qdfcbl(PageWrapper pageWrapper, String queryMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowSrtjDao.qdfcbl(pageWrapper, queryMonth));
		int size = rainbowSrtjDao.qdfcbl_count(queryMonth);
		return new PageResult<>(list, size);
	}

	@Override
	public List<HashMap> tkqktjhj(String startMonth, String endMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowSrtjDao.tkqktjhj(startMonth, endMonth));
		return list;
	}

	@Override
	public PageResult tkqktjy(PageWrapper pageWrapper, String startMonth, String endMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowSrtjDao.tkqktjy(pageWrapper, startMonth, endMonth));
		int size = rainbowSrtjDao.tkqktjy_count(startMonth, endMonth);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult tkqktjr(PageWrapper pageWrapper, String queryMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowSrtjDao.tkqktjr(pageWrapper, queryMonth));
		int size = rainbowSrtjDao.tkqktjr_count(queryMonth);
		return new PageResult<>(list, size);
	}

}
