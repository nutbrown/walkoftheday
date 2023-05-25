// 산책로 상세페이지
<template>
  <div>
    <div class="title-card">
      <common-map></common-map>
      <common-detail :object="route" :showRoute="true" :showSpot="false"></common-detail>
    </div>
    <div class="content">
      <ul class="content-nav">
        <li><a>설명</a></li>
        <li>경유지</li>
        <li>후기</li>
      </ul>
      <div class="content-title">산책로 한 마디</div>
      <div class="content-detail">{{ route.content }}</div>
      <!-- <div class="content-title">경유지</div>
      <div class="content-carousel">
        <div></div>
      </div> -->
      <div class="content-title">후기</div>
      <review-list :reviews="reviews"></review-list>




      <div>
        <button @click="openModal">Open Modal</button>

        <div v-if="showModal" class="modal">
          <div class="modal-content">
            <span class="close" @click="closeModal">&times;</span>
            <h2>Modal Title</h2>

            <form @submit.prevent="submitModal">
              <div>
                <label for="writer">Writer:</label>
                <input type="text" id="writer" v-model="writer" required>
              </div>

              <div>
                <label for="content">Content:</label>
                <textarea id="content" v-model="content" required></textarea>
              </div>

              <button type="submit">Submit</button>
            </form>
          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
import CommonMap from "@/components/common/CommonMap.vue";
import CommonDetail from "@/components/common/CommonDetail.vue";
import ReviewList from "@/components/common/ReviewList.vue";
import http from "@/util/axiosConfig.js"

export default {
  components: {
    CommonMap,
    CommonDetail,
    ReviewList
  },
  data() {
    return {
      route: {},
      reviews: [],
      review: "",
      params: null,

      showModal: false,
      writer: "",
      content: ""
    };
  },
  created() {
    const params = this.$route.params.routeId;
    console.log(this.$route.params.routeId);
    this.params = params;

    this.getRoute();
    this.getReviews();


  },
  methods : {
    getRoute() {
      http.get(`/route/${this.params}`)
      .then((response) => {
        this.route = response.data;
      })
      .catch((error) => {
        console.error(error);
      })
    },
    getReviews() {
      http.get(`/review/1/${this.params}`)
      .then((response) => {
        this.reviews = response.data;
        console.log(this.reviews);
      })
      .catch((error) => {
        console.error(error);
      })
    },
    
    openModal() {
      this.showModal = true;
    },
    closeModal() {
      this.showModal = false;
    },
    submitModal() {
      // Perform your desired actions with the writer and content data
      console.log("Writer:", this.writer);
      console.log("Content:", this.content);

      // Close the modal
      this.showModal = false;
    }

  }
};





</script>

<style>
.title-card {
  display: flex;
  justify-content: center;
}
.content-nav li{
  display: inline-block;
  margin: 0 10px;
}


.modal {
  display: none;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
  background-color: #fefefe;
  margin: 15% auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
  cursor: pointer;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

</style>
