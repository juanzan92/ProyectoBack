package tesis.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.dtos.entities.PocDTO;
import tesis.dtos.entities.Users;
import tesis.services.impl.PocService;
import tesis.services.impl.UsersService;

@RestController  // o @Controller
@RequestMapping("/users/")
public class UsersController2 {
    @Autowired
    UsersService usersService;

    @PostMapping("/create_user")
    @ResponseBody
    //public String createUser(@RequestParam("user_id") Long userId, @RequestParam("role") String role ) {
    public String createUser(
            @RequestBody Users newuser)
    {
        return ("Usuario Creado - fake");
    }

    @PostMapping("/create_user_fake")
    public Users createUser(@RequestBody Object member) {
        System.out.println("entró al post");
        //return pocService.getDTO(123);
        return usersService.getUser(1234L);
    }
    /*
    public ResponseTransfer postResponseController(
            @RequestBody LoginForm loginForm) {
        return new ResponseTransfer("Thanks For Posting!!!");
    }
     */
}
