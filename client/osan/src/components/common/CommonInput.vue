// 2. 공통 input component // 이미지 && 텍스트
<template>
  <div>
    <div v-if="inputText">
      <label for="text">{{ title }}</label>
      <input type="text" name="text" id="text" />
    </div>
    <div v-if="inputImage">
      <label for="file">{{ title }}</label>
      <input type="file" name="file" id="file" accept="image/*" />
    </div>
  </div>
</template>

<script>
export default {
  name: "CommonInput",

  props: {
    title: {
      type: String,
    },
    inputText: {
      type: Boolean,
      required: true,
    },
    inputImage: {
      type: Boolean,
      required: true,
    },
  },
};
</script>

<style></style>
