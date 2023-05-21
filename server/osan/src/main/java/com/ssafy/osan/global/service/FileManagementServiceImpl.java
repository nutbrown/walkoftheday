package com.ssafy.osan.global.service;

import com.ssafy.osan.global.dao.ImageDao;
import com.ssafy.osan.global.dto.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Service
public class FileManagementServiceImpl implements FileManagementService {

    // resource 경로를 가져오기 위해 ResourceLoader를 주입 받는다.
    @Autowired
    ResourceLoader resLoader;

    @Autowired
    ImageDao imageDao;

    @Override
    public int uploadImage(MultipartFile file) {
        // 파일로 이미지 등록하기 이미지 등록 처리
        // 파일이 존재 한다면
        if (file != null && file.getSize() > 0) {
            Image image = new Image();

            // 파일을 저장할 위치 지정
            Resource res = resLoader.getResource("classpath:/static/upload");

            // 중복 방지를 위해 파일 이름 앞에 현재 시간 추가
            image.setFileName(System.currentTimeMillis() + "_" + file.getOriginalFilename());

            // Image 객체에 원본 파일 이름 저장
            image.setOrgFileName(file.getOriginalFilename());

            // 파일 경로 image 객체에 저장
            image.setImagePath(String.valueOf(res));

            // 파일 저장
            try {
                file.transferTo(new File(image.getFileName()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // 혜련이 귀여워
            imageDao.insertImage(image);
            return image.getImageId();
        }
        return 0;
    }

    @Override
    public String selectFileName(int imageId) {
        return imageDao.selectImage(imageId);
    }


}
