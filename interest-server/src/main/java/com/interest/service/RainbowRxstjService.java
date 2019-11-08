package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowRxstjService {
	
	// 销售情况
	PageResult xstj(PageWrapper pageWrapper, String startDate, String endDate);

	// 按设备类型统计
	PageResult sblxtj(PageWrapper pageWrapper, String startDate, String endDate);

	// 按彩种统计
	PageResult acztj(PageWrapper pageWrapper, String startDate, String endDate);

	// 单台平均销售统计
	PageResult dtpjxstj(PageWrapper pageWrapper, String startDate, String endDate);

	// 单台销量排名
	PageResult dtxlpm(PageWrapper pageWrapper, String startDate, String endDate);

	// 零销量设备占比统计
	HashMap lxlsbzbtj(String queryDate);

}
