// 11. 리스트 이미지 컴포넌트

<template>
  <div>
    <img :src="type" :alt="alt" :style="styles" />
  </div>
</template>

<script>
export default {

  probs: {
    src : {
      type : String,
    },
    alt : {
      type : String,
    },
    theme : {
      type : String,
    }
  },
  computed: {
    styles() {
      // 산책로, 경유지 이동하기 버튼
      if (this.theme === "List") {
        return {
          "--width": "5rem",
          "--height": "3rem",
        };
      } else {
        return {
          "--width": "10rem",
          "--height": "6rem",
        };
      }

    },
  },
};
</script>

<style>


img {
  width : var(--width);
  height : var(--height);
}
</style>
