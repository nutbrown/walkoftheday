// 8. 디테일 상세 내용 출력
<template>
  <div>
    <div class="detail-title-box">
      <p id="route-name">산책로 이름</p>
      <div>{{ object.title }}</div>
    </div>
    <div class="detail-content-box">
      <p><strong>작성자</strong>     {{ object.writer }}</p>
      <p v-if="showRoute"><strong>총 거리</strong>     {{ object.distance }}m</p>
      <p v-if="showRoute"><strong>소요 시간</strong>     {{ object.time }}분</p>
      <CommonRating :rating="object.rating"></CommonRating>
    </div>
  </div>
</template>

<script>
// import CommonButton from "./CommonButton.vue";
import CommonRating from "./CommonRating.vue";


export default {
  name: "CommonDetail",
  components: { CommonRating },
  data() {
    return {
      review: {},
      params: null,
    };
  },
  props: {
    showRoute: {
      type: Boolean,
      required: true,
    },
    showSpot: {
      type: Boolean,
      required: true,
    },
    object : {
      type: Object,
    }
  },
  methdos : {
    openModal() {
      console.log("여기에 오나");
      this.$emit('upModal');
    },
    handleBtn() {
      console.log("헬로?")
    }
  }
};
</script>

<style>
.detail-title-box {
  background-color: white;
  border-radius: 5px;
  height: 5.5rem;
  display: flex;
  flex-direction: column;
  align-items: start;
  padding: 15px 0 10px 20px;
  font-size: 1.5rem;
  font-weight: 500;
  font-family: Avenir;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.detail-content-box {
  text-align: left;
  line-height: 2.3rem;
  padding: 1rem;
  font-size: 1.1rem;
}
#route-name {
  font-size: 16px;
  font-weight: 400;
  color: #818181;
}
</style>
