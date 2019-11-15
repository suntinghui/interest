package com.interest.dao.rainbow;

import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowRbbxhDao {
	
	List<HashMap> rbxhjkpjytj(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int rbxhjkpjytj_count(@Param("filterMap") HashMap filterMap);

	List<HashMap> rbxhjkpjy50(@Param("filterMap") HashMap filterMap);

	List<HashMap> rbxhsbyxqk(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int rbxhsbyxqk_count(@Param("filterMap") HashMap filterMap);

	List<HashMap> mrxrwsbsl(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int mrxrwsbsl_count(@Param("filterMap") HashMap filterMap);

	List<HashMap> mrwkjsl(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int mrwkjsl_count(@Param("filterMap") HashMap filterMap);

	List<HashMap> cjsbs(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);
	int cjsbs_count(@Param("filterMap") HashMap filterMap);


}
