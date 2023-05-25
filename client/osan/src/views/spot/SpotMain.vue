// 경유지 메인
<template>
  <div class="outer-box">
    <common-title title="경유지" :property="routeProperty"></common-title>
    <br>
    <div class="route-content">
      <div class="route-main-container">
        <common-list :spots="spots"></common-list>
      </div>
      <div class="route-main-container">
        <common-button value="경유지 등록하기 ➝" theme="extra-big" @handle-click="handleBtn"></common-button>
        <div class="map-outer-box">
          <route-map :points="points" @updatePoints="updatePoints"></route-map>
        </div>
      </div>
    </div>

    <common-title title="후기" :property="reviewProperty"></common-title>
    <br>
    <div class="review-box">
      <review-list :reviews="reviews"></review-list>
    </div>
  </div>
</template>

<script>
import CommonTitle from "@/components/common/CommonTitle.vue";
import CommonList from "@/components/common/CommonList.vue";
import ReviewList from "@/components/common/ReviewList.vue";
import CommonButton from "@/components/common/CommonButton.vue";
import http from "@/util/axiosConfig.js"
import RouteMap from "@/components/common/RouteMap.vue";


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
    CommonTitle,
    CommonList,
    ReviewList,
    CommonButton,
    RouteMap,
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
.outer-box {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.route-content {
  display: flex;
  justify-content: center;
}
.route-main-container {
  width: 500px;
  height: 600px;
  background-color: #f8fafd;
  border-radius: 3%;
  padding: 1.3rem 0.5rem 0 0.5rem;
  margin: 0 10px;

  display: flex;
  flex-direction: column;
  align-items: center;
}
.map-outer-box {
  width: 480px;
  height: 530px;
  margin: 15px 0;
}
.review-box {
  width: 1050px;
}
</style>
