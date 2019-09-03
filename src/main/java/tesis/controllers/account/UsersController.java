package tesis.controllers.account;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.services.account.UserService;

import java.util.Map;

@RestController
@RequestMapping("/account/users")
public class UsersController {
    @Autowired
    UserService usersService;

    @PostMapping()
    public String createUser(@RequestBody User newUser) throws JsonProcessingException {
        return usersService.createUser(newUser);
    }

    @GetMapping()
    public User getUser(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return usersService.getUser(param);
    }

    @GetMapping("/get_all")
    public User[] getAllUser() throws JsonProcessingException {
        return usersService.getAllUser();
    }

    @GetMapping()
    public Vendor getVendor(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return usersService.getVendor(param);
    }

    @PostMapping()
    public String createVendor(@RequestBody Vendor newVendor) throws JsonProcessingException {
        return usersService.createVendor(newVendor);
    }
}

