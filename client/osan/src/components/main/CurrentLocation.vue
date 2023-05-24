<template>
  <div>
    <div>
      <div>위치는 여기에요</div>
      <CommonButton theme="small" value="수정하기"></CommonButton>
    </div>
    <div>
      {{ address }}
    </div>
    <div>
      설정한 위치를 기준으로 산책로가 추천 돼요.
    </div>
  </div>
</template>

<script>
import CommonButton from '../common/CommonButton.vue';

export default { 
  components: { CommonButton },
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
      script.addEventListener('load', function() {
        kakao.maps.load(function () {
          // 카카오맵 API가 로딩이 완료된 후 지도의 기본적인 세팅을 시작해야 한다.
          // 는 아니고 여기서는 주소 반환
          this.showAddress()
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
            console.log('그런 너를 마주칠까 ' + result[0].address.address_name + '을 못가');
            this.address = result[0].address.address_name;
        }
    }    
  },

};



</script>

<style></style>
