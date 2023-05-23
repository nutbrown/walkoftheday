<template>
  <div>
    <div>
      <div>위치는 여기에요</div>
      <CommonButton theme="small" value="수정하기"></CommonButton>
    </div>
    <div>
      {{location}}
    </div>
    <div>
      설정한 위치를 기준으로 산책로가 추천 돼요.
    </div>
  </div>
</template>

<script>
import CommonButton from '../common/CommonButton.vue';

export default { 
  components: { CommonButton },
  props: {
    location : {
      type : String,
    }
  }

};
</script>

<style></style>
