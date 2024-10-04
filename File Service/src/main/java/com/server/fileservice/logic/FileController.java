package com.server.fileservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/files")
public class FileController {

    private final FileService fileService;

    @GetMapping("/get/{fileName}")
    public ResponseEntity<InputStreamResource> getImage( @PathVariable String fileName) {

            InputStream imageStream = fileService.findByName(fileName);
            InputStreamResource resource = new InputStreamResource(imageStream);

            // Return the image as a response entity with headers
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline;") // inline will display in browser
                    .contentType(MediaType.IMAGE_PNG) // Set content type to image/png
                    .body(resource);


    }


}
