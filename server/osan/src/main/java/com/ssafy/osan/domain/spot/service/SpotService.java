package com.ssafy.osan.domain.spot.service;

import com.ssafy.osan.domain.spot.dto.Spot;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface SpotService {

    int writeSpot(Spot spot, MultipartFile file);
    List<Spot> showAll();
    Spot detailSpot(int spotId);
    int modifySpot(Spot spot, MultipartFile file);
    int deleteSpot(int spotId);

}
