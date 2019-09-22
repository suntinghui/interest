package com.interest.service.impl;

import com.interest.dao.master.RelationDao;
import com.interest.dao.master.UserDao;
import com.interest.dao.master.UserDetailDao;
import com.interest.model.entity.RelationEntity;
import com.interest.model.entity.UserDetailEntity;
import com.interest.model.entity.UserEntity;
import com.interest.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailDao userDetailDao;

    @Override
    @Transactional
    public void updatedDaily() {
        userDetailDao.updateArticleSign(0);
    }

    @Override
    @Transactional
    public UserDetailEntity getEntityByUserid(int userid) {
        return userDetailDao.getEntityByUserid(userid);
    }

    @Override
    @Transactional
    public void updateArticleSign(int articleSign, int userid) {
        userDetailDao.updateUseridArticleSign(articleSign,userid);
    }

    @Override
    @Transactional
    public void updateUserInfo(int userId, String info, String location, String skill) {
        userDetailDao.updateUserInfo(userId,info,location,skill);
    }
}
