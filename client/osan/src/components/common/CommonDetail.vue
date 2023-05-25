// 8. 디테일 상세 내용 출력

<template>
  <div>
    <div>{{ object.title }}</div>

    <div>
      <div>작성자 : {{ object.writer }}</div>
      <div v-if="showRoute">소요 시간 : {{ object.time }}</div>
      <div v-if="showSpot">주소 : {{ address }}</div>
      <CommonRating :rating="object.rating"></CommonRating>
      <common-button theme="move" value="후기 작성하기"></common-button>
    </div>
  </div>
</template>

<script>
import CommonButton from "./CommonButton.vue";
import CommonRating from "./CommonRating.vue";


export default {
  name: "CommonDetail",
  components: { CommonButton, CommonRating },
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
};
</script>

<style></style>
