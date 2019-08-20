package tesis.controllers.account;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.services.account.UserService;

import javax.validation.constraints.NotNull;
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
    public Vendor getVendor(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return usersService.getVendor(param);
    }
}

