package com.interest.service.impl;

import java.util.List;

import com.interest.dao.master.PostCardDao;
import com.interest.dao.master.ReplyCardDao;
import com.interest.model.entity.PostCardEntity;
import com.interest.model.response.PostCardResponse;
import com.interest.service.PostCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interest.utils.DateUtil;
import com.interest.utils.SecurityAuthenUtil;

@Service
public class PostCardServiceImpl implements PostCardService {

	@Autowired
	private PostCardDao postCardDao;
	
	@Autowired
	private ReplyCardDao replyCardDao;

	@Override
	@Transactional
	public List<PostCardResponse> postcardList(String interestid, int pageSize, int start) {
		return postCardDao.postcardList(interestid,pageSize,start);
	}

	@Override
	@Transactional
	public Integer postcardSize(String interestid, int pageSize, int start) {
		return postCardDao.postcardSize(interestid,pageSize,start);
	}

	@Override
	@Transactional
	public void insertEntity(PostCardEntity postCardEntity) {
		int userid = SecurityAuthenUtil.getId();

//		postCardEntity.setUsername(SecurityAuthenUtil.getLoginName());
		postCardEntity.setUserid(userid);
		postCardEntity.setCreatetime(DateUtil.currentTimestamp());
		postCardEntity.setReplytime(postCardEntity.getCreatetime());
		postCardDao.insertEntity(postCardEntity);
	}

	@Override
	@Transactional
	public PostCardResponse getPostcard(int id) {
		return postCardDao.getPostcard(id);
	}

	@Override
	@Transactional
	public void deletePostcards(List<String> groupId) {
		postCardDao.deletePostcards(groupId);
		replyCardDao.delReplyByPostcardid(groupId);
	}


}
