package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowRbbxhService {
	
	// 即开票交易情况
	List<HashMap> rbxhjkpjytj();

	// Top50
	List<HashMap> rbxhjkpjy50();

	// 每日在网设备数量
	List<HashMap> rbxhsbyxqk();

	// 每日新入网数量
	List<HashMap> rbxhmrxrwsl();

	// 每日未开机数量
	List<HashMap> rbxhmrwkjsl();

	// 撤机设备数
	List<HashMap> rbxhcjsbs();



}
