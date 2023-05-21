package com.ssafy.osan.domain.review.service;

import com.ssafy.osan.domain.review.dao.ReviewDao;
import com.ssafy.osan.domain.review.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewDao reviewDao;

    @Override
    public List<Review> showAllReview(int category) {
        return reviewDao.selectAll(category);
    }

    @Override
    public List<Review> showReviewList(int category, int id) {
        if(category == 1) {
            return reviewDao.selectRouteList(id);
        } else {
            return reviewDao.selectSpotList(id);
        }
    }

    @Override
    public int writeReview(int category, int id, Review review) {
        review.setCategory(category);
        int result = 0;

        // 산책로
        if (category == 1) {

            // 산책로 Id 세팅
            review.setRouteId(id);

            // 산책로 리뷰 저장
            result = reviewDao.insertRouteReview(review);

            // 리뷰가 잘 등록 되었다면
            if (result == 1) {

                // 산책로 평점 계산
                int newRating = reviewDao.selectRouteRating(id);
                // 리뷰에 담아서 업데이트 시키기 위해 리뷰에 새로운 평점 세팅
                review.setRating(newRating);
                // 산책로 평점 업데이트
                reviewDao.updateRouteRating(review);
            }
        }
        // 경유지
        else {
            // 경유지 아이디 세팅
            review.setSpotId(id);

            // 리뷰 등록
            result = reviewDao.insertSpotReview(review);

            // 리뷰가 잘 등록 되었다면
            if (result == 1) {

                // 산책로 평점 계산
                int newRating = reviewDao.selectSpotRating(id);
                // 리뷰를 dto로 사용하기 위해 새로운 rating set
                review.setRating(newRating);
                // 평점 업데이트
                reviewDao.updateSpotRating(review);
            }
        }
        return result;
    }

    @Override
    public int modifyReview(int reviewId, Review review) {
        return 0;
    }

    @Override
    public int deleteReview(int reviewId) {
        return 0;
    }
}
