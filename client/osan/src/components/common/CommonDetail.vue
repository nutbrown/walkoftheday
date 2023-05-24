// 8. 디테일 상세 내용 출력

<template>
  <div>
    <div>제목입니다.</div>

    <div>
      <div>작성자 : {{ writer }}</div>
      <div v-if="showRoute">총 거리 : {{ distance }}</div>
      <div v-if="showRoute">소요 시간 : {{ time }}</div>
      <div v-if="showSpot">주소 : {{ address }}</div>
      <CommonRating :rating="rating"></CommonRating>
      <common-button theme="move" value="후기 작성하기"></common-button>
    </div>
  </div>
</template>

<script>
import CommonButton from "./CommonButton.vue";
import CommonRating from "./CommonRating.vue";


export default {
  name: "CommonContent",
  components: { CommonButton, CommonRating },
  props: {
    showRoute: {
      type: Boolean,
      required: true,
    },
    showSpot: {
      type: Boolean,
      required: true,
    },
    writer: {
      type: String,
    },
    distance: {
      type: String,
    },
    time: {
      type: String,
    },
    address: {
      type: String,
    },
    star: {
      type: String,
    },
  },
};
</script>

<style></style>
