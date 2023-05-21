package com.ssafy.osan.domain.user.service;

import com.ssafy.osan.domain.user.dao.UserDao;
import com.ssafy.osan.domain.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserDao userDao;

    // 회원등록
    @Override
    public int regist(User user) {
        return userDao.insertUser(user);
    }

    // 아이디로 회원 가져오기
    @Override
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }
}
