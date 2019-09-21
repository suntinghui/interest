package com.interest.dao.rainbow;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("rainbowSqlSessionTemplate")
@Mapper
public interface RainbowDao {
	
	public String getResult();

}
