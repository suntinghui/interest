package com.interest.service;

import com.interest.model.entity.ParamEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowDjqdatjService {

	// 机器属性信息
	PageResult getDeviceInfoList(String searchContent, PageWrapper pageWrapper);

	// 单机器属性
	HashMap<String, String> getDeviceInfo(String shopNo);

	// 门店属性
	HashMap<String, String> getShopInfo(String shopNo);

}
