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
        return null;
    }

    @Override
    public List<Review> showReviewList(int category, int id) {
        return null;
    }

    @Override
    public int writeReview(int category, int id, Review review) {
        return 0;
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
