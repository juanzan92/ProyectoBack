package tesis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tesis.services.AmazonClient;

@RestController
@RequestMapping("/catalog/img")
public class BucketController {

    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

    @DeleteMapping("/delete")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
}