// 산책로 메인페이지
<template>
	<div class="outer-box">
		<common-title title="산책로" :property="routeProperty"></common-title>
		<div class="route-content">
			<common-list :routes="routes"></common-list>
			<div>
				<common-button value="산책로 등록하기" theme="move"></common-button>
				<common-map></common-map>
			</div>
		</div>

		<common-title title="후기" :property="reviewProperty"></common-title>
		<review-list :reviews="reviews"></review-list>
	</div>
</template>

<script>
import CommonTitle from '@/components/common/CommonTitle.vue'
import CommonList from '@/components/common/CommonList.vue'
import CommonMap from '@/components/common/CommonMap.vue'
import ReviewList from '@/components/common/ReviewList.vue'
import CommonButton from '@/components/common/CommonButton.vue'

export default {
	name: "RouteMain",

	data() {
		return {
			routeProperty: "다른사람들이 추천하는 산책로를 만나보는데 오늘도 내일도",
			reviewProperty: "산책로 실시간 후기들을 만나보세요",
			routes: [
				{
					title: "ddd",
					rating: "3",
					updatedAt: "2023-04-21",
					writer: "창주주"
				},
				{
					title: "다른사람들이 추천하는",
					rating: "3",
					updatedAt: "2023-04-21",
					writer: "창주주"
				},{
					title: "책로를 만나보는",
					rating: "3",
					updatedAt: "2023-04-21",
					writer: "창주주"
				},{
					title: "늘도 내일도",
					rating: "3",
					updatedAt: "2023-04-21",
					writer: "창주주"
				},
			],
			reviews : [
				{
					targetName: "역삼 주변 한바퀴 가볍게",
					content: "산책은 즐겁나",
					writer: "전해련",
					rating: 3,
					createdAt: "2022-03-04"
				},
				{
					targetName: "선릉으로 가볼까",
					content: "산책은 즐겁나 - 아니요",
					writer: "한상빈",
					rating: 1,
					createdAt: "2032-03-04"
				},
			]
		}
	},

	components: {
		CommonTitle,
		CommonList,
		CommonMap,
		ReviewList,
CommonButton,
	}
,
ReviewList
}
</script>

<style>
.outer-box {
	/* display: flex; */
	/* justify-content: center; */
}
.route-content {
	display: flex;
	justify-content: space-evenly;
	/* width: 80%; */
}
</style>