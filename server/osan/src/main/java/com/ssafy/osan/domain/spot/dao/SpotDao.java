package com.ssafy.osan.domain.spot.dao;

import com.ssafy.osan.domain.spot.dto.Spot;

import java.util.List;

public interface SpotDao {

    // insert Spot
    int insertSpot(Spot spot);

    // view Spot List
    List<Spot> selectAll();

    // view Spot detail
    Spot selectSpot(int SpotId);

    // modify Spot
    int updateSpot(Spot spot);

    // delete Spot
    int deleteSpot(int SpotId);

    // handle image
    int insertImage();
}
