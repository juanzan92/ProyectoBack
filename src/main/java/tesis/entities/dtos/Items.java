package tesis.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items extends ForDynamo {

    @JsonProperty("item_id")
    String itemId;

    @JsonProperty("category")
    String category;

    @JsonProperty("name")
    String name;


    public Items (){
        super("items", "item_id");
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
