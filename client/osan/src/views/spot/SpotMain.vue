// spot 메인
<template>
  <div class="outer-box">
    <common-title title="경유지" :property="routeProperty"></common-title>
    <div class="route-content">
      <common-list :spots="spots"></common-list>
      <div>
        <common-button value="경유지 등록하기" theme="move" @handle-click="handleBtn"></common-button>
        <common-output-map></common-output-map>
      </div>
    </div>

    <common-title title="후기" :property="reviewProperty"></common-title>
    <review-list :reviews="reviews"></review-list>
  </div>
</template>

<script>
import http from "@/util/axiosConfig.js"
import commonTitle from "@/components/common/CommonTitle.vue";
import CommonButton from "@/components/common/CommonButton.vue";
import CommonList from "@/components/common/CommonList.vue";
import CommonOutputMap from "@/components/common/CommonOutputMap.vue"
import ReviewList from "@/components/common/ReviewList.vue";


export default {
  data() {
    return {
      routeProperty : "다른 사람이 추천하는 경유지를 만나보는데 오늘도 내일도",
      reviewProperty : "경유지 실시간 후기들을 만나보세요",
      spots : [],
      reviews : [],
    };
  },
  components: {
    commonTitle, CommonButton, CommonList, CommonOutputMap, ReviewList
  },
  created() {
    http.get("/spot")
      .then((response) => {
        console.log(response);
        this.spots = response.data;
      })
      .catch((error) => {
        console.error(error);
      }),
      
    http.get("/review/2")
    .then((response) => {
      this.reviews = response.data;
      console.log(this.reviews);
    })
    .catch((error) => {
        console.error(error);
      })
  },
  methods : {
    handleBtn() {
      this.$router.push('spot/create');
    }
  }
};
</script>

<style scoped>
.route-content {
	display: flex;
	justify-content: space-evenly;
	/* width: 80%; */
}

</style>
