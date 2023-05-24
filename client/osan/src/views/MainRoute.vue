<template>
  <div>
    <div class="main-up">
      <div>
        <div>오늘의 산책</div>
        <common-list :routes="routes"></common-list>
      </div>
      <div>
        <common-map></common-map>
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
import CommonMap from "@/components/common/CommonMap.vue";
import http from "@/util/axiosConfig.js"

export default {

  data() {
    return {
      routes: [],
    };
  },
  components: {
    CommonList,
    CurrentLocation,
    CurrentWeather,
    TalkList,
    CommonMap,
  },
  created() {
    this.fetchRoute();
    http.get("/route")
      .then((response) => {
        console.log(response);
        this.routes = response.data;
      })
      .catch((error) => {
        console.error(error);
      })
  },
  methods: {
    fetchRoute() {
      
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
