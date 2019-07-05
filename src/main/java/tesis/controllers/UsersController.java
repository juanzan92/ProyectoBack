package tesis.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.dtos.entities.PocDTO;
import tesis.dtos.entities.Users;
import tesis.services.impl.PocService;
import tesis.services.impl.UsersService;

@RestController  // o @Controller
@RequestMapping("/usersxxx/create_user")
public class UsersController {
    @Autowired
    UsersService usersService;

    @PostMapping("/response")
    @ResponseBody
    //public String createUser(@RequestParam("user_id") Long userId, @RequestParam("role") String role ) {
    public String createUser(
           @RequestBody Users newuser)
    {
        return ("Usuario Creado - fake");
    }

    /*
    public ResponseTransfer postResponseController(
            @RequestBody LoginForm loginForm) {
        return new ResponseTransfer("Thanks For Posting!!!");
    }
     */
}
