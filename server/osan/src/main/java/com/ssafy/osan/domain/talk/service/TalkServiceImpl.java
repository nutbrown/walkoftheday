package com.ssafy.osan.domain.talk.service;

import com.ssafy.osan.domain.route.dto.Route;
import com.ssafy.osan.domain.talk.dto.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.osan.domain.talk.dao.TalkDao;

import java.util.List;

@Service
public class TalkServiceImpl implements TalkService{

    @Autowired
    public TalkDao talkDao;

    @Override
    public int writeTalk(Talk talk) {
        return talkDao.insertTalk(talk);
    }

    @Override
    public List<Talk> getTalkList() {
        return talkDao.selectAllTalk();
    }

    @Override
    public int deleteTalk(int talkId) {
        return talkDao.deleteTalk(talkId);
    }
}
