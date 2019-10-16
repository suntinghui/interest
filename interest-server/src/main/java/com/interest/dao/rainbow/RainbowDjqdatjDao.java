package com.interest.dao.rainbow;

import com.interest.model.entity.ParamEntity;
import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.entity.RainbowJqsxxxEntity;
import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowDjqdatjDao {

	// 机器属性信息
	List<RainbowJqsxxxEntity> getDeviceInfoList(@Param("searchContent") String searchContent, @Param("pageWrapper") PageWrapper pageWrapper);
	int getDevieInfoSize(@Param("searchContent") String searchContent);

	HashMap<String, Object> getShopInfo(String shopNo);

}
