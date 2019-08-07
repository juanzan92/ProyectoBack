package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Category {

    @JsonProperty("category_id")
    public String categoryId;

    @JsonProperty("category_name")
    public String categoryName;

    @JsonProperty("picture")
    public String categoryPicture;

    @JsonProperty("tags")
    List<Object> cateogrytags;

    @JsonProperty("total_items_in_category")
    public String totalItemsInCategory;


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
