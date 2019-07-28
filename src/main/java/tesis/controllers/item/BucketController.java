package tesis.controllers.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tesis.services.item.BucketService;

@RestController
@RequestMapping("/catalog/img")
public class BucketController {

    @Autowired
    private BucketService bucketService;

    @PostMapping("/upload")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return bucketService.uploadFile(file);
    }

    @DeleteMapping("/delete")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return bucketService.deleteFileFromS3Bucket(fileUrl);
    }
}