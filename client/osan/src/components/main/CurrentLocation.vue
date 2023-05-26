<template>
  <div class="location-container">
    <div class="location-list-top">
      <h1 class="location-title">위치는 여기에요</h1>
      <!-- <div class="btn-box">
        <common-button theme="small" value="수정하기" @handle-click="tbc"></common-button>
      </div> -->
    </div>
    <div class="location-address">
      {{ address }}
    </div>
    <div class="locaton-content">
      설정한 위치를 기준으로 산책로가 추천 돼요.
    </div>
  </div>
</template>

<script>
// import CommonButton from "../common/CommonButton.vue";

export default { 
  // components: { CommonButton },
  data() {
    return {
      address : String,
    }
  },
  props: {
    location : {
      type : String,
    }
  },
  mounted() {
    // kakao가 로드되지 않았다면 가져오기
    if (!window.kakao || !window.kakao.maps) {
      const script = document.createElement('script')
      script.type = 'text/javascript'
      script.src =
        '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=87d6dba422d7d0edb18ff8c447c4ce18&libraries=clusterer,drawing,services'
      /* global kakao */
      script.addEventListener('load', () => {
        kakao.maps.load(() => {
          // 카카오맵 API가 로딩이 완료된 후 지도의 기본적인 세팅을 시작해야 한다.
          // 는 아니고 여기서는 주소 반환
          this.showAddress();
        })
      })
      document.head.appendChild(script)
    } else {
      // 이미 카카오맵 API가 로딩되어 있다면 바로 주소를 반환한다
      this.showAddress()
    }

  },
  methods: {
    showAddress() {
      var geocoder = new kakao.maps.services.Geocoder();
      var coord = new kakao.maps.LatLng(37.50128800000034, 127.03528175393564);
      geocoder.coord2Address(coord.getLng(), coord.getLat(), this.callback);
    },
    callback(result, status) {
      if (status === kakao.maps.services.Status.OK) {
            this.address = result[0].address.address_name;
        }
    }    
  },

};



</script>

<style>
* {
  box-sizing: border-box;
}
.location-container {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 100%;
}
.location-title {
  margin: 10px 0;
  font-size: 1.7rem;
}
.location-address {
  border: 1px solid black;
  border-radius: 14px;
  width: 100%;
  height: 4rem;
  text-align: left;
  vertical-align: middle;
  padding: 1rem;
  font-size: 1.5rem;
  font-weight: 600;
}
.locaton-content {
  /* margin: 0 0 10px 0; */
  margin-top: 10px;

}

.location-list-top {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-end;
}
.btn-box {
  margin-bottom: 10px;
}
</style>
