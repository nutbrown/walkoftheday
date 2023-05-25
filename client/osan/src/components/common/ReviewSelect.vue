// 7. 리뷰 한 개 출력
<template>
  <div class="outer-box hover-effect hover-effect:hover" @click="showDetail">
    <div class="review-list">
      <div class="review-list-top">
        <div>
          <common-rating :rating="rating"></common-rating>
          <span class="review-nickname">{{ writer }}</span>
        </div>
        <div>
          <strong>작성일 : </strong>
          <span class="review-option">
            {{ createdAt }}
          </span>
        </div>
      </div>
      <div class="review-list-bottom">
        <p class="review-content">
          {{ content }}
        </p>
      </div>
    </div>  

  </div>
</template>

<script>
import CommonRating from './CommonRating.vue';

export default {
  name: "ReviewSelect",
  components: {
    CommonRating
  },
  props: {
    review: {
      type: Object,
    },
  },
  data() {
    return {
      targetName: this.review.targetName,
      content: this.review.content,
      writer: this.review.writer,
      rating: this.review.rating,
      createdAt: this.review.createdAt,
    };
  },
  methods : {
    showDetail() {
      if(this.review.routeId) {
        this.$router.push(`route/detail/${this.review.routeId}`);
      } else {
        this.$router.push(`spot/detail/${this.review.spotId}`);
      }
    },
  }
};
</script>

<style scoped>
.outer-box {
  padding: 10px;
  border-bottom: 1px solid #ccc;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.hover-effect:hover {
  background-color: #eee;
  color: #333;
}

.review-list {
  width: 100%;
}
.review-list-top {
  display: flex;
	justify-content: space-between;
}
.review-list-bottom {
  display: flex;
	justify-content: space-between;
}

.review-nickname {
    font-size: 25px;
    font-weight: 500;
    color: #152545;
    margin: 0 10px;
}

.review-list strong{
  font-size: 13px;
  font-weight: 400;
  color: #585858;
}
.review-option {
    font-size: 13px;
    font-weight: 400;
    color: #585858;
}
.review-content {
    font-size: 16px;
    margin: 10px 0;
    font-weight: 400;
}
.review-date {
    font-size: 12px;
    font-weight: 400;
    color: grey;
}
.review-content-detail {
    font-size: 13px;
    font-weight: 350;
    line-height: 30px;
}
</style>
