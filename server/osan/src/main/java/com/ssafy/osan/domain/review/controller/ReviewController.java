package com.ssafy.osan.domain.review.controller;

import com.ssafy.osan.domain.review.dto.Review;
import com.ssafy.osan.domain.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    // 리뷰 서비스 주입
    @Autowired
    ReviewService reviewService;

    // 리뷰 등록
    @PostMapping("/{category}/{id}")
    public ResponseEntity<?> createReview(@PathVariable int category, @PathVariable int id, @RequestBody Review review) {
        int result = reviewService.writeReview(category, id, review);

        // 등록이 안되어 있을 때
        if (result == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // 카테고리 별 리뷰 전체 조회
    @GetMapping("/{category}")
    public ResponseEntity<?> getAllReview(@PathVariable int category) {

        List<Review> reviewList = reviewService.showAllReview(category);
        if (reviewList == null || reviewList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviewList, HttpStatus.OK);
    }

    // 리뷰 리스트 조회
    @GetMapping("/{category}/{id}")
    public ResponseEntity<?> getReviewList(@PathVariable int category, @PathVariable int id) {

        List<Review> reviewList = reviewService.showReviewList(category, id);
        if (reviewList == null || reviewList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviewList, HttpStatus.OK);
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