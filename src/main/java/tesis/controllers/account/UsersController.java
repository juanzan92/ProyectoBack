package tesis.controllers.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.account.User;

import tesis.services.account.UserService;

@RestController
public class UsersController {
    @Autowired
    UserService usersService;

    @PostMapping("/account/users/create_user")
    public Object createUser(@RequestBody User newUser) {
        return  usersService.createUser(newUser);
   }
}
