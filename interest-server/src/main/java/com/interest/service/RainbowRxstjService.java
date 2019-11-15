package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowRxstjService {
	
	// 销售情况
	PageResult xstj(PageWrapper pageWrapper, HashMap filterMap);

	// 按设备类型统计
	PageResult sblxtj(PageWrapper pageWrapper, HashMap filterMap);

	// 按彩种统计
	PageResult acztj(PageWrapper pageWrapper, HashMap filterMap);

	// 单台平均销售统计
	PageResult dtpjxstj(PageWrapper pageWrapper, HashMap filterMap);

	// 单台销量排名
	PageResult dtxlpm(PageWrapper pageWrapper, HashMap filterMap);

	// 零销量设备占比统计
	List<HashMap> lxlsbzbtj(HashMap filterMap);

}
