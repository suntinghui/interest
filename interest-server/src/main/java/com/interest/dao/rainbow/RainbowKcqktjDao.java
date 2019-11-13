package com.interest.dao.rainbow;

import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowKcqktjDao {
	
	List<HashMap> jkppsgk(PageWrapper pageWrapper, String startDate, String endDate);
	int jkppsgk_count(String startDate, String endDate);

	List<HashMap> jkppsmx(PageWrapper pageWrapper, String startDate, String endDate);
	int jkppsmx_count(String startDate, String endDate);

	List<HashMap> ckbgs(String startDate, String endDate);

	List<HashMap> ztbgs(String queryDate);

	List<HashMap> jkpydcgzjz(String startMonth, String endMonth);

	List<HashMap> jkpydcgpzmx(String startMonth, String endMonth);

	List<HashMap> jkpkcs(String queryDate);

	List<HashMap> jkpkcsmx(String queryDate);


}
