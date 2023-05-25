// 3. 산책로 or 경유지 리스트 출력

<template>
  <div class="container">
    <div v-if="routes">
      <div v-for="(route, index) in routes" :key="index">
        <common-select :route="route" :viewRoute="true" :viewSpot="false">
        </common-select>
      </div>
    </div>

    <div v-if="spots">
      <div v-for="(spot, index) in spots" :key="index">
        <common-select :spot="spot" :viewRoute="false" :viewSpot="true">
        </common-select>
      </div>
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
};
</script>

<style scoped>
.container {
  width: 500px;
  background-color: #f8fafd;
  border-radius: 3%;
  padding: 1rem;
  margin-left: 1rem;
}
</style>
