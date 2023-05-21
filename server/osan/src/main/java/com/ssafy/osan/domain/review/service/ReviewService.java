package com.ssafy.osan.domain.review.service;

import com.ssafy.osan.domain.review.dto.Review;

import java.util.List;

public interface ReviewService {

    // 리뷰 아이디로 리뷰 조회
    Review showReview(int reviewId);

    // 리뷰 전체 조회
    List<Review> showAllReview(int category);

    // 리뷰 리스트 조회
    List<Review> showReviewList(int category, int id);

    // 리뷰 등록
    int writeReview(int category, int id, Review review);

    // 리뷰 수정
    int modifyReview(int reviewId, Review review);

    // 리뷰 삭제
    int deleteReview(int reviewId);

}
