package com.example.service;

public interface PictureService {
    //上传文件
    String upload(byte[] bytes, Long fileSize, String extension);
    //上传文件并生成缩略图
    String uploadAndThumbnail(byte[] bytes, Long fileSize, String extension);
    //删除文件
    void delete(String fileUrl);
}
