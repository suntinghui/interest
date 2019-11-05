package com.interest.dao.rainbow;

import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowRxstjDao {
	
	List<HashMap> xstj(PageWrapper pageWrapper, String startDate, String endDate);
	int xstj_count(String startDate, String endDate);

	


}
