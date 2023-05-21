package com.ssafy.osan.domain.route.dao;

import com.ssafy.osan.domain.route.dto.Route;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RouteDao {
    int insertRoute(Route route);

    List<Route> selectAllRoute();

    Route selectRoute(int routeId);

    int updateRoute(Route route);

    int deleteRoute(int routeId);

}
