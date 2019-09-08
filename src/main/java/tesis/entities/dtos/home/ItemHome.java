package tesis.entities.dtos.home;

import com.fasterxml.jackson.annotation.JsonProperty;
import tesis.entities.dtos.item.Picture;

import java.util.List;

public class ItemHome {

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("tag")
    private String tag;

    @JsonProperty("pictures")
    List<Picture> pictures;

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

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
