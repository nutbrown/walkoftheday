<template>
  <div class="talk-select-container">
    <div class="talk-select-top">
      <div>{{ talk.writer }}</div>
      <div>{{ talk.regDate }}</div>
    </div>
    <div class="talk-select-bottom">
      {{ talk.content }}
      <common-button value="삭제" theme="small" @handle-click="handleBtn"></common-button>
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

<style>
.talk-select-container {
  background-color: #f8fafd;
  border-radius: 10px;
  text-align: left;
  padding: 5px;

}
.talk-select-top {
  display: flex;
  flex-direction: row;
}
.talk-select-top > div {
  margin: 5px;
}
.talk-select-bottom {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  padding: 5px;
}
</style>
