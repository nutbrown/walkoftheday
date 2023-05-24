// 산책로 상세페이지
<template>
	<div>
		<div class="title-card">
			<common-map></common-map>
			<common-detail></common-detail>
		</div>
		<div class="content">
			<div class="content-nav">
				<div>설명</div>
				<div>경유지</div>
				<div>후기</div>
			</div>
			<div class="content-title">
				산책 한 마디
			</div>
			<div class="content-detail">
				이 산책로는 비가 오는 날에는 다니지 마마
			</div>
			<div class="content-title">
				경유지
			</div>
			<div class="content-carousel">
				<div></div>
			</div>
			<div class="content-title">
				후기
			</div>
			<review-list></review-list>
			<textarea v-model="review"></textarea>
		</div>

	</div>
</template>

<script>
import CommonMap from '@/components/common/CommonInput.vue'
import CommonDetail from '@/components/common/CommonInput.vue'

export default {
  components: {
		CommonMap,
		CommonDetail,
	},
	data() {
		return {
			review: {

			},

		}
	}

}
</script>

<style>

</style>