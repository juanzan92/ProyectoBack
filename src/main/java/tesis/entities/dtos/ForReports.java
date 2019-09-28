package tesis.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ForReports {
    //@JsonProperty("data")
    //String data;
    @JsonProperty("subject")
    String subject;

    @JsonProperty("A")
    Integer valueA;

    @JsonProperty("B")
    Integer valueB;

    @JsonProperty("fullMark")
    Integer fullMark;

}
