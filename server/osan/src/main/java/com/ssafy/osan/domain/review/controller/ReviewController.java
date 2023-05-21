package com.ssafy.osan.domain.review.controller;

import com.ssafy.osan.domain.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    // 리뷰 서비스 주입
    @Autowired
    ReviewService reviewService;

    // 리뷰 등록
    @PostMapping("/{category}/{id}")
    public ResponseEntity<?> createReview(@PathVariable int category, @PathVariable int id) {

        return null;
    }

    // 카테고리 별 리뷰 전체 조회
    @GetMapping("/{category}")
    public ResponseEntity<?> getAllReview(@PathVariable int category) {

        return null;
    }

    // 리뷰 리스트 조회
    @GetMapping("/{category}/{id}")
    public ResponseEntity<?> getReviewList(@PathVariable int category, @PathVariable int id) {

        return null;
    }

    // 리뷰 수정
    @PutMapping("/{reviewId}")
    public ResponseEntity<?> putReview(@PathVariable int reviewId) {

        return null;
    }

    // 리뷰 삭제
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable int reviewId) {

        return null;
    }
}