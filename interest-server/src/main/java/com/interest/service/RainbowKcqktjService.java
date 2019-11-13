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

	// 即开票月度采购总价值
	List<HashMap> jkpydcgzjz(String startMonth, String endMonth);

	// 即开票月度采购票种明细
	List<HashMap> jkpydcgpzmx(String startMonth, String endMonth);

	// 即开票库存数(截止24时)
	List<HashMap> jkpkcs(String queryMonth);

	// 即开票库存数明细(截止24时)
	List<HashMap> jkpkcsmx(String queryMonth);



}
