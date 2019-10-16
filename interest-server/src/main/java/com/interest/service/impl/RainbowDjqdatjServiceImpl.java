package com.interest.service.impl;

import com.interest.dao.rainbow.RainbowDjqdatjDao;
import com.interest.dao.rainbow.RainbowParamDao;
import com.interest.model.entity.ParamEntity;
import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.entity.RainbowJqsxxxEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowDjqdatjService;
import com.interest.service.RainbowParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class RainbowDjqdatjServiceImpl implements RainbowDjqdatjService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public RainbowDjqdatjDao rainbowDjqdatjDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


	@Override
	public PageResult getDeviceInfoList(String searchContent, PageWrapper pageWrapper) {
		List<RainbowJqsxxxEntity> list = rainbowDjqdatjDao.getDeviceInfoList(searchContent, pageWrapper);
		int size = rainbowDjqdatjDao.getDevieInfoSize(searchContent);
		return new PageResult<>(list, size);
	}

	@Override
	public HashMap getShopInfo(String shopNo) {
		HashMap<String, Object> map = rainbowDjqdatjDao.getShopInfo(shopNo);
		return map;
	}
}
