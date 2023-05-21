package com.ssafy.osan.domain.spot.controller;

import com.ssafy.osan.domain.spot.dto.Spot;
import com.ssafy.osan.domain.spot.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/spot")
public class SpotController {

    @Autowired
    SpotService spotService;

//  Spot Create
    @PostMapping("")
    public ResponseEntity<?> writeSpot(@RequestPart("spot") Spot spot,
                                       @RequestPart("image")MultipartFile image) {


        int result = spotService.writeSpot(spot,image);
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

//    Show Spot List
    @GetMapping("")
    public ResponseEntity<?> showSpot() {
        return null;
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
