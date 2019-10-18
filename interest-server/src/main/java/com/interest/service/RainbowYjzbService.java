package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

public interface RainbowYjzbService {
	
	// 复合关机率
	String fhgjl();

	// 剔除关机0销量比率
	String tcgjxlbl();

	// 空仓时长比率
	String kcscbl(String startDate, String endDate);
	
	// 机头空仓频度
	String jtkcpd();
	
	// 综合开机时长
	String zhkjsc();
	
	// 设备档案
	PageResult getDeviceDocList(String searchContent, PageWrapper pageWrapper);

}
