package com.ssafy.osan.global.dao;

import com.ssafy.osan.global.dto.Image;

public interface ImageDao {
    // handle image
    int insertImage(Image image);

    String selectImage(int imageId);
}
