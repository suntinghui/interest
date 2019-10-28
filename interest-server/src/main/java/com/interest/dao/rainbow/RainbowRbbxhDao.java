package com.interest.dao.rainbow;

import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowRbbxhDao {
	
	List<HashMap> rbxhjkpjytj(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);
	int rbxhjkpjytj_count(String startDate, String endDate, List deviceModel);

	List<HashMap> rbxhjkpjy50();

	List<HashMap> rbxhsbyxqk();

	List<HashMap> rbxhmrxrwsl();

	List<HashMap> rbxhmrwkjsl();

	List<HashMap> rbxhcjsbs();


}
