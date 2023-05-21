package com.ssafy.osan.domain.review.dao;

import com.ssafy.osan.domain.review.dto.Review;

import java.util.List;

public interface ReviewDao {

    // 리뷰 한 개 조회
    Review selectReview(int reviewId);
    
    // 리뷰 전체 조회
    List<Review> selectAll(int category);
    // 리뷰 리스트 조회
    List<Review> selectRouteList(int id);
    List<Review> selectSpotList(int id);
    // 리뷰 등록
    int insertRouteReview(Review review);
    int insertSpotReview(Review review);
    // 리뷰 수정
    int updateReview(Review review);
    // 리뷰 삭제
    int deleteReview(int reviewId);

    // 리뷰 평점 반영하기
    int updateRouteRating(Review review);

    int updateSpotRating(Review review);

    // 리뷰 평점 계산하기
    int selectRouteRating(int id);
    int selectSpotRating(int id);
}
