<template>
  <div class="talk-container">
    <h1 class="talk-title">산책 한마디</h1>
    <div class="talk-list-form">
      <div class="talk-list-top">
        <div>산책하는 간단하게 한 마디를 공유할 수 있어요</div>
        <common-button value="등록하기" theme="small" @handle-click="handleBtn"></common-button>
      </div>
      <div class="talk-list-form2">
        <input
          type="text"
          name="text"
          id="text"
          placeholder="산책 한마디를 작성해주세요."
          v-model="postData.content"
        />
        <div class="talk-list-top">
          <!-- <label for="writer">작성자 : </label> -->
          <input class="talk-input" type="text" name="writer" v-model="postData.writer"
            placeholder="닉네임을 입력해주세요." />
        </div>
      </div>

    </div>

    <div class="talk-list-box">
      <div v-for="(talk, index) in talks" :key="index" class="talk-list-select">
        <TalkSelect :talk="talk"></TalkSelect>
      </div>
    </div>
    <br><br><br><br>

  </div>
</template>

<script>
import CommonButton from "../common/CommonButton.vue";
import TalkSelect from "./TalkSelect.vue";
import http from "@/util/axiosConfig.js";

export default {
  components: {
    CommonButton,
    TalkSelect,
  },
  data() {
    return {
      postData: {
        writer: "",
        content: "",
      },
      talks: [],
    };
  },
  props: {},
  mounted() {
    this.getList();
  },
  methods: {
    handleBtn() {
      if (
        this.postData.writer.length == 0 ||
        this.postData.content.length == 0
      ) {
        alert("산책 한마디의 모든 칸을 채워주세요.");
      } else {
        http
          .post("/talk", this.postData)
          .then((response) => {
            console.log(response.data);
            this.postData.writer = "";
            this.postData.content = "";
            this.getList();
          })
          .catch((error) => {
            console.error(error);
          });
      }
    },
    getList() {
      http
        .get("/talk")
        .then((response) => {
          this.talks = response.data;
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style scoped>
/* * {
  box-sizing: border-box;
} */
.talk-container {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 100%;
}
.talk-title {
  margin: 10px 0;
  font-size: 1.7rem;
}
.talk-list-form {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.talk-list-form2 {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}
#text {
  border: 1px solid black;
  border-radius: 14px;
  width: 100%;
  height: 5rem;
  text-align: left;
  vertical-align: middle;
  padding: 1rem;
  font-size: 1rem;
  font-weight: 600;
  margin: 5px 0;
}
.locaton-content {
  /* margin: 0 0 10px 0; */
  margin-top: 10px;
}

.talk-list-box {
  width: 100%;
  margin-top: 10px;
  border: 1px solid gray;
  border-radius: 10px;
  padding: 0 7px;
}
.talk-list-select {
  margin: 10px 0;
}


.talk-input {
  width: 100%;
  height: 3rem;
  border-radius: 10px;
  padding: 0 1rem;

}
.talk-list-top {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>