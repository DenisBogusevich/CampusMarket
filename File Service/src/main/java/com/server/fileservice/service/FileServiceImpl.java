package com.server.fileservice.service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    @Value("${minio.bucketName}")
    private String bucketName;

    private final MinioClient minioClient;

    @SneakyThrows
    @Override
    public void save(MultipartFile file, String name) {
        minioClient.putObject(PutObjectArgs
                .builder()
                .bucket(bucketName)
                .object(name)
                .stream(file.getInputStream(), file.getSize(), -1)
                .build());

    }

    @SneakyThrows
    @Override
    public InputStream findByName(String name) {

        return minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(name)
                        .build());
    }


    @SneakyThrows
    @Override
    public void delete(String fileName) {

        minioClient.removeObject(
                RemoveObjectArgs.builder().bucket(bucketName).object(fileName).build());



    }
}
