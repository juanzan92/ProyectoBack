package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemHomeHurryUp extends ItemHome {

    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty("url_to_search")
    private String url_to_search;

}
