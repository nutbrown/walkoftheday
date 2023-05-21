package com.ssafy.osan.domain.user.service;

import com.ssafy.osan.domain.user.dto.User;

public interface UserService {

    int regist(User user);

    User getUser(String userId);
}
