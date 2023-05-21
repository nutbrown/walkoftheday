package com.ssafy.osan.domain.review.dao;

import com.ssafy.osan.domain.review.dto.Review;

import java.util.List;

public interface ReviewDao {
    
    // 리뷰 전체 조회
    List<Review> selectAll(int category);
    // 리뷰 리스트 조회
    List<Review> selectList(int category, int id);
    // 리뷰 등록
    int insertReview(int category, int id);
    // 리뷰 수정
    int updateReview(int reviewId, Review review);
    // 리뷰 삭제
    int deleteReview(int reviewId);
    // 리뷰 평점 반영하기

    
}
