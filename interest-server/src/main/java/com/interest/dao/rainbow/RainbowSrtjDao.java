package com.interest.dao.rainbow;

import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowSrtjDao {

	List<HashMap> xsetjy(String startMonth, String endMonth);

	List<HashMap> srtjr(PageWrapper pageWrapper, String queryMonth);
	int srtjr_count(String queryMonth);

	List<HashMap> fqdsbsl(String startDate, String endDate);

	List<HashMap> mdfcjer(PageWrapper pageWrapper, String queryMonth);
	int mdfcjer_count(String queryMonth);

	List<HashMap> qdfcjer(PageWrapper pageWrapper, String queryMonth);
	int qdfcjer_count(String queryMonth);

	List<HashMap> qdfcbl(PageWrapper pageWrapper , String queryMonth);
	int qdfcbl_count(String queryMonth);

	List<HashMap> tkqktjhj(String startMonth, String endMonth);

	List<HashMap> tkqktjy(PageWrapper pageWrapper, String startMonth, String endMonth);
	int tkqktjy_count(String startMonth, String endMonth);

	List<HashMap> tkqktjr(PageWrapper pageWrapper, String queryMonth);
	int tkqktjr_count(String queryMonth);


}
