// 1. 공통 버튼 컴포넌트

<template>
  <button class="btn" :style="styles" @click="handleClick">
    {{ value ? value : "example" }}
  </button>
</template>

<script>
export default {
  name: "CommonButton",
  props: { 
    theme: {
      type : String,
      required : true, 
    }, 
    value: {
      type : String,
      required : true,
    },
  },
  methods: {
    handleClick() {
      this.$emit("handle-click");
    },
  },
  computed: {
    styles() {
      // 산책로, 경유지 이동하기 버튼
      if (this.theme === "move") {
        return {
          "--color": "black",
          "--border": "none",
          "--text": "white",
          "--width": "5rem",
          "--height": "3rem",
        };
      } else {
        return {
          "--color": "black",
          "--border": "none",
          "--text": "white",
          "--width": "5rem",
          "--height": "3rem",
        };
      }
      // 위치 수정하기, 산책 한마디, 후기 등록

      // 산책 한마디 삭제

      // 현재 위치 닫기 버튼

      // 산책, 경유지 등록하러 가기
    },
  },
};
</script>

<style scoped>
button {
  cursor: pointer;
  background-color: var(--color);
  padding: 0.5rem 0.75rem 0.5rem 0.75rem;
  border: var(--border);
  border-radius: 1.5rem;
  color: var(--text);
  width: var(--width);
  height: var(--height);
  text-align: center;
}

button:hover {
  opacity: 0.7;
}
</style>
