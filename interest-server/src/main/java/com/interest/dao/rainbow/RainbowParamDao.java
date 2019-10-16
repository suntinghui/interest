package com.interest.dao.rainbow;

import com.interest.model.entity.ParamEntity;
import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RainbowParamDao {

	List<ParamEntity> areaList();

	List<ParamEntity> shopTypeList();

	List<ParamEntity> shopList();

	List<ParamEntity> deviceTypeList();

	List<ParamEntity> channelList();

}
