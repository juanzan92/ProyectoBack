package tesis.controllers.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.account.Users;

import tesis.services.account.UserService;

@RestController
public class UsersController {
    @Autowired
    UserService usersService;

    @PostMapping("/account/users/create_user")
    public String createUser(@RequestBody Users newUser) {
        return  usersService.createUser(newUser);
   }

   /* @GetMapping("/account/users/get_user/{user_id}")
    public Users get_user_by_id() {
        return usersService.get_user_by_id("1111");
    }*/
}
