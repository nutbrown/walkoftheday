package com.ssafy.osan.global.dto;

public class Image {
    private int imageId;
    private String imagePath;
    private String orgFileName;
    private String fileName;

    public Image() {
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getOrgFileName() {
        return orgFileName;
    }

    public void setOrgFileName(String orgFileName) {
        this.orgFileName = orgFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", imagePath='" + imagePath + '\'' +
                ", orgFileName='" + orgFileName + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
