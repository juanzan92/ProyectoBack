package tesis.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tesis.dtos.entities.PocDTO;
import tesis.services.impl.PocService;
import tesis.services.impl.UsersService;

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/users/create_user")
    public String createUser(@RequestParam("user_id") Long userId, @RequestParam("role") String role) {
        //return usersService.getDTO(1);
        return userId+role;
        //return "has hecho una peticion get";
    }

}
