package com.interest.service.impl;

import com.interest.dao.rainbow.RainbowDjqdatjDao;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowDjqdatjService;
import com.interest.utils.RainbowUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

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
		List<HashMap> list = RainbowUtil.decodeList(rainbowDjqdatjDao.getDeviceInfoList(searchContent, pageWrapper));
		int size = rainbowDjqdatjDao.getDevieInfoSize(searchContent);
		return new PageResult<>(list, size);
	}

	@Override
	public HashMap<String, String> getDeviceInfo(String shopNo) {
		HashMap<String, String> map = RainbowUtil.decodeMap(rainbowDjqdatjDao.getDeviceInfo(shopNo));
		return map;
	}

	@Override
	public HashMap getShopInfo(String shopNo) {
		HashMap<String, String> map = RainbowUtil.decodeMap(rainbowDjqdatjDao.getShopInfo(shopNo));
		return map;
	}
}
