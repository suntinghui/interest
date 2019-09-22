package com.interest.service.impl;

import com.interest.dao.master.InterestDao;
import com.interest.model.entity.InterestEntity;
import com.interest.model.response.BannerResponse;
import com.interest.model.response.InterestResponse;
import com.interest.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private InterestDao interestDao;

	@Override
	@Transactional
	public List<InterestResponse> getInsterest(String title) {
		return interestDao.getInsterest(title);
	}

	@Override
	@Transactional
	public InterestEntity getInsterestById(int id) {
		return interestDao.getInsterestById(id);
	}

	@Override
	@Transactional
	public void insertEntity(InterestEntity interestEntity) {
		interestDao.insertEntity(interestEntity);
	}

	@Override
	@Transactional
	public void updateEntity(InterestEntity interestEntity) {
		interestDao.updateEntity(interestEntity);
	}

	@Override
	@Transactional
	public List<InterestEntity> interestList(int pageSize, int start) {
		return interestDao.interestList(pageSize,start);
	}

	@Override
	@Transactional
	public Integer interestSize() {
		return interestDao.interestSize();
	}

	@Override
	@Transactional
	public void deleteInterests(List<String> groupId) {
		interestDao.deleteInterests(groupId);
	}

	@Override
	@Transactional
	public List<BannerResponse> getBanners() {
		return interestDao.getBanners();
	}

	@Override
	@Transactional
	public void updateBanners(List<String> groupId, int i) {
		interestDao.updateBanners(groupId,i);
	}


}
