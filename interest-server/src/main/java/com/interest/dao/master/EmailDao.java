package com.interest.dao.master;

import java.util.List;

import com.interest.model.entity.EmailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;

@Mapper
public interface EmailDao {

	void insertEntity(EmailEntity emailEntity);

	List<EmailEntity> emailsList(@Param("pageSize") int pageSize, @Param("start") int start);

	Integer emailsSize(@Param("pageSize") int pageSize, @Param("start") int start);

    void deleteEmails(@Param("groupId") List<String> groupId);
}
