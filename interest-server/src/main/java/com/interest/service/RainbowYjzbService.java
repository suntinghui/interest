package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;

public interface RainbowYjzbService {
	
	// 复合关机率
	String fhgjl(HashMap filterMap);

	// 剔除关机0销量比率
	String tcgjxlbl(HashMap filterMap);

	// 空仓时长比率
	String kcscbl(HashMap filterMap);

	// 单机日销平均
    HashMap djrxpj(HashMap filterMap);

	// 机头空仓频度
	String jtkcpd();
	
	// 综合开机时长
	String zhkjsc(String startDate, String endDate);
	
	// 设备档案
	PageResult getDeviceDocList(String searchContent, PageWrapper pageWrapper);

}
