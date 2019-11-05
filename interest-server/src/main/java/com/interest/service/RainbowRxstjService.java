package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowRxstjService {
	
	// 销售情况
	PageResult xstj(PageWrapper pageWrapper, String startDate, String endDate);


}
