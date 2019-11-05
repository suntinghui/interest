package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowRbbxhService {
	
	// 即开票交易情况
	PageResult rbxhjkpjytj(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);

	// Top50
	List<HashMap<String, String>> rbxhjkpjy50(String startDate, String endDate, List deviceModel);

	// 每日在网设备数量
	PageResult mrzwsbsl(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);

	// 每日新入网数量
	PageResult mrxrwsbsl(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);

	// 每日未开机数量
	PageResult mrwkjsl(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);

	// 撤机设备数
	PageResult cjsbs(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);

}
