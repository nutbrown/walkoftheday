// 4. 리스트 중 하나 컴포너트

<template>
  <div>
    <!-- 산책로 -->
    <div v-if="viewRoute" class="select-container" @click="updatePoints">
      <div class="inner-square inner-title flex-box-row">
        <div class="title">
          {{ route.title }}
        </div>
        <div class="flex-box-row">
          <div class="writer">작성자 : {{ route.writer }}</div>
          <div class="star">
              <CommonRating :rating="route.rating"></CommonRating>
          </div>
        </div>
      </div>

      <div class="inner-square inner-content flex-box-row">
        <div class="content">{{ route.content }}</div>
        <common-button theme="middle" value="산책로 이동하기" @handle-click="goRouteDetail"></common-button>
      </div>

    </div>

    <!-- 경유지 -->
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
        <common-button theme="middle" value="경유지 이동하기" @handle-click="goSpotDetail"></common-button>
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
      this.$router.push({path: `route/detail/${this.route.routeId}`});
    }, 
    goSpotDetail() {
      this.$router.push(`spot/detail/${this.spot.spotId}`);
    },
    updatePoints() {
      this.$emit('updateData');
    }
  }
};
</script>

<style scoped>
.select-container {
  background-color: white;
  border-radius: 5px;
  padding: 5px;
  /* border: 0.5px solid #e9ecf1; */

}
.flex-box-row {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.inner-square {
  border-radius: 5px;
  background-color: #e9ecf1;
  margin: 5px;
  padding: 10px;
}
.title {
  font-weight: 700;
  font-size: 1.2rem;
}
.writer {
  margin-right: 12px;
}

</style>
