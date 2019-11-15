package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowSrtjService {

	// 销售额情况统计（按月）
	List<HashMap> xsetjy(HashMap filterMap);

	// 收入情况统计（按日）
	List<HashMap> srtjr(HashMap filterMap);

	// 分渠道设备数量
	List<HashMap> fqdsbsl(String startDate, String endDate);

	// 门店分成金额（按日）
	PageResult mdfcjer(PageWrapper pageWrapper, String queryMonth);

	// 渠道分成金额（按日）
	PageResult qdfcjer(PageWrapper pageWrapper, String queryMonth);

	// 渠道分成比例
	PageResult qdfcbl(PageWrapper pageWrapper, String queryMonth);

	// 退款情况统计（合计）
	List<HashMap> tkqktjhj(HashMap filterMap);

	// 退款情况统计（按月）
	List<HashMap> tkqktjy(HashMap filterMap);

	// 退款情况统计（按日）
	List<HashMap> tkqktjr(HashMap filterMap);

	}
