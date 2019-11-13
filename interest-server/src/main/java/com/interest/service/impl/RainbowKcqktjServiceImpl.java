package com.interest.service.impl;

import com.interest.dao.rainbow.RainbowKcqktjDao;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowKcqktjService;
import com.interest.utils.RainbowUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RainbowKcqktjServiceImpl implements RainbowKcqktjService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public RainbowKcqktjDao rainbowKcqktjDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


	@Override
	public PageResult jkppsgk(PageWrapper pageWrapper, String startDate, String endDate) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkppsgk(pageWrapper, startDate, endDate));
		int size = rainbowKcqktjDao.jkppsgk_count(startDate, endDate);
		return new PageResult<>(list, size);
	}

	@Override
	public PageResult jkppsmx(PageWrapper pageWrapper, String startDate, String endDate) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkppsmx(pageWrapper, startDate, endDate));
		int size = rainbowKcqktjDao.jkppsmx_count(startDate, endDate);
		return new PageResult<>(list, size);
	}

	@Override
	public List<HashMap> ckbgs(String startDate, String endDate) {
		List<HashMap> list = rainbowKcqktjDao.ckbgs(startDate, endDate);
		return list;
	}

	@Override
	public List<HashMap> ztbgs(String queryDate) {
		List<HashMap> list =  rainbowKcqktjDao.ztbgs(queryDate);
		return list;
	}

	@Override
	public List<HashMap> jkpydcgzjz(String startMonth, String endMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkpydcgzjz(startMonth, endMonth));
		return list;
	}

	@Override
	public List<HashMap> jkpydcgpzmx(String startMonth, String endMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkpydcgpzmx(startMonth, endMonth));
		return list;
	}

	@Override
	public List<HashMap> jkpkcs(String queryMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkpkcs(queryMonth));
		return list;
	}

	@Override
	public List<HashMap> jkpkcsmx(String queryMonth) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkpkcsmx(queryMonth));
		return list;
	}

}
