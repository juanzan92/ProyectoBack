package tesis.controllers.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tesis.services.item.BucketService;

@CrossOrigin(allowedHeaders = "*",maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/catalog/img/{id}")
public class BucketController {

    @Autowired
    private BucketService bucketService;

    @PostMapping()
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return bucketService.uploadFile(file);
    }

    @DeleteMapping()
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return bucketService.deleteFileFromS3Bucket(fileUrl);
    }
}