package com.interest.dao.rainbow;

import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowRxstjDao {
	
	List<HashMap> xstj(PageWrapper pageWrapper, String startDate, String endDate);
	int xstj_count(String startDate, String endDate);

	List<HashMap> sblxtj(PageWrapper pageWrapper, String startDate, String endDate);
	int sblxtj_count(String startDate, String endDate);

	List<HashMap> acztj(PageWrapper pageWrapper, String startDate, String endDate);
	int acztj_count(String startDate, String endDate);

	List<HashMap> dtpjxstj(PageWrapper pageWrapper, String startDate, String endDate);
	int dtpjxstj_count(String startDate, String endDate);

	List<HashMap> dtxlpm(PageWrapper pageWrapper, String startDate, String endDate);
	int dtxlpm_count(String startDate, String endDate);

	HashMap lxlsbzbtj(String queryDate);


}
