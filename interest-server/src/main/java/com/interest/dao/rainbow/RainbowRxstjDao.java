package com.interest.dao.rainbow;

import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowRxstjDao {
	
	List<HashMap> xstj(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int xstj_count(@Param("filterMap") HashMap filterMap);

	List<HashMap> sblxtj(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int sblxtj_count(@Param("filterMap") HashMap filterMap);

	List<HashMap> acztj(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int acztj_count(@Param("filterMap") HashMap filterMap);

	List<HashMap> dtpjxstj(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int dtpjxstj_count(@Param("filterMap") HashMap filterMap);

	List<HashMap> dtxlpm(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int dtxlpm_count(@Param("filterMap") HashMap filterMap);

	List<HashMap> lxlsbzbtj(@Param("filterMap") HashMap filterMap);


}
