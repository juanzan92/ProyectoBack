package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.Review;
import tesis.services.item.ReviewService;

import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/catalog/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping()
    public String createReview(@RequestBody Review review) throws JsonProcessingException {
        return reviewService.createReview(review);
    }

    @GetMapping()
    public Review getReview(@RequestParam @NotNull Map<String, String> review_id) throws JsonProcessingException {
        return reviewService.getReview(review_id);
    }

    @GetMapping("/get_all")
    public Review[] getAllReview() throws JsonProcessingException {
        return reviewService.getAllReview();
    }

    @GetMapping("/search")
    public Review[] searchReviews(@RequestParam Map<String, String> param) throws JsonProcessingException {
        return reviewService.searchReviews(param);
    }

    @PutMapping()
    public String updateReview(@RequestBody Review review) throws JsonProcessingException {
        return reviewService.updateReview(review);
    }

    @DeleteMapping()
    public String deleteReview(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return reviewService.deleteReview(param);
    }


}
