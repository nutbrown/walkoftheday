package com.ssafy.osan.global.service;

import com.ssafy.osan.global.dao.ImageDao;
import com.ssafy.osan.global.dto.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileManagementServiceImpl implements FileManagementService{


    // resource 경로를 가져오기 위해 ResourceLoader를 주입 받는다.
    @Autowired
    ResourceLoader resLoader;

    @Autowired
    ImageDao imageDao;

    @Override
    public String uploadImage(MultipartFile file) {
        // 파일로 이미지 등록하기 이미지 등록 처리
        // 파일이 존재 한다면
        if(file != null && file.getSize() >0) {
            Image image = new Image();
            // 파일을 저장할 위치 지정
            Resource res = resLoader.getResource("classpath:/static/upload");



            int imageId = imageDao.insertImage(image);
        }



        return null;
    }
}
