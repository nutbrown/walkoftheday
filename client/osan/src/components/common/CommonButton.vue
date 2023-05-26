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
          "--radius": "1.5rem",
          "--fontsize": "1rem",
        };
      // 작은 버튼
      } else if(this.theme === "small") {
        return {
          "--color": "#c8cbd1",
           "--border": "none",
           "--text": "white",
           "--width": "4.5rem",
           "--height": "1.8rem",
           "--radius": "0.4rem",
           "--fontsize": "12px",
        }
      // 적당히 중간 버튼
      } else if(this.theme === "middle") {
        return {
          "--color": "gray",
           "--border": "none",
           "--text": "white",
           "--width": "9rem",
           "--height": "1.8rem",
           "--radius": "0.3rem",
           "--fontsize": "14px",
        }
      // 커다란 네모 버튼
      } else if(this.theme === "extra-big") {
        return {
          "--color": "#bfcde8",
           "--border": "none",
           "--text": "white",
           "--width": "480px",
           "--height": "3.5rem",
           "--radius": "0.5rem",
           "--fontsize": "1.7rem",
           "--fontweight": "500",
        }
      } else {
        return {
          "--color": "black",
          "--border": "none",
          "--text": "white",
          "--width": "5.5rem",
          "--height": "2.5rem",
          "--radius": "1.4rem",

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
  border-radius: var(--radius);
  color: var(--text);
  width: var(--width);
  height: var(--height);
  text-align: center;
  
  font-size: var(--fontsize);
  font-weight: var(--fontweight);
}

button:hover {
  opacity: 0.7;
}
</style>
