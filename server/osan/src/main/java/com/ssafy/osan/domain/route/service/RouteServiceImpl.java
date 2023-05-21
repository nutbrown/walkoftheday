package com.ssafy.osan.domain.route.service;

import com.ssafy.osan.domain.route.dao.RouteDao;
import com.ssafy.osan.domain.route.dto.Route;
import com.ssafy.osan.global.service.FileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    public RouteDao routeDao;

    // img 파일 처리를 위해
    @Autowired
    FileManagementService fileManagementService;

    // 산책로 삽입
    @Override
    public int writeRoute(Route route, MultipartFile file) {

        // imageId를 반환해서 setImage
        // imgId 가 0이면 이미지가 없음
        route.setImage(fileManagementService.uploadImage(file));
        return routeDao.insertRoute(route);
    }

    // 산책로 전체 리스트
    @Override
    public List<Route> getRouteList() {
        return routeDao.selectAllRoute();
    }

    // 산책로 선택
    @Override
    public Route getRoute(int routeId) {
        return routeDao.selectRoute(routeId);
    }

    // 산책로 수정
    @Override
    public int updateRoute(Route route, MultipartFile file) {

        // imageId를 반환해서 setImage
        // imgId 가 0이면 이미지가 없음
        route.setImage(fileManagementService.uploadImage(file));
        return routeDao.updateRoute(route);
    }

    // 산책로 삭제
    @Override
    public int deleteRoute(int routeId) {
        return routeDao.deleteRoute(routeId);
    }
}
