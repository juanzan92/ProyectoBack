package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import tesis.entities.dtos.ForDynamo;

import java.util.List;

public class Item extends ForDynamo {

    //private String tableName;
    //private String tablePrimary;

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

    @JsonProperty("status")
    private String status;

    @JsonProperty("description_short")
    private String description_short;

    @JsonProperty("description")
    private String description;

    List<Picture> pictures;
    List<Object> thumbnails;
    List<Object> attributes;
    List<Object> tags;

    @JsonProperty("date_created")
    private String date_created;

    @JsonProperty("last_updated")
    private String last_updated;

    public Item() {
        super("items", "item_id", "category", "Moda");
    }

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

    public String getDescription_short() {
        return description_short;
    }

    public String getDescription() {
        return description;
    }

    public String getDate_created() {
        return date_created;
    }

    public String getLast_updated() {
        return last_updated;
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

    public void setDescription_short(String description_short) {
        this.description_short = description_short;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
