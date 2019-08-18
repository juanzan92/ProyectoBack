package tesis.entities.dtos.home;

import com.fasterxml.jackson.annotation.JsonProperty;
import tesis.entities.dtos.home.ItemHome;

public class ItemHurryUp extends ItemHome {

    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty("url_to_search")
    private String urlToSearch;

}
