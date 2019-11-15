package com.interest.dao.rainbow;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

@Mapper
public interface RainbowYjzbDao {
	
	String fhgjl(@Param("filterMap") HashMap filterMap);

	String tcgjxlbl(@Param("filterMap") HashMap filterMap);

	String kcscbl(@Param("filterMap") HashMap filterMap);

	HashMap djrxpj(@Param("filterMap") HashMap filterMap);

	String jtkcpd();
	
	String zhkjsc(String startDate, String endDate);
	
	// 设备档案
	List<RainbowDeviceDocEntity> getDeviceDocList(@Param("searchContent") String searchContent, @Param("pageWrapper") PageWrapper pageWrapper);

	int getDevieDocSize(@Param("searchContent") String searchContent);

}
