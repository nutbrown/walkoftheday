// 6. 리뷰 리스트 출력
<template>
  <div class="review-container">
    <div class="review-outer-box">
      <review-select
      v-for="(review, index) in reviews" :key="index" :review="review"
      ></review-select>
    </div>
  </div>
</template>

<script>
import ReviewSelect from "./ReviewSelect.vue";

export default {
  name: "ReviewList",
  components: {
    ReviewSelect,
  },
  data() {
    return {};
  },
  props: {
    reviews: {
      type: Array,
    },
    msg: String,
  },
};
</script>

<style scoped>
.review-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  /* width: 100%; */
  padding: 20px 0 30px 0;
}
.review-outer-box {
  width: 970px;
  border: 1px solid gray;
  border-radius: 5px;
  padding: 30px 40px;
}
</style>
