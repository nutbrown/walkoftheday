package com.ssafy.osan.domain.talk.controller;

import com.ssafy.osan.domain.route.dto.Route;
import com.ssafy.osan.domain.talk.dto.Talk;
import com.ssafy.osan.domain.talk.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talk")
public class TalkController {

    @Autowired
    private TalkService talkService;

    // 산책 한마디 작성
    @PostMapping("")
    public ResponseEntity<?> writeTalk(Talk talk) {

        int result = talkService.writeTalk(talk);

        if(result > 0) {
            return new ResponseEntity<Talk>(talk, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 산책 한마디 전체 조회
    @GetMapping("")
    public ResponseEntity<?> selectAllTalk() {

        // 빈 값을 가져올 수도 있으니 제네릭 <?>
        List<Talk> list = talkService.getTalkList();

        // 리스트가 비어있으면 no content 리턴
        if(list == null || list.size() == 0) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Talk>>(list, HttpStatus.OK);
    }


    // 산책 한마디 삭제
    @DeleteMapping("/{talkId}")
    public ResponseEntity<?> deleteTalk(@PathVariable int talkId) {

        int result = talkService.deleteTalk(talkId);

        if(result > 0) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
