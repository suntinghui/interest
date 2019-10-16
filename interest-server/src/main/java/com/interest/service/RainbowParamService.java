package com.interest.service;

import com.interest.model.entity.ParamEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.List;

public interface RainbowParamService {

	List<ParamEntity> areaList();

	List<ParamEntity> shopTypeList();

	List<ParamEntity> shopList();

	List<ParamEntity> deviceTypeList();

	List<ParamEntity> channelList();

}
