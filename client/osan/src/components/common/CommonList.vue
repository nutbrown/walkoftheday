// 3. 산책로 or 경유지 리스트 출력

<template>
  <div class="list-container">
    <div v-if="routes">
      <common-select
        v-for="(route, index) in routes"
        :key="index"
        class="hover-effect hover-effect:hover"
        :route="route"
        :viewRoute="true"
        :viewSpot="false"
        @updateData="handleClick(route.points)"
      >
      </common-select>
    </div>
    
    <div v-if="spots">
      <common-select
        v-for="(spot, index) in spots"
        :key="index"
        class="hover-effect hover-effect:hover"
        :spot="spot"
        :viewRoute="false"
        :viewSpot="true"
        @updateData="handleClick(spot.points)"
      >
      </common-select>
    </div>
  </div>
</template>

<script>
import CommonSelect from "./CommonSelect.vue";
export default {
  props: {
    routes: {
      type: Array,
    },
    spots: {
      type: Array,
    },
  },
  components: { CommonSelect },
  methods: {
    handleClick(points) {
      this.$emit('updatePoints', points);
    },
  },
};
</script>

<style scoped>
.list-container {
  width: 500px;
  background-color: #f8fafd;
  border-radius: 3%;
  padding: 0 10px; /* 나중에 추가 */
  /* margin-left: 1rem; */
}

.hover-effect {
  background-color: #eee;
  color: #333;
}

.hover-effect:hover {
  /* background-color: #333; */
  color: black;
  border: 1px solid gray;
  border-radius: 5px;
}
</style>
