<template>
  <div>
    <div>산책 한마디</div>
    <div>
      <div>산책하는 사람들과 간단하게 한 마디를 공유할 수 있어요</div>
      <div class="container">
        <div>
          <div>
            <label for="writer">작성자</label>
            <input type="text" name="writer" v-model="postData.writer" />
          </div>
          <div>
            <label for="writer">내용</label>
            <input
              type="text"
              name="text"
              id="text"
              v-model="postData.content"
            />
          </div>
        </div>

        <common-button
          value="등록하기"
          theme="small"
          @handle-click="handleBtn"
        ></common-button>
      </div>
    </div>

    <div v-for="(talk, index) in talks" :key="index">
      <TalkSelect :talk="talk"></TalkSelect>
    </div>
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
.container {
  display: flex;
}
</style>
