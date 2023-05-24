<template>
  <div class="outer-box">
		<a><img src="../../assets/wotd-logo.png"/></a>
		<div>
			<common-button theme="login" value="로그인"></common-button>
			<common-button theme="login" value="로그아웃"></common-button>
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
</style>