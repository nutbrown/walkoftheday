package com.ssafy.osan.domain.spot.controller;

import com.ssafy.osan.domain.spot.dto.Spot;
import com.ssafy.osan.domain.spot.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;
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
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    //    Show Spot List
    @GetMapping("")
    public ResponseEntity<?> showSpot() {

        List<Spot> spotList = spotService.showAll();
        return new ResponseEntity<List<Spot>>(spotList, HttpStatus.OK);
    }

    //    show Spot Detail
    @GetMapping("/{spotId}")
    public ResponseEntity<?> detailSpot(int spotId) {
        return null;
    }

    //    modify Spot
    @PutMapping("")
    public ResponseEntity<?> putSpot(@RequestPart("spot") Spot spot,
                                     @RequestPart("image") MultipartFile image) {
        return null;
    }

    //    deleteSpot
    @DeleteMapping("/{spotId}")
    public ResponseEntity<?> deleteSpot(int spotId) {
        return null;
    }

}
