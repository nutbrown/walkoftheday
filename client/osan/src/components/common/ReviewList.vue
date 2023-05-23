// 6. 리뷰 리스트 출력
<template>
  <div>
    <review-select
      v-for="(review, index) in reviews" :key="index" :review="review"
      ></review-select>
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

<style></style>
