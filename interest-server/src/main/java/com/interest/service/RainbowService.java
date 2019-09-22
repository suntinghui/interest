package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

public interface RainbowService {
	
	// 复合关机率
	String fhgjl();
	
	// 机头空仓频度
	String jtkcpd();
	
	// 综合开机时长
	String zhkjsc();
	
	// 设备档案
	PageResult getDeviceDocList(String searchContent, PageWrapper pageWrapper);

}
