package com.ssafy.osan.domain.spot.controller;

import com.ssafy.osan.domain.spot.dto.Spot;
import com.ssafy.osan.domain.spot.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/spot")
public class SpotController {

    @Autowired
    SpotService spotService;

    //  Spot Create
    @PostMapping("")
    public ResponseEntity<?> createSpot(@RequestPart("spotName") String spotName,
                                        @RequestPart("content") String content,
                                        @RequestPart("writer") String writer,
                                        @RequestPart("spotLatlng") String spotLatLng,
                                        @RequestPart("image") MultipartFile image) {

        Spot spot = new Spot();
        spot.setSpotName(spotName);
        spot.setContent(content);
        spot.setWriter(writer);
        spot.setSpotLatlng(spotLatLng);

        int result = spotService.writeSpot(spot, image);

        // 정상 등록되지 않았을 때
        if (result == 0) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        // 정산 등록
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    //    Show Spot List
    @GetMapping("")
    public ResponseEntity<?> showSpot() {

        List<Spot> spotList = spotService.showAll();

        // SpotList가 없다면
        if (spotList == null || spotList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(spotList, HttpStatus.OK);
    }

    //    show Spot Detail
    @GetMapping("/{spotId}")
    public ResponseEntity<?> detailSpot(@PathVariable int spotId) {

        Spot spot = spotService.detailSpot(spotId);
        if (spot == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(spot, HttpStatus.OK);
    }

    //    modify Spot
    @PutMapping("/{spotId}")
    public ResponseEntity<?> putSpot(@PathVariable int spotId,
                                     @RequestPart("spotName") String spotName,
                                     @RequestPart("content") String content,
                                     @RequestPart("writer") String writer,
                                     @RequestPart("spotLatlng") String spotLatLng,
                                     @RequestPart("image") MultipartFile image) {

        Spot spot = new Spot();
        spot.setSpotId(spotId);
        spot.setSpotName(spotName);
        spot.setContent(content);
        spot.setWriter(writer);
        spot.setSpotLatlng(spotLatLng);

        int result = spotService.modifySpot(spot, image);

        // 정상 등록되지 않았을 때
        if (result == 0) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        // 정산 등록
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    //    deleteSpot
    @DeleteMapping("/{spotId}")
    public ResponseEntity<?> deleteSpot(@PathVariable int spotId) {


        int result = spotService.deleteSpot(spotId);

        // 삭제가 안될 때
        if (result == 0) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
