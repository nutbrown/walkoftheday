// 4. 리스트 중 하나 컴포너트

<template>
  <div>
    <div v-if="viewRoute" class="container">
      <div>
        <div class="title">
          {{ route.title }}
        </div>
        <div class="star">
            <CommonRating :rating="route.rating"></CommonRating>
        </div>
        <div class="detail">
          

          <div class="date">작성일 : {{ route.updatedAt }}</div>

          <div class="writer">작성자 : {{ route.writer }}</div>
        </div>
        <div class="content">
          {{ route.content }}
        </div>
      </div>

      <div>
        <common-button theme="select" value="산책로 이동하기" @handle-click="goRouteDetail"></common-button>
      </div>
    </div>
    <div v-if="viewSpot">
      <div>
        <div class="title">
          {{ spot.spotName }}
        </div>
        <div class="star">
            <CommonRating :rating="spot.rating"></CommonRating>
        </div>
        <div class="detail">
        
          <div class="date">작성일 : {{ spot.updatedAt }}</div>

          <div class="writer">작성자 : {{ spot.writer }}</div>
        </div>
        <div class="content">
          {{ spot.content }}
        </div>
      </div>

      <div>
        <common-button theme="select" value="경유지 이동하기" @handle-click="goSpotDetail"></common-button>
      </div>
    </div>
  </div>
</template>

<script>
import CommonButton from "./CommonButton.vue";

import CommonRating from './CommonRating.vue';

export default {
  components: { CommonButton, CommonRating },
  name: "CommonSelect",
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
  methods: {
    goRouteDetail() {
      this.$router.push(`route/detail?routeId=${this.route.routeId}`);
    }, 
    goSpotDetail() {
      this.$router.push(`spot /detail?spotId=${this.spot.spotId}`);
    },
  }
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

.title {
  display: flex;
  justify-content: flex-start;
}

.star{
  display: flex;
  justify-content: flex-end;
}
</style>
