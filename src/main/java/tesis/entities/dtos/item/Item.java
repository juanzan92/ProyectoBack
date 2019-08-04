package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Item {

    @JsonProperty("title")
    private String title;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("category")
    private String category;

    @JsonProperty("vendor_name")
    private String vendorName;

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
    private String status;

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

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getInitialPrice() {
        return initialPrice;
    }

    public float getActualPrice() {
        return actualPrice;
    }

    public boolean getInDiscount() {
        return inDiscount;
    }

    public float getInitialStock() {
        return initialStock;
    }

    public int getStock() {
        return stock;
    }

    public String getStatus() {
        return status;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public String getDescription() {
        return description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    // Setter Methods

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInitialPrice(float initialPrice) {
        this.initialPrice = initialPrice;
    }

    public void setActualPrice(float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public void setInDiscount(boolean inDiscount) {
        this.inDiscount = inDiscount;
    }

    public void setInitialStock(float initialStock) {
        this.initialStock = initialStock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public boolean isInDiscount() {
        return inDiscount;
    }
}
