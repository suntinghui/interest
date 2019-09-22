package com.interest.dao.master;

import com.interest.model.entity.UserGithubEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserGithubDao {

	void insertEntity(UserGithubEntity userGithubEntity);
}
