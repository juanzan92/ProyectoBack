package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tesis.entities.enums.item.ItemStatus;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class Item {

    @JsonProperty("title")
    private String title;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("category")
    private String category;

    @JsonProperty("vendor_username")
    private String vendorUsername;

    @JsonProperty("initial_price")
    private float initialPrice;

    @JsonProperty("actual_price")
    private float actualPrice;

    @JsonProperty("in_discount")
    private boolean inDiscount;

    @JsonProperty("initial_stock")
    private float initialStock;

    @JsonProperty("stock")
    private int stock;

    @JsonProperty("item_status")
    ItemStatus status;

    @JsonProperty("description_short")
    private String descriptionShort;

    @JsonProperty("description")
    private String description;

    @JsonProperty("pictures")
    List<Picture> pictures;

    @JsonProperty("thumbnails")
    List<Object> thumbnails;

    @JsonProperty("attributes")
    List<Object> attributes;

    @JsonProperty("tags")
    List<Object> tags;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("dimensions")
    private Dimensions dimensions;

<<<<<<< HEAD
    public Item setDimentions(Map<String, Float> dimentions) {
        this.dimentions = dimentions;
=======
    public Dimensions getDimensions() {
        return dimensions;
    }

    public Item setDimensions(Dimensions dimentions) {
        this.dimensions = dimentions;
>>>>>>> f3ac6198e1f5e6be4abe49887c456c3424c028c1
        return this;
    }
}
