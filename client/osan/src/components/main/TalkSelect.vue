<template>
  <div>
    <div>
      <div>{{ talk.writer }}</div>
      <div>{{ talk.createdAt }}</div>
    </div>
    <div>
      {{ talk.content }}
    </div>
  </div>
</template>

<script>
export default {
  props: {
    talk: {
      type: Object,
    },
  },
};
</script>

<style></style>
