package com.ssafy.osan.domain.talk.dao;

import com.ssafy.osan.domain.talk.dto.Talk;

import java.util.List;

public interface TalkDao {

    int insertTalk(Talk talk);

    List<Talk> selectAllTalk();

    int deleteTalk(int talkId);
}

