// 산책로 상세페이지
<template>
  <div>
    <div class="title-card">
      <common-map></common-map>
      <common-detail :object="route" :showRoute="true" :showSpot="false"></common-detail>
    </div>
    <div class="content">
      <ul class="content-nav">
        <li><a>설명</a></li>
        <li>경유지</li>
        <li>후기</li>
      </ul>
      <div class="content-title">산책로 한 마디</div>
      <div class="content-detail">{{ route.content }}</div>
      <!-- <div class="content-title">경유지</div>
      <div class="content-carousel">
        <div></div>
      </div> -->
      <div class="content-title">후기</div>
      <review-list :reviews="reviews"></review-list>
      <textarea v-model="review"></textarea>
    </div>
  </div>
</template>

<script>
import CommonMap from "@/components/common/CommonMap.vue";
import CommonDetail from "@/components/common/CommonDetail.vue";
import ReviewList from "@/components/common/ReviewList.vue";
import http from "@/util/axiosConfig.js"

export default {
  components: {
    CommonMap,
    CommonDetail,
    ReviewList
  },
  data() {
    return {
      route: {},
      reviews: [],
      review: "",
      params: null,
    };
  },
  created() {
    const params = this.$route.params.routeId;
    console.log(this.$route.params.routeId);
    this.params = params;

    this.getRoute();
    this.getReviews();
  },
  methods : {
    getRoute() {
      http.get(`/route/${this.params}`)
      .then((response) => {
        this.route = response.data;
      })
      .catch((error) => {
        console.error(error);
      })
    },
    getReviews() {
      http.get(`/review/1/${this.params}`)
      .then((response) => {
        this.reviews = response.data;
        console.log(this.reviews);
      })
      .catch((error) => {
        console.error(error);
      })
    }

  }
};
</script>

<style>
.title-card {
  display: flex;
  justify-content: center;
}
.content-nav li{
  display: inline-block;
  margin: 0 10px;
}
</style>
