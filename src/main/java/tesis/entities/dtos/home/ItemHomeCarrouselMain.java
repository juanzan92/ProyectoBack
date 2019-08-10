package tesis.entities.dtos.home;

import com.fasterxml.jackson.annotation.JsonProperty;
import tesis.entities.dtos.home.ItemHome;

public class ItemHomeCarrouselMain extends ItemHome {

    @JsonProperty("price")
    private String price;

    @JsonProperty("url_redirection")
    private String urlRedirection;

    @JsonProperty("brand")
    private String brand;
}
