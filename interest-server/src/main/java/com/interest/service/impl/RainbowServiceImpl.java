package com.interest.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interest.dao.rainbow.RainbowDao;
import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.response.ArticleResponse;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowService;

@Service
public class RainbowServiceImpl implements RainbowService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public RainbowDao rainbowDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
	@Transactional
	public String fhgjl() {
		return rainbowDao.fhgjl();
	}

	@Override
	public String jtkcpd() {
		return rainbowDao.jtkcpd();
	}

	@Override
	public String zhkjsc() {
		return rainbowDao.zhkjsc();
	}

	@Override
	public PageResult getDeviceDocList(String searchContent, PageWrapper pageWrapper) {
		List<RainbowDeviceDocEntity> list = rainbowDao.getDeviceDocList(searchContent, pageWrapper);
        int size = rainbowDao.getDevieDocSize(searchContent);
        return new PageResult<>(list, size);
	}

}
