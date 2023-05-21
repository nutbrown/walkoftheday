package com.ssafy.osan.domain.route.controller;

import com.ssafy.osan.domain.route.dto.Route;
import com.ssafy.osan.domain.route.service.RouteService;
import com.ssafy.osan.domain.spot.dto.Spot;
import com.ssafy.osan.domain.spot.service.SpotService;
import com.ssafy.osan.global.dto.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private SpotService spotService;


    // 산책로 등록
    @PostMapping("")
    public ResponseEntity<?> writeRoute(@RequestPart("title") String title,
                                        @RequestPart("content") String content,
                                        @RequestPart("writer") String writer,
                                        @RequestPart("points") String points,
                                        @RequestPart("spots") String spots,
                                        @RequestPart("image") MultipartFile image) {

        // 산책로 객체 생성 후 값 넣어주기
        Route route = new Route();
        route.setTitle(title);
        route.setContent(content);
        route.setWriter(writer); // userId로 DB에 삽입
        route.setPoints(points);

        // 경유지 리스트 넣어주기
        List<Spot> list = new ArrayList<>();

        // String으로 들어온 spotsId 배열 처리
        String[] arr = spots.split(", ");

        for(String spotId : arr) {
            // spotId로 Spot 객체 가져오기
            Spot spot = spotService.detailSpot(Integer.parseInt(spotId));
            // 리스트에 넣어줌
            list.add(spot);
        }

        // List<Spot>을 Route 객체에 넣어줌
        route.setSpots(list);

        int result = routeService.writeRoute(route, image);

        if(result > 0) {
            return new ResponseEntity<Route>(route, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 산책로 리스트
    @GetMapping("")
    public ResponseEntity<?> routeList() {

        // 빈 값을 가져올 수도 있으니 제네릭 <?>
        List<Route> list = routeService.getRouteList();

        // 리스트가 비어있으면 no content 리턴
        if(list == null || list.size() == 0) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Route>>(list, HttpStatus.OK);
    }


    // 산책로 상세보기
    @GetMapping("/{routeId}")
    public ResponseEntity<Route> routeDetail(@PathVariable int routeId) {

        Route route = routeService.getRoute(routeId);

        return new ResponseEntity<Route>(route, HttpStatus.OK);
    }


    // 산책로 수정
    @PutMapping( "/{routeId}")
    public ResponseEntity<?> updateRoute(@PathVariable int routeId,
                                         @RequestPart("title") String title,
                                         @RequestPart("content") String content,
                                         @RequestPart("writer") String writer,
                                         @RequestPart("points") String points,
                                         @RequestPart("spots") String spots,
                                         @RequestPart("image") MultipartFile image) {

        // 산책로 객체 생성 후 값 넣어주기
        Route route = new Route();
        route.setRouteId(routeId);
        route.setTitle(title);
        route.setContent(content);
        route.setWriter(writer); // userId로 DB에 삽입
        route.setPoints(points);

        // 경유지 리스트 넣어주기
        List<Spot> list = new ArrayList<>();

        // String으로 들어온 spotsId 배열 처리
        String[] arr = spots.split(", ");

        for(String spotId : arr) {
            // spotId로 Spot 객체 가져오기
            Spot spot = spotService.detailSpot(Integer.parseInt(spotId));
            // 리스트에 넣어줌
            list.add(spot);
        }

        // List<Spot>을 Route 객체에 넣어줌
        route.setSpots(list);

        int result = routeService.updateRoute(route, image);

        if(result > 0) {
            return new ResponseEntity<Route>(route, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 산책로 삭제
    @DeleteMapping("/{routeId}")
    public ResponseEntity<?> deleteRoute(@PathVariable int routeId) {

        int result = routeService.deleteRoute(routeId);

        if(result > 0) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}