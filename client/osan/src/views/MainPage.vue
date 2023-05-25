<template>
  <div>
    <div class="main-up">
      <div>
        <div>오늘의 산책</div>
        <common-list :routes="routes" :points="points" @updatePoints="updatePoints"></common-list>
      </div>
      <div>
        <route-map :points="points" @updatePoints="updatePoints"></route-map>
      </div>
    </div>
    <div class="main-up">
      <div>
        <div>
          <current-location></current-location>
        </div>
        <div>
          <current-weather></current-weather>
        </div>
      </div>
      <div>
        <talk-list></talk-list>
      </div>
    </div>
  </div>
</template>

<script>
import CommonList from "@/components/common/CommonList.vue";
import CurrentLocation from "@/components/main/CurrentLocation.vue";
import CurrentWeather from "@/components/main/CurrentWeather.vue";
import TalkList from "@/components/main/TalkList.vue";
import http from "@/util/axiosConfig.js"
import RouteMap from '@/components/common/RouteMap.vue';

export default {

  data() {
    return {
      points: [],
      routes: [],
    };
  },
  components: {
    CommonList,
    CurrentLocation,
    CurrentWeather,
    TalkList,
    RouteMap,
  },
  created() {
    http.get("/route")
      .then((response) => {
        this.routes = response.data;
      })
      .catch((error) => {
        console.error(error);
      })
  },
  methods: {
    updatePoints(points) {
      this.points=points;
    }

  }
};
</script>

<style scoped>
.main-up {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
</style>
