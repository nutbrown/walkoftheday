package com.ssafy.osan.domain.talk.dao;

import com.ssafy.osan.domain.talk.dto.Talk;

import java.util.List;

public interface talkDao {
    List<Talk> selectAllTalk();
}
