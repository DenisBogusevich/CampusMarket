package com.server.fileservice.logic;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileService {
    void save(MultipartFile file, String name);

    InputStream findByName(String name);

    void delete(String fileName);

}
