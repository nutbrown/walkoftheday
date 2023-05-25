<template>
  <div>
    <div class="outer-box">
      <div class="route-content">
        <div class="route-main-container">
          <common-list :routes="routes" :points="points" @updatePoints="updatePoints"></common-list>
        </div>
        <div class="route-main-container">
          <div class="map-outer-box">
            <route-map :points="points" @updatePoints="updatePoints"></route-map>
          </div>
        </div>
      </div>
   
      <div class="row-box">
        <div class="route-bottom-container">
          <current-location></current-location>
        </div>

        <div class="route-bottom-container">
          <talk-list></talk-list>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import CommonList from "@/components/common/CommonList.vue";
import CurrentLocation from "@/components/main/CurrentLocation.vue";
import TalkList from "@/components/main/TalkList.vue";
import http from "@/util/axiosConfig.js"
import RouteMap from '@/components/common/RouteMap.vue';

export default {

  data() {
    return {
      points: null,
      routes: [],
    };
  },
  components: {
    CommonList,
    CurrentLocation,
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
.outer-box {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 30px;
}
.route-content {
  display: flex;
  justify-content: center;
  margin-bottom: 50px;
}
.route-main-container {
  width: 500px;
  height: 400px;
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
  height: 330px;
  margin: 15px 0;
}


/*========== 하단 ==========*/
.row-box {
  display: flex;
  flex-direction: row;
  justify-content: center;
}
.route-bottom-container {
  width: 500px;
  height: 400px;
  /* background-color: #f8fafd; */
  border-radius: 3%;
  padding: 1.3rem 0.5rem 0 0.5rem;
  margin: 0 10px;

  display: flex;
  flex-direction: column;
  align-items: flex-start;

}

</style>
