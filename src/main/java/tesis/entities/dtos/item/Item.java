package tesis.entities.dtos.item;

import tesis.entities.dtos.ForDynamo;

import java.util.List;

public class Item extends ForDynamo {
    private String tableName;
    private String tablePrimary;
    private String title;
    private String category;
    private String vendorName;
    private float initialPrice;
    private float actualPrice;
    private boolean inDiscount;
    private float initialStock;
    private int stock;
    private String status;
    private String description_short;
    private String description;
    List<Picture> pictures;
    List<Object> thumbnails;
    List<Object> attributes;
    List<Object> tags;
    private String date_created;
    private String last_updated;

    public Item() {
        super("", "");
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTablePrimary() {
        return tablePrimary;
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

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setTablePrimary(String tablePrimary) {
        this.tablePrimary = tablePrimary;
    }

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
