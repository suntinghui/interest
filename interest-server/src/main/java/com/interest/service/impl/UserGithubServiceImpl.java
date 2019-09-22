package com.interest.service.impl;

import com.interest.dao.master.UserGithubDao;
import com.interest.model.entity.UserGithubEntity;
import com.interest.service.UserGithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserGithubServiceImpl implements UserGithubService {

	@Autowired
	private UserGithubDao userGithubDao;

	@Override
	@Transactional
	public void insertEntity(UserGithubEntity userGithubEntity) {
		userGithubDao.insertEntity(userGithubEntity);
	}
}
