package com.ssafy.osan.domain.user.dao;

import com.ssafy.osan.domain.user.dto.User;

public interface UserDao {
    int insertUser(User user);

    User getUser(String userId);
}
