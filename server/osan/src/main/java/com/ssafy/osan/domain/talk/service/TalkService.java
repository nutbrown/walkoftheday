package com.ssafy.osan.domain.talk.service;

import com.ssafy.osan.domain.route.dto.Route;
import com.ssafy.osan.domain.talk.dto.Talk;

import java.util.List;

public interface TalkService {

    int writeTalk(Talk talk);

    List<Talk> getTalkList();

    int deleteTalk(int talkId);
}
