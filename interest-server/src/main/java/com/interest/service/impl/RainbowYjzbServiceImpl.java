package com.interest.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interest.dao.rainbow.RainbowYjzbDao;
import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowYjzbService;

@Service
public class RainbowYjzbServiceImpl implements RainbowYjzbService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public RainbowYjzbDao rainbowYjzbDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
	public String fhgjl(HashMap filterMap) {
		return rainbowYjzbDao.fhgjl(filterMap);
	}

	@Override
	public String tcgjxlbl(HashMap filterMap) {
		return rainbowYjzbDao.tcgjxlbl(filterMap);
	}

	@Override
	public String kcscbl(HashMap filterMap) {
		return rainbowYjzbDao.kcscbl(filterMap);
	}

	@Override
	public HashMap djrxpj(HashMap filterMap) {
		return rainbowYjzbDao.djrxpj(filterMap);
	}

	@Override
	public String jtkcpd() {
		return rainbowYjzbDao.jtkcpd();
	}

	@Override
	public String zhkjsc(String startDate, String endDate) {
		return rainbowYjzbDao.zhkjsc(startDate, endDate);
	}

	@Override
	public PageResult getDeviceDocList(String searchContent, PageWrapper pageWrapper) {
		List<RainbowDeviceDocEntity> list = rainbowYjzbDao.getDeviceDocList(searchContent, pageWrapper);
        int size = rainbowYjzbDao.getDevieDocSize(searchContent);
        return new PageResult<>(list, size);
	}

}
