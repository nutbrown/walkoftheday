package com.ssafy.osan.global.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileManagementService {

    // spot route 이미지를 저장하고 저장된 경로를 반환하는 메서드
    public int uploadImage(MultipartFile file);

    public String selectFileName(int imageId);

}
