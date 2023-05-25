// 산책로 등록페이지
<template>
<div class="outer-box">
  <div class="inner-box">
		<div class="title-box">
			<common-title title="산책로 등록" property="산책로를 소개해주세요."></common-title>
		</div>
    <h5 class="form-guide-title">산책로 제목</h5>
    <div class="form-guide-detail">소개하고자 하는 산책로 제목을 32자 내로 작성해주세요.</div>
    <input class="form-write-input" placeholder="제목을 입력해 주세요" maxlength="40" name="title" type="text" value="" v-model="postData.title">
  
    <h5 class="form-guide-title">산책로 내용</h5>
    <div class="form-guide-detail">소개하고자 하는 산책로 제목을 32자 내로 작성해주세요.</div>
    <textarea class="form-write-input" placeholder="내용을 입력해 주세요" maxlength="40" name="content" type="text" value="" v-model="postData.content"></textarea>
    
		<h5 class="form-guide-title">작성자</h5>
    <div class="form-guide-detail">소개하고자 하는 산책로 제목을 32자 내로 작성해주세요.</div>
    <input class="form-write-input" placeholder="닉네임을 입력해주세요" maxlength="40" name="title" type="text" value="" v-model="postData.writer">

    <div class="form-shop">
      <!-- <input class="form-write-input shop-input" placeholder="주소를 입력해 주세요" maxlength="40" name="title" type="text" value="" id="form-input" height="10"><br> -->
    </div>

    <h5 class="form-guide-title">경로 설정</h5>
    <div class="form-guide-detail">산책 경로를 입력해주세요.
          클릭하면 마커가 표시되며 오른쪽 마우스를 클릭하면 경로가 종료됩니다.
          다시 클릭하면 입력한 산책로를 변경할 수 있습니다.</div>
    <common-map @getPoints="getPoints" @getTime ="getTime"></common-map>

    <button class="btn-form" @click="postRoute">산책로 등록</button>

    

  </div>
</div>
</template>

<script>
import CommonTitle from "@/components/common/CommonTitle.vue";
import CommonMap from "@/components/common/CommonMap.vue";
import http from "@/util/axiosConfig.js"


export default {
  components: {
    CommonTitle,
    CommonMap
  },
  data() {
    return {
      // 전달할 데이터 points와 time은 common map에서 받아온다.
      postData : {
        title : "",
        content : "",
        writer : "",
        points : "",
        pointsA : [],
        time : 0,
      }
    }
  },
  methods : {
    getPoints(points) {

      this.postData.pointsA = points;
    },
    getTime(time){
      this.postData.time = time;
    },
    postRoute() {
      if (
        this.postData.writer.length == 0 ||
        this.postData.content.length == 0 ||
        this.postData.title.length == 0 ||
        this.postData.pointsA.length == 0 ||
        this.postData.time == 0
      ) {
        alert("산책로의 모든 칸을 채워주세요.");
      } else {
        this.postData.points = JSON.stringify(this.postData.pointsA);
        http
          .post("/route", this.postData)
          .then((response) => {
            console.log(response);
            this.$router.push('/route');
          })
          .catch((error) => {
            console.error(error);
          });
      }
    }
  }

}
</script>

<style scoped>
.outer-box {
  display: flex;
  justify-content: center;
}
.inner-box {
  width: 70%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.title-box {
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	margin-top: 20px;
}
.form-title-box {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  background-color: #bccceb;
  /* padding: 0 20px; */
}
.form-write {
  width:600px;
}
.form-title-detail {
    margin-bottom: 20px;
    font-size: 18px;
    font-weight: 350;
    color: #00b2b0;
}
.form-guide-title {
    margin: 40px 0 5px;
    font-size: 20px;
    font-weight: 450;
}
.form-guide-detail {
    margin-bottom: 10px;
    font-size: 14px;
    font-weight: 350;
    color: #818181;
}
.form-write-input {
    padding-left: 10px;
    height: 48px;
    line-height: 1.2em;
    font-size: 17px;
    width: 100%;
    border: 1px solid rgba(0,0,0,.15);
    word-break: break-all;
}
.form-write-input:hover {
    transition-duration: .2s;
    border: 1px solid;
}
.form-write-input:focus {
    border: none;
    outline: 1px solid #00b2b0;
} 

/* ==================== 하단버튼 ==================== */
.btn-form {
    margin-top: 10px;
    margin-bottom: 100px;
    background-color: #bccceb;
    border: none;
    color: #fff;
    width: 100%;
    height: 48px;
    text-align: center;
    vertical-align: middle;
    border-radius: 2px;
    cursor: pointer;
}
.btn-form:hover {
    background-color: #00b2b0;
    transition-duration: .2s;
}

.input {
    overflow-wrap: break-word;
    font-weight: 400;
    transition-property: border-color,height,padding-right,color;
    transition-duration: .2s,0s;
    border: 1px solid rgba(0,0,0,.15);
    background: #fff;
    width: 100%;
    vertical-align: middle;
    color: rgba(0,0,0,.84);
    height: 48px;
    line-height: 1.2em;
    font-size: 17px;
    font-family: roboto,"Noto Sans KR",-apple-system,dotum,sans-serif;
}
</style>