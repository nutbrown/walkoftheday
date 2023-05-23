// 지도
<template>
  <div>
      <h3>카카오 맵</h3>
      <div id="map"></div>
  </div>
</template>




<script>
export default {
  name: "CommonMap",
  data() {
    return {
      map:null
    };
  },
  props: {
    
    
  },
  mounted() {
    if(window.kakao && window.kakao.maps) {
      this.loadMap();
    } else {
      this.loadScript();
    }
  },
  methods: {
    loadScript() {
      const script = document.createElement("script");
      script.src="//dapi.kakao.com/v2/maps/sdk.js?appkey=87d6dba422d7d0edb18ff8c447c4ce18&autoload=false";
      script.onload = () => window.kakao.maps.load(this.loadMap);
      document.head.appendChild(script);
    },
    loadMap() {
      const container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
      const options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
      };
  
      this.map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
    }
  }

  
};
</script>


