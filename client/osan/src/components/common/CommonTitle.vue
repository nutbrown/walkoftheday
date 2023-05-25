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
h2 {
	margin: 40px 0 10px 0;
}
p {
	margin: 0;
}
</style>