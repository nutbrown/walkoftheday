package com.ssafy.osan.domain.spot.service;

import com.ssafy.osan.domain.spot.dao.SpotDao;
import com.ssafy.osan.domain.spot.dto.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {

    @Autowired
    SpotDao spotDao;

    @Override
    public int writeSpot(Spot spot, MultipartFile image) {
        return 0;
    }

    @Override
    public List<Spot> showAll() {
        return null;
    }

    @Override
    public Spot detailSpot(int spotId) {
        return null;
    }

    @Override
    public int modifySpot(Spot spot, MultipartFile image) {
        return 0;
    }

    @Override
    public int deleteSpot(int spotId) {
        return 0;
    }
}
