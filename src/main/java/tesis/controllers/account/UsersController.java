package tesis.controllers.account;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.account.User;

import tesis.entities.dtos.mercadopago.Vendor;
import tesis.services.account.UserService;

@RestController
public class UsersController {
    @Autowired
    UserService usersService;

    @PostMapping("/account/users/create_user")
    public String createUser(@RequestBody User newUser) throws JsonProcessingException {
        return usersService.createUser(newUser);
    }

    @GetMapping("/account/users/get_vendor")
    public Vendor getVendor(@RequestParam String username) throws JsonProcessingException {
        return usersService.getVendor(username);
    }
}

