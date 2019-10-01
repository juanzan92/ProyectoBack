package tesis.entities.dtos.account;

import com.amazonaws.services.route53.model.DelegationSet;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tesis.entities.dtos.ForReportsSimpleRadar;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class KvsVendor {

    @JsonProperty("username")
    private String username;

    @JsonProperty("graph01")    // Subscripciones por Categoria
    ArrayList<ForReportsSimpleRadar> graph01;

    @JsonProperty("graph02")    // Items vendidos por Categoria
    ArrayList<ForReportsSimpleRadar> graph02;

    ForReportsSimpleRadar[] graph03;

    public void updateGraph01(String category, Integer quantity) {
        if(this.graph01.){

        }
    }


}
