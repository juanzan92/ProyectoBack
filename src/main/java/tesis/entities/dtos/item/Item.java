package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tesis.entities.enums.item.ItemStatus;

import java.util.Date;
import java.util.List;

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
    private int initialStock;

    @JsonProperty("stock")
    private int stock;

    @JsonProperty("item_status")
    private ItemStatus status;

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
    private Date dateCreated;

    @JsonProperty("last_updated")
    private Date lastUpdated;

    @JsonProperty("end_date")
    private Date endDate;

    @JsonProperty("dimensions")
    private Dimensions dimensions;

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Item setDimensions(Dimensions dimentions) {
        this.dimensions = dimentions;
        return this;
    }
}
