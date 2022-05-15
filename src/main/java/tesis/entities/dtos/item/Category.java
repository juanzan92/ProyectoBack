package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Category {

    @JsonProperty("category_id")
    private String categoryId;

    @JsonProperty("category_name")
    private String categoryName;

    @JsonProperty("picture")
    private String categoryPicture;

    @JsonProperty("total_items_in_category")
    private String totalItemsInCategory;


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryPicture() {
        return categoryPicture;
    }

    public void setCategoryPicture(String categoryPicture) {
        this.categoryPicture = categoryPicture;
    }

    public String getTotalItemsInCategory() {
        return totalItemsInCategory;
    }

    public void setTotalItemsInCategory(String totalItemsInCategory) {
        this.totalItemsInCategory = totalItemsInCategory;
    }
}
