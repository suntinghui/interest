package com.interest.dao.master;

import java.util.List;

import com.interest.model.entity.InterestEntity;
import com.interest.model.response.BannerResponse;
import com.interest.model.response.InterestResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Repository;

@Mapper
public interface InterestDao {

	List<InterestResponse> getInsterest(@Param("title") String title);

	InterestEntity getInsterestById(@Param("id") int id);

    void insertEntity(InterestEntity interestEntity);

	void updateEntity(InterestEntity interestEntity);

	List<InterestEntity> interestList(@Param("pageSize") int pageSize,@Param("start") int start);

	Integer interestSize();

	void deleteInterests(@Param("groupId") List<String> groupId);

    List<BannerResponse> getBanners();

	void updateBanners(@Param("groupId") List<String> groupId,@Param("banner") int i);
}
