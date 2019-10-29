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

	List<HashMap> rbxhsbyxqk(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);
	int rbxhsbyxqk_count(String startDate, String endDate, List deviceModel);

	List<HashMap> mrxrwsbsl(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);
	int mrxrwsbsl_count(String startDate, String endDate, List deviceModel);

	List<HashMap> mrwkjsl(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);
	int mrwkjsl_count(String startDate, String endDate, List deviceModel);

	List<HashMap> cjsbs(PageWrapper pageWrapper, String startDate, String endDate, List deviceModel);
	int cjsbs_count(String startDate, String endDate, List deviceModel);


}
