package tesis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tesis.dtos.entities.PocDTO;
import org.springframework.stereotype.Service;
import tesis.services.interfaces.PocInterface;

@Service
public class PocService implements PocInterface {
    @Autowired
    PocDynamoService pocDynamoService;

    public PocDTO getDTO(int id){
        PocDTO dto = new PocDTO();
        dto.setDescription("dto de prueba"+ id);
        dto.setValue1(44444);
        return dto;
    }
}
