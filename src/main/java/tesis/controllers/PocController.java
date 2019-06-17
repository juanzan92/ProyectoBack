package tesis.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tesis.dtos.entities.PocDTO;
import tesis.services.impl.PocService;


import java.util.HashMap;
import java.util.Map;


@RestController
public class PocController {
    @Autowired
    PocService pocService;

    @GetMapping("/poc/string")
    public String hola() {
        return "has hecho una peticion get";
    }

    @GetMapping("/poc/map")
    public Map<String, String> sayHello() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("aa", "bb");
        return map;
    }

    @GetMapping("/poc/dynamo")
    public String dynamo()
    {
        return pocService.dynamo();
    }

    @GetMapping("/poc/entity")
    public PocDTO pocEntity() {
        PocDTO poc = new PocDTO();
        poc.setDescription("prueba_de_poc");
        poc.setValue1(1);
        return poc;
    }

    @GetMapping("/poc/service")
    public PocDTO pocService() {
        return pocService.getDTO(123);
    }

    @PostMapping("/poc/post")
    public PocDTO addMemberV1(@RequestBody Object member) {
        System.out.println("entró al post");
        return pocService.getDTO(123);
    }
}
