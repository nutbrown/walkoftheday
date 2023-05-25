// 7. 리뷰 한 개 출력
<template>
<div class="outer-box hover-effect hover-effect:hover" @click="showDetail">
    <div>
      <common-rating :rating="rating"></common-rating>
      <span class="inner-header">{{ writer }}</span>
      <span class="inner-header">{{  createdAt }}</span>
    </div>
    <div id="target-name">{{ targetName }}</div>
    <div id="content">{{  content }}</div>
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
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  width: 100%;

}
.inner-header {
  margin: 0 0 0 10px;
}
#target-name {
  font-size: 1.5rem;
}

  .hover-effect {
    background-color: #eee;
    color: #333;
  }

  .hover-effect:hover {
    background-color: #333;
    color: #eee;
  }

</style>
