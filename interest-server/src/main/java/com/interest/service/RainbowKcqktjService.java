package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowKcqktjService {

	// 即开票月度采购总价值
	List<HashMap> jkpydcgzjz(HashMap filterMaph);

	// 即开票月度采购票种明细
	List<HashMap> jkpydcgpzmx(HashMap filterMap);

	// 即开票库存数(截止24时)
	List<HashMap> jkpkcs(HashMap filterMap);

	// 即开票库存数明细(截止24时)
	List<HashMap> jkpkcsmx(HashMap filterMap);
	
	// 库存概况
	List<HashMap> jkppsgk(HashMap filterMap);

	// 库存明细
	List<HashMap> jkppsmx(HashMap filterMap);

	// 票仓实时余量
	List<HashMap> pcssyl(HashMap filterMap);

	// 票仓实时余量详情
	List<HashMap> pcssylxq(HashMap filterMap);

	// 出库包裹数
	List<HashMap> ckbgs(HashMap filterMap);

	// 在途包裹数
	List<HashMap> ztbgs(HashMap filterMap);





}
