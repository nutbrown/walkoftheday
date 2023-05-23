// 5. 타이틀 제목 내용
<template>
	<div>
		<h2>{{ title }}</h2>
		<p>{{ property }}</p>
	</div>
</template>

<script>
export default {
	name: "CommonTitle",
	props: {
    title: String,
    property: String,
  },

}
</script>

<style>

</style>