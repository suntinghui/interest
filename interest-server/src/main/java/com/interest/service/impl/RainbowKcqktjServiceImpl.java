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
	public List<HashMap> jkpydcgzjz(HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkpydcgzjz(filterMap));
		return list;
	}

	@Override
	public List<HashMap> jkpydcgpzmx(HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkpydcgpzmx(filterMap));
		return list;
	}

	@Override
	public List<HashMap> jkpkcs(HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkpkcs(filterMap));
		return list;
	}

	@Override
	public List<HashMap> jkpkcsmx(HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkpkcsmx(filterMap));
		return list;
	}


	@Override
	public List<HashMap> jkppsgk(HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkppsgk(filterMap));
		return list;
	}

	@Override
	public List<HashMap> jkppsmx(HashMap filterMap) {
		List<HashMap> list =  RainbowUtil.decodeList(rainbowKcqktjDao.jkppsmx(filterMap));
		return list;
	}

	@Override
	public List<HashMap> ckbgs(HashMap filterMap) {
		List<HashMap> list = rainbowKcqktjDao.ckbgs(filterMap);
		return list;
	}

	@Override
	public List<HashMap> ztbgs(HashMap filterMap) {
		List<HashMap> list =  rainbowKcqktjDao.ztbgs(filterMap);
		return list;
	}



}
