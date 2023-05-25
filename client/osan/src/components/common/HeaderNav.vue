<template>
  <div class="outer-box">
		<router-link to="/"><img src="../../assets/wotd-logo.png"/></router-link> 
		<div class="login-btns">
      <common-button theme="login" value="로그인"></common-button>
			<common-button theme="login" value="회원가입"></common-button>
		</div>
	</div>
</template>

<script>
import CommonButton from './CommonButton.vue'

export default {
	name: "HeaderNav",
  components: { CommonButton },

}
</script>

<style scoped>
.outer-box {
	background-color: #BCCCEB;
	display: flex;
	justify-content: space-between;
}
img {
	width: 200px;
}
.login-btns {
  margin: 10px;
}
</style>