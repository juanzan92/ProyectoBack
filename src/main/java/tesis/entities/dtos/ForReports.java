package tesis.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForReports {
    //@JsonProperty("data")
    //String data;
    @JsonProperty("subject")
    String subject;

    @JsonProperty("A")
    Integer A;

    @JsonProperty("B")
    Integer B;

    @JsonProperty("fullMark")
    Integer fullMark;

}
