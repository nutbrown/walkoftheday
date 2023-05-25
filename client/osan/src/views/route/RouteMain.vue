// 산책로 메인페이지
<template>
  <div class="outer-box">
    <common-title title="산책로" :property="routeProperty"></common-title>
    <br>
    <div class="route-content">
      <div class="route-main-container">
        <common-list :routes="routes" :points="points" @updatePoints="updatePoints"></common-list>
      </div>
      <div class="route-main-container">
        <common-button value="산책로 등록하기 ➝" theme="extra-big" @handle-click="handleBtn"></common-button>
        <route-map :points="points" @updatePoints="updatePoints"></route-map>
      </div>
    </div>

    <common-title title="후기" :property="reviewProperty"></common-title>
    <review-list :reviews="reviews"></review-list>
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
  name: "RouteMain",

  data() {
    return {
      routeProperty: "다른사람들이 추천하는 산책로를 만나보는데 오늘도 내일도",
      reviewProperty: "산책로 실시간 후기들을 만나보세요",
      routes: [],
      reviews: [],
      points: null,
    };
  },
  components: {
    CommonTitle,
    CommonList,
    ReviewList,
    CommonButton,
    RouteMap,
},
  mounted() {
    this.getRoutes();
    this.getReview();
  },
  methods : {
    getRoutes() {
      http.get("/route")
      .then((response) => {
        this.routes = response.data;
      })
      .catch((error) => {
        console.error(error);
      })
    },
    
    getReview() {
      http.get("/review/1")
      .then((response) => {
        this.reviews = response.data;
      })
      .catch((error) => {
        console.error(error);
      })
    },

    handleBtn() {
      this.$router.push('route/create');
    },
    updatePoints(points) {
      this.points=points;
    }
  }
  
};
</script>

<style scoped>
.route-content {
  display: flex;
  justify-content: center;
}
.route-main-container {
  width: 500px;
  height: 600px;
  background-color: #f8fafd;
  border-radius: 3%;
  padding: 1.3rem 0.5rem;
  margin: 0 10px;
}
</style>
