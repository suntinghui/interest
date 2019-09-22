package com.interest.dao.master;

import com.interest.model.entity.UserDetailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDetailDao {

    void insert(UserDetailEntity userDetailEntity);

    void updateArticleSign(@Param("articleSign") int articleSign);

    UserDetailEntity getEntityByUserid(@Param("userid") int userid);

    void updateUseridArticleSign(@Param("articleSign") int articleSign,@Param("userid") int userid);

    void updateUserInfo(@Param("userId")int userId,@Param("info") String info,@Param("location") String location,@Param("skill") String skill);
}
