<template>
  <div>
    <h3>산책로 출력 맵</h3>
    <div id="map2" ref="map" style="width: 500px; height: 400px"></div>
    <div>{{ points }}</div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    points: null,
  },
  mounted() {
    if (!window.kakao || !window.kakao.maps) {
      const script = document.createElement("script");
      script.type = "text/javascript";
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=87d6dba422d7d0edb18ff8c447c4ce18&libraries=clusterer,drawing,services";
      // eslint를 사용한다면 kakao 변수가 선언되지 않았다고
      // 오류를 내기 때문에 아래 줄과 같이 전역변수임을 알려주어야 한다.
      /* global kakao */
      script.addEventListener("load", () => {
        kakao.maps.load(() => {
          // 카카오맵 API가 로딩이 완료된 후 지도의 기본적인 세팅을 시작해야 한다.
          this.initMap();
        });
      });
      document.head.appendChild(script);
    } else {
      // 이미 카카오맵 API가 로딩되어 있다면 바로 지도를 생성한다.
      this.initMap();
    }
  },
  methods: {
    initMap() {
      var mapContainer = document.getElementById("map2"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.50128800000034, 127.03528175393564), // 지도의 중심좌표
          level: 3, // 지도의 확대 레벨
        };

      var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

      var drawingFlag = false; // 선이 그려지고 있는 상태를 가지고 있을 변수입니다
      var clickLine; // 마우스로 클릭한 좌표로 그려질 선 객체입니다
      var distanceOverlay; // 선의 거리정보를 표시할 커스텀오버레이 입니다
      var dots = {}; // 선이 그려지고 있을때 클릭할 때마다 클릭 지점과 거리를 표시하는 커스텀 오버레이 배열입니다.

      // 지도에 클릭 이벤트를 등록합니다
      if (this.points != null) {
        for (let i = 0; i < this.points.length; i++) {
          console.log(this.points[i]);
          var clickPosition = this.points[i];

          // 지도 클릭이벤트가 발생했는데 선을 그리고있는 상태가 아니면
          if (!drawingFlag) {
            // 상태를 true로, 선이 그리고있는 상태로 변경합니다
            drawingFlag = true;

            // 지도 위에 선이 표시되고 있다면 지도에서 제거합니다
            deleteClickLine();

            // 지도 위에 커스텀오버레이가 표시되고 있다면 지도에서 제거합니다
            deleteDistnce();

            // 지도 위에 선을 그리기 위해 클릭한 지점과 해당 지점의 거리정보가 표시되고 있다면 지도에서 제거합니다
            deleteCircleDot();

            // 클릭한 위치를 기준으로 선을 생성하고 지도위에 표시합니다
            clickLine = new kakao.maps.Polyline({
              map: map, // 선을 표시할 지도입니다
              path: [clickPosition], // 선을 구성하는 좌표 배열입니다 클릭한 위치를 넣어줍니다
              strokeWeight: 3, // 선의 두께입니다
              strokeColor: "#db4040", // 선의 색깔입니다
              strokeOpacity: 1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
              strokeStyle: "solid", // 선의 스타일입니다
            });

            // 선이 그려지고 있을 때 마우스 움직임에 따라 선이 그려질 위치를 표시할 선을 생성합니다

            // 클릭한 지점에 대한 정보를 지도에 표시합니다
            displayCircleDot(clickPosition, 0);
          } else {
            // 선이 그려지고 있는 상태이면

            // 그려지고 있는 선의 좌표 배열을 얻어옵니다
            var path = clickLine.getPath();

            // 좌표 배열에 클릭한 위치를 추가합니다
            path.push(clickPosition);

            // 다시 선에 좌표 배열을 설정하여 클릭 위치까지 선을 그리도록 설정합니다
            clickLine.setPath(path);

            var distance = Math.round(clickLine.getLength());
            displayCircleDot(clickPosition, distance);
          }
        }
      }

      // 클릭으로 그려진 선을 지도에서 제거하는 함수입니다
      function deleteClickLine() {
        if (clickLine) {
          clickLine.setMap(null);
          clickLine = null;
        }
      }

      // 그려지고 있는 선의 총거리 정보와
      // 선 그리가 종료됐을 때 선의 정보를 표시하는 커스텀 오버레이를 삭제하는 함수입니다
      function deleteDistnce() {
        if (distanceOverlay) {
          distanceOverlay.setMap(null);
          distanceOverlay = null;
        }
      }

      // 클릭 지점에 대한 정보 (동그라미와 클릭 지점까지의 총거리)를 지도에서 모두 제거하는 함수입니다
      function deleteCircleDot() {
        var i;

        for (i = 0; i < dots.length; i++) {
          if (dots[i].circle) {
            dots[i].circle.setMap(null);
          }

          if (dots[i].distance) {
            dots[i].distance.setMap(null);
          }
        }

        dots = [];
      }

      // 선이 그려지고 있는 상태일 때 지도를 클릭하면 호출하여
      // 클릭 지점에 대한 정보 (동그라미와 클릭 지점까지의 총거리)를 표출하는 함수입니다
      function displayCircleDot(position, distance) {
        // 클릭 지점을 표시할 빨간 동그라미 커스텀오버레이를 생성합니다
        var circleOverlay = new kakao.maps.CustomOverlay({
          content: '<span class="dot"></span>',
          position: position,
          zIndex: 1,
        });

        // 지도에 표시합니다
        circleOverlay.setMap(map);

        if (distance > 0) {
          // 클릭한 지점까지의 그려진 선의 총 거리를 표시할 커스텀 오버레이를 생성합니다
          var distanceOverlay = new kakao.maps.CustomOverlay({
            content:
              '<div class="dotOverlay">거리 <span class="number">' +
              distance +
              "</span>m</div>",
            position: position,
            yAnchor: 1,
            zIndex: 2,
          });

          // 지도에 표시합니다
          distanceOverlay.setMap(map);
        }

        // 배열에 추가합니다
        dots.push({ circle: circleOverlay, distance: distanceOverlay });
      }
    },
  },
};
</script>

<style></style>
