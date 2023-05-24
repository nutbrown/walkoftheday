<template>
  <div>
    <div>산책 한마디</div>
    <div class="container">
      <div>산책하는 사람들과 간단하게 한 마디를 공유할 수 있어요</div>
      <common-button value="등록하기" theme="small"></common-button>
    </div>
    <CommonInput :inputText="true" :inputImage="false"></CommonInput>
    <div v-for="(talk, index) in talks" :key="index">
        <TalkSelect :talk="talk"></TalkSelect>
    </div>
  </div>
</template>

<script>
import CommonButton from "../common/CommonButton.vue";
import CommonInput from "../common/CommonInput.vue";
import TalkSelect from "./TalkSelect.vue";

export default {
  components: {
    CommonButton,
    CommonInput,
    TalkSelect,
  },
  props : {
    talks : {
        type : Array,
    }
  }
};
</script>

<style></style>
