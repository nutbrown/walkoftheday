<template>
	<div class="starlist">
      <img v-if="rating == 0" src="../../assets/0stars.png"/>  
      <img v-if="rating == 1" src="../../assets/1stars.png"/>  
      <img v-if="rating == 2" src="../../assets/2stars.png"/>  
      <img v-if="rating == 3" src="../../assets/3stars.png"/>  
      <img v-if="rating == 4" src="../../assets/4stars.png"/>  
      <img v-if="rating == 5" src="../../assets/5stars.png"/>  
    </div>
</template>

<script>
export default {
	name: "CommonRating",
	props: {
		rating: Number,
	}


}
</script>

<style scoped>
.starlist {
  display: inline;
}
img {
  width: 100px;
}
</style>