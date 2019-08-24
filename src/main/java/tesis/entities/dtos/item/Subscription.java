package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subscription {

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("price")
    private String price;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("subscribed_date")
    private String subscribedDate;
}
