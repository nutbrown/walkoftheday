// 9. 디테일 설명 출력
<template>
  <div>
    <div>산책 한 마디</div>
    <p>
      {{ content }}
    </p>
  </div>
</template>

<script>
export default {
  name: "CommentContent",
  props: {
    content: {
      type: String,
      required: true,
    },
  },
};
</script>

<style></style>
