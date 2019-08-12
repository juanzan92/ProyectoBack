package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subscription {

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("item_title")
    private String itemTitle ;

    @JsonProperty("username")
    private String username;

    @JsonProperty("price")
    private String price;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("subscribed_date")
    private String subscribedDate;
}
