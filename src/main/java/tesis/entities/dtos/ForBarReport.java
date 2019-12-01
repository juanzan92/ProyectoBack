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
public class ForBarReport {

    @JsonProperty("month")
    Integer month;

    @JsonProperty("quantity")
    Integer quantity;

    @JsonProperty("income")
    Double income;
}
