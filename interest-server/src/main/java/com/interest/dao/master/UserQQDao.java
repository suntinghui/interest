package com.interest.dao.master;

import com.interest.model.entity.UserQQEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserQQDao {

	void insertEntity(UserQQEntity userQQEntity);
}
