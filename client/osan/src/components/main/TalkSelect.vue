<template>
  <div>
    <div>
      <div>{{ talk.writer }}</div>
      <div>{{ talk.createdAt }}</div>
    </div>
    <div>
      {{ talk.content }}
      <common-button
          value="삭제"
          theme="small"
          @handle-click="handleBtn"
        ></common-button>
    </div>
  </div>
</template>

<script>
import http from '@/util/axiosConfig.js'
import CommonButton from '../common/CommonButton.vue';

export default {
  components : {
    CommonButton
  },
  props: {
    talk: {
      type: Object,
    },
  },
  methods : {
    handleBtn() {
      http.delete(`/talk/${this.talk.talkId}`)
      .then(response => {
        console.log(response);
        this.$parent.getList();
      }).catch(error => {
        console.log(error);
      })
    }
  }
};
</script>

<style></style>
