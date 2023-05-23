// 4. 리스트 중 하나 컴포너트

<template>
  <div>
    <div v-if="viewRoute" class="container">
      <div>
        <div class="title">
          {{ route.title }}
        </div>
        <div class="detail">
          <div class="rating">별점 : {{ route.rating }}</div>

          <div class="date">작성일 : {{ route.updatedAt }}</div>

          <div class="writer">작성자 : {{ route.writer }}</div>
        </div>
        <div class="content">
          {{ route.content }}
        </div>
      </div>

      <div>
        <CommonImage></CommonImage>
        <common-button theme="select" value="산책로 이동하기"></common-button>
      </div>
    </div>
    <div v-if="viewSpot">
      <div>
        <div class="title">
          {{ spot.title }}
        </div>
        <div class="detail">
          <div class="rating">별점 : {{ route.rating }}</div>

          <div class="date">작성일 : {{ route.updatedAt }}</div>

          <div class="writer">작성자 : {{ route.writer }}</div>
        </div>
        <div class="content">
          {{ route.content }}
        </div>
      </div>

      <div>
        <CommonImage></CommonImage>
        <common-button theme="select" value="산책로 이동하기"></common-button>
      </div>
    </div>
  </div>
</template>

<script>
import CommonButton from "./CommonButton.vue";
import CommonImage from "./CommonImage.vue";

export default {
  components: { CommonButton },
  name: "CommonSelect",
  comments: {
    CommonImage,
  },
  props: {
    viewSpot: {
      type: Boolean,
    },
    viewRoute: {
      type: Boolean,
    },
    route: {
      type: Object,
    },
    spot: {
      type: Object,
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: row;
}

.detail {
  display: flex;
  flex-direction: row;
}
</style>
