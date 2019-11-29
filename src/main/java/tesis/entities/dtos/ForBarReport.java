package tesis.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class ForBarReport {

    @JsonProperty("month")
    Integer month;

    @JsonProperty("quantity")
    Integer quantity;

    public ForBarReport(Integer month, Integer quantity){
        this.month = month;
        this.quantity = quantity;
    }
}
