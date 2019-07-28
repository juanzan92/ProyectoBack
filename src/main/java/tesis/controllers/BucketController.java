package tesis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tesis.services.AmazonClient;

@RestController
@RequestMapping("/catalog/img")
public class BucketController {

    @Autowired
    private AmazonClient amazonClient;

    @PostMapping("/upload")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return amazonClient.uploadFile(file);
    }

    @DeleteMapping("/delete")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
}