package tesis.entities.dtos.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tesis.entities.dtos.ForReportsSimpleRadar;

import java.util.ArrayList;

@Getter
@Setter
public class KvsVendor {

    @JsonProperty("username")
    private String username;

    @JsonProperty("graph01")    // Subscripciones por Categoria
            ArrayList<ForReportsSimpleRadar> graph01;

    @JsonProperty("graph02")    // Items vendidos por Categoria
            ArrayList<ForReportsSimpleRadar> graph02;

    public KvsVendor(){
        graph01 = new ArrayList<ForReportsSimpleRadar>();
        graph02 = new ArrayList<ForReportsSimpleRadar>();
    }

    public void updateGraph01(String category, Integer quantity) {
        boolean found = false;
        for (ForReportsSimpleRadar radar : graph01) {
            if (radar.getSubject() != null && radar.getSubject().contains(category)) {
                radar.setValueA(radar.getValueA() + quantity);
                found = true;
            }
        }
        if (!found ){
            graph01.add(new ForReportsSimpleRadar(category, quantity, quantity, quantity));
        }
    }


}
