package com.ssafy.osan.domain.route.service;

import com.ssafy.osan.domain.route.dto.Route;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RouteService {

    int writeRoute(Route route, MultipartFile image);

    List<Route> getRouteList();

    Route getRoute(int routeId);

    int updateRoute(Route route, MultipartFile image);

    int deleteRoute(int routeId);
}
