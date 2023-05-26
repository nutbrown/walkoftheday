// 산책로 상세페이지
<template>
  <div class="detail-outer-box">
    <div class="route-detail-container">
      <div class="title-card">
        <div class="detail-map-box">
          <route-map :points="route.points"></route-map>
        </div>
        <div class="detail-detail-box">
          <common-detail :object="route" :showRoute="true" :showSpot="false"></common-detail>
          <button class="button-large" @click="openModal">후기 작성하기</button>
        </div>
        
      </div>
      <div class="content">
        <ul class="content-nav">
          <li><a>설명</a></li>
          <li>경유지</li>
          <li>후기</li>
        </ul>
        <div class="content-title">산책로 한 마디</div>
        <div class="content-detail">{{ route.content }}</div>
        <div class="content-title">후기</div>
        <div class="review-box">
          <review-list :reviews="reviews"></review-list>
          <button class="button-large" @click="openModal">후기 작성하기</button>
        </div>


        <!-- 후기 작성 모달 -->
        <div>

          <div v-if="showModal" class="modal">
            <div class="modal-content">
              <span class="close" @click="closeModal">&times;</span>
              <h2>후기 작성</h2>
              <p>산책로에 대한 솔직한 후기를 작성해주세요.</p>
              <form @submit.prevent="submitModal">
                <div class="modal-container">
                  <div class="modal-container-box">
                    <label for="star" class="form-guide-detail">별점</label>
                    <div class="rating" id="starRating">
                      <span @click="()=>rateStar(5)">&#9734;</span>
                      <span @click="()=>rateStar(4)">&#9734;</span>
                      <span @click="()=>rateStar(3)">&#9734;</span>
                      <span @click="()=>rateStar(2)">&#9734;</span>
                      <span @click="()=>rateStar(1)">&#9734;</span>
                    </div>
                  </div>
                  <div class="modal-container-box">
                    <label for="writer" class="form-guide-detail">작성자</label>
                    <input class="form-write-input" type="text" id="writer" v-model="postData.writer" required>
                  </div>
                  <div class="modal-container-box">
                    <label for="content" class="form-guide-detail">후기 내용 </label>
                    <textarea class="form-write-input" id="content" v-model="postData.content" required></textarea>
                  </div>
                </div>
                <button class="button-middle" @click="postReview">후기 제출</button>
              </form>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import RouteMap from "@/components/common/RouteMap.vue";
import CommonDetail from "@/components/common/CommonDetail.vue";
import ReviewList from "@/components/common/ReviewList.vue";
import http from "@/util/axiosConfig.js"

export default {
  components: {
    RouteMap,
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
      content: "",
      selectedRating: 0,
      postData: {
        writer : "",
        content : "",
        rating : 0,
      }
    };
  },
  created() {
    const params = this.$route.params.routeId;
    this.params = params;

    this.getRoute();
    this.getReviews();


  },
  methods : {
    postReview() {
      if (
        this.postData.writer.length == 0 ||
        this.postData.content.length == 0 ||
        this.postData.rating ===0
      ) {
        alert("리뷰 모든 칸을 채워주세요.");
      } else {
        http
          .post(`/review/1/${this.params}`, this.postData)
          .then(() => {
            this.postData.writer = "";
            this.postData.content = "";
            this.getReviews();
            this.getRoute();
          })
          .catch((error) => {
            console.error(error);
          });
      }
    },
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
    
      // Close the modal
      this.showModal = false;
    },

    rateStar(rating) {
        this.postData.rating = rating;
        const stars = document.querySelectorAll('.rating > span');
        stars.forEach((star, index) => {
            let temp = 5 - index;
            if (temp <= rating) {
                star.classList.add('checked');
            } else {
                star.classList.remove('checked');
            }
        });
    },
    exportRating() {
        console.log('Selected rating:', this.selectedRating);
        // You can do further processing with the rating value here
    }

  }
};





</script>

<style>
.detail-outer-box {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.route-detail-container {
  width: 70%;
  display: flex;
  flex-direction: column;
  /* justify-content: center; */
  align-items: center;
  margin-top: 30px;
}

/* ============ 상단 카드 ============ */
.title-card {
  display: flex;
  justify-content: space-around;
  width: 70%;
  height: 420px;
  background-color: #f8fafd;
  border-radius: 3%;
  padding: 1.3rem 1rem;
  margin: 0 10px;
}
.detail-map-box {
  width: 60%;
  height: 100%;
}
.detail-detail-box {
  width: 40%;
  height: 100%;
  padding-left: 15px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}


/* ============ 내용 ============ */
.content {
  width: 70%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.content-nav {
  width: 100%;
  float: left;
  padding-bottom: 10px;
  border-bottom: 2px solid gray;
  margin-top: 30px;
}
.content-nav li{
  display: inline-block;
  margin: 0 10px;
}

.review-box {
  width: 100%;
}
.content-title {
  margin: 40px 0 5px;
  font-size: 20px;
  font-weight: 450;
}
.content-detail {
  margin-bottom: 10px;
  font-size: 16px;
  font-weight: 400;
}

/* ============ 모달 ============ */
.modal {
  /* display: none; */
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
  padding: 10px 80px 20px;
  border: 1px solid #888;
  width: 40%;
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
/* 수정 */
.modal-container {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.modal-container-box {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin: 10px 0;
  width: 100%;
}
.form-guide-detail {
    /* margin: 20px; */
    font-size: 18px;
    font-weight: 500;
    color: #818181;
}
.form-write-input {
    padding-left: 10px;
    height: 40px;
    line-height: 1.2em;
    font-size: 17px;
    width: 100%;
    border: 1.5px solid rgba(0,0,0,.15);
    word-break: break-all;
}
.form-write-input:hover {
    transition-duration: .2s;
    border: 1px solid;
}
.form-write-input:focus {
    border: none;
    outline: 1.5px solid #bccceb;
} 
#content {
  resize: none;
  height: 60px;
}

/* ============ 별점 ============ */
.rating {
    unicode-bidi: bidi-override;
    direction: rtl;
    text-align: center;
    font-size: 30px;
    color: #ddd;
    cursor: pointer;
}
.rating > span {
    display: inline-block;
    position: relative;
    width: 1.1em;
}
.rating > span:hover:before,
.rating > span:hover ~ span:before,
.rating > span.checked:before,
.rating > span.checked ~ span:before{
    content: "\2605";
    position: absolute;
    color: gold;
}


/* ============ 버튼 ============ */
.button-large {
  cursor: pointer;
  background-color: #bfcde8;
  padding: 0.5rem 0.75rem 0.5rem 0.75rem;
  border: none;
  border-radius: 0.5rem;
  color: white;
  width: 100%;
  height: 3.5rem;
  /* text-align: center; */
  font-size: 1.5rem;
  font-weight: 400;
}
.button-middle {
  cursor: pointer;
  background-color: gray;
  padding: 0.5rem 0.75rem 0.5rem 0.75rem;
  border: none;
  border-radius: 0.5rem;
  color: white;
  width: 8rem;
  height: 2rem;
  /* text-align: center; */
  font-size: 14px;
}
</style>
