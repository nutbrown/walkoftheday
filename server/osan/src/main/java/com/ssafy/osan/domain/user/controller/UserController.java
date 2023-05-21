package com.ssafy.osan.domain.user.controller;

import com.ssafy.osan.domain.route.dto.Route;
import com.ssafy.osan.domain.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ssafy.osan.domain.user.service.UserService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입
    @PostMapping("")
    public ResponseEntity<?> regist(User user) {

        int result = userService.regist(user);

        if (result > 0) {
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(User loginUser) {
        // 아이디로 User 객체를 가져와서 아이디가 같은지 확인
        User selectedUser = userService.getUser(loginUser.getUserId());

        // user가 null이 아니라면
        if (selectedUser != null) {
            // 비밀번호가 같다면
            if (selectedUser.getPassword().equals(loginUser.getPassword())) {
                return new ResponseEntity<User>(loginUser, HttpStatus.ACCEPTED);
            }
        }

        // 다 아니면 로그인 실패
        return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
    }


    // 로그아웃
    @GetMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {

        session.invalidate();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}