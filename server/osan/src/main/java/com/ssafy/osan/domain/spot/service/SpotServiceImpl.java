package com.ssafy.osan.domain.spot.service;

import com.ssafy.osan.domain.spot.dao.SpotDao;
import com.ssafy.osan.domain.spot.dto.Spot;
import com.ssafy.osan.global.dto.Image;
import com.ssafy.osan.global.service.FileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {

    // img 파일 처리를 위해
    @Autowired
    FileManagementService fileManagementService;

    @Autowired
    SpotDao spotDao;

    @Override
    public int writeSpot(Spot spot, MultipartFile file) {

        // imgId 가 0이면 이미지가 없는 것이다.
        spot.setImage(fileManagementService.uploadImage(file));

        return spotDao.insertSpot(spot);
    }

    @Override
    public List<Spot> showAll() {
        List<Spot> spotList = spotDao.selectAll();
        for(Spot spot : spotList) {
            spot.setImgFileName(fileManagementService.selectFileName(spot.getImage()));
        }
        return spotList;
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
