package com.ssafy.osan.domain.review.dto;

import java.util.Date;

public class Review {
        private int reviewId;
        private int category;
        private int routeId;
        private int spotId;
        private String content;
        private String writer;
        private int rating;
        private Date createdAt;
        private Date updatedAt;
        private String regDate;

        public Review() {
        }

        public String getRegDate() {
                return regDate;
        }

        public void setRegDate(String regDate) {
                this.regDate = regDate;
        }

        public int getReviewId() {
                return reviewId;
        }

        public void setReviewId(int reviewId) {
                this.reviewId = reviewId;
        }

        public int getCategory() {
                return category;
        }

        public void setCategory(int category) {
                this.category = category;
        }

        public int getRouteId() {
                return routeId;
        }

        public void setRouteId(int routeId) {
                this.routeId = routeId;
        }

        public int getSpotId() {
                return spotId;
        }

        public void setSpotId(int spotId) {
                this.spotId = spotId;
        }

        public String getWriter() {
                return writer;
        }

        public void setWriter(String writer) {
                this.writer = writer;
        }

        public int getRating() {
                return rating;
        }

        public void setRating(int rating) {
                this.rating = rating;
        }

        public Date getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
                this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
                return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
                this.updatedAt = updatedAt;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        @Override
        public String toString() {
                return "Review{" +
                        "reviewId=" + reviewId +
                        ", category=" + category +
                        ", routeId=" + routeId +
                        ", spotId=" + spotId +
                        ", writer='" + writer + '\'' +
                        ", rating=" + rating +
                        ", createdAt=" + createdAt +
                        ", updatedAt=" + updatedAt +
                        '}';
        }

}
