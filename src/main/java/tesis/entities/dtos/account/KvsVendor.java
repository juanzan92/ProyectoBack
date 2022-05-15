package tesis.entities.dtos.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tesis.entities.dtos.ForBarReport;
import tesis.entities.dtos.ForReportsSimpleRadar;

import java.util.ArrayList;

@Getter
@Setter
public class KvsVendor {

    @JsonProperty("username")
    private String username;

    @JsonProperty("graph_01")    // Subscripciones por Categoria
            ArrayList<ForReportsSimpleRadar> graph01;

    @JsonProperty("graph_02")    // Items vendidos por Categoria
            ArrayList<ForReportsSimpleRadar> graph02;

    @JsonProperty("graph_03")    // Items vendidos por mes
            ArrayList<ForBarReport> graph03;

    public KvsVendor() {
        graph01 = new ArrayList<ForReportsSimpleRadar>();
        graph02 = new ArrayList<ForReportsSimpleRadar>();
        graph03 = new ArrayList<ForBarReport>();
    }

    public void updateGraphSimpleRadar(String category, Integer quantity, ArrayList<ForReportsSimpleRadar> graph) {
        boolean found = false;
        for (ForReportsSimpleRadar radar : graph) {
            if (radar.getSubject() != null && radar.getSubject().contains(category)) {
                radar.setValueA(radar.getValueA() + quantity);
                radar.setValueB(radar.getValueA());
                radar.setFullMark(radar.getValueA());
                found = true;
            }
        }
        if (!found) {
            graph.add(new ForReportsSimpleRadar(category, quantity, quantity, quantity));
        }
    }
}
