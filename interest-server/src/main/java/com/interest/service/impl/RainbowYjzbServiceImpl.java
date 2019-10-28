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
	public String fhgjl() {
		return rainbowYjzbDao.fhgjl();
	}

	@Override
	public String tcgjxlbl() {
		return rainbowYjzbDao.tcgjxlbl();
	}

	@Override
	public String kcscbl(String startDate, String endDate) {
		return rainbowYjzbDao.kcscbl(startDate, endDate);
	}

	@Override
	public HashMap djrxpj(String startDate, String endDate) {
		return rainbowYjzbDao.djrxpj(startDate, endDate);
	}

	@Override
	public String jtkcpd() {
		return rainbowYjzbDao.jtkcpd();
	}

	@Override
	public String zhkjsc() {
		return rainbowYjzbDao.zhkjsc();
	}

	@Override
	public PageResult getDeviceDocList(String searchContent, PageWrapper pageWrapper) {
		List<RainbowDeviceDocEntity> list = rainbowYjzbDao.getDeviceDocList(searchContent, pageWrapper);
        int size = rainbowYjzbDao.getDevieDocSize(searchContent);
        return new PageResult<>(list, size);
	}

}
