package com.interest.dao.rainbow;

import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowSrtjDao {

	List<HashMap> xsetjy(@Param("filterMap") HashMap filterMap);

	List<HashMap> srtjr(@Param("filterMap") HashMap filterMap);

	List<HashMap> fqdsbsl(String startDate, String endDate);

	List<HashMap> mdfcjer(PageWrapper pageWrapper, String queryMonth);
	int mdfcjer_count(String queryMonth);

	List<HashMap> qdfcjer(PageWrapper pageWrapper, String queryMonth);
	int qdfcjer_count(String queryMonth);

	List<HashMap> qdfcbl(PageWrapper pageWrapper , String queryMonth);
	int qdfcbl_count(String queryMonth);

	List<HashMap> tkqktjhj(@Param("filterMap") HashMap filterMap);

	List<HashMap> tkqktjy(@Param("filterMap") HashMap filterMap);

	List<HashMap> tkqktjr(@Param("filterMap") HashMap filterMap);


}
