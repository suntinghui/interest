package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowKcqktjService {
	
	// 库存概况
	PageResult jkppsgk(PageWrapper pageWrapper, String startDate, String endDate);

	// 库存明细
	PageResult jkppsmx(PageWrapper pageWrapper, String startDate, String endDate);

	// 出库包裹数
	List<HashMap> ckbgs(String startDate, String endDate);

	// 在途包裹数
	List<HashMap> ztbgs(String queryDate);

}
