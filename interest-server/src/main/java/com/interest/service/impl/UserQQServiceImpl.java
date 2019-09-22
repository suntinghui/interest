package com.interest.service.impl;

import com.interest.dao.master.UserQQDao;
import com.interest.model.entity.UserQQEntity;
import com.interest.service.UserQQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserQQServiceImpl implements UserQQService {

	@Autowired
	private UserQQDao userQQDao;

	@Override
	@Transactional
	public void insertEntity(UserQQEntity userQQEntity) {
		userQQDao.insertEntity(userQQEntity);
	}
}
