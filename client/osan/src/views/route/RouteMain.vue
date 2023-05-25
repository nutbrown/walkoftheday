// 산책로 메인페이지
<template>
  <div class="outer-box">
    <common-title title="산책로" :property="routeProperty"></common-title>
    <div class="route-content">
      <common-list :routes="routes"></common-list>
      <div class="container">
        <common-button value="산책로 등록하기" theme="move" @handle-click="handleBtn"></common-button>
        <common-map></common-map>
      </div>
    </div>

    <common-title title="후기" :property="reviewProperty"></common-title>
    <review-list :reviews="reviews"></review-list>
  </div>
</template>

<script>
import CommonTitle from "@/components/common/CommonTitle.vue";
import CommonList from "@/components/common/CommonList.vue";
import CommonMap from "@/components/common/CommonMap.vue";
import ReviewList from "@/components/common/ReviewList.vue";
import CommonButton from "@/components/common/CommonButton.vue";
import http from "@/util/axiosConfig.js"

export default {
  name: "RouteMain",

  data() {
    return {
      routeProperty: "다른사람들이 추천하는 산책로를 만나보는데 오늘도 내일도",
      reviewProperty: "산책로 실시간 후기들을 만나보세요",
      routes: [],
      reviews: [],
    };
  },
  components: {
    CommonTitle,
    CommonList,
    CommonMap,
    ReviewList,
    CommonButton,
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
  }
  
};
</script>

<style scoped>
.outer-box {
  /* display: flex; */
  /* justify-content: center; */
}
.route-content {
  display: flex;
  justify-content: center;
}
.container {
  width: 500px;
  background-color: #f8fafd;
  border-radius: 3%;
  padding: 2rem;
}
</style>
