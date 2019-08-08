package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class ItemHomeCarrouselMain extends ItemHome {

    @JsonProperty("price")
    private String price;

    @JsonProperty("url_redirection")
    private String urlRedirection;

    @JsonProperty("brand")
    private String brand;
}
