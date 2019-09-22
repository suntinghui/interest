package com.interest.service.impl;

import java.util.List;

import com.interest.dao.master.EmailDao;
import com.interest.model.entity.EmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interest.service.EmailService;
import com.interest.utils.DateUtil;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDao emailDao;

	@Override
	@Transactional
	public void insertEntity(EmailEntity emailEntity) {
		emailEntity.setCreatetime(DateUtil.currentTimestamp());
		emailDao.insertEntity(emailEntity);
	}

	@Override
	@Transactional
	public List<EmailEntity> emailsList(int pageSize, int start) {
		return emailDao.emailsList(pageSize,start);
	}

	@Override
	@Transactional
	public Integer emailsSize(int pageSize, int start) {
		return emailDao.emailsSize(pageSize,start);
	}

	@Override
	@Transactional
	public void deleteEmails(List<String> groupId) {
		emailDao.deleteEmails(groupId);
	}


}
