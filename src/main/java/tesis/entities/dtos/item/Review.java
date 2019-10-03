package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {

    @JsonProperty("review_id")
    private String reviewId;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("review_score")
    private String reviewScore;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(String reviewScore) {
        this.reviewScore = reviewScore;
    }
}
