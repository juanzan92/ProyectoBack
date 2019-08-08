package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ItemHome {

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("tag")
    private String tag;

    @JsonProperty("picture")
    private String picture;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
