package tesis.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.dtos.entities.PocDTO;
import tesis.dtos.entities.Users;
import tesis.services.impl.PocService;
import tesis.services.impl.UsersService;

@RestController  // o @Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @PostMapping("/create_user_hc")
    @ResponseBody
    //public String createUser(@RequestParam("user_id") Long userId, @RequestParam("role") String role ) {
    public String createUserHC(
            @RequestBody Users newuser)
    {
        usersService.create_user_hc();
        return ("Usuario Creado (hard coded @ service)");
    }

    @PostMapping("/create_user")
    @ResponseBody
    //public String createUser(@RequestParam("user_id") Long userId, @RequestParam("role") String role ) {
    public String createUser(
            @RequestBody Users newuser)
    {
        usersService.create_user(newuser);
        return ("Usuario Creado (4real)");
    }

    @PostMapping("/create_user_fake")
    public Users createUserFake(@RequestBody Users newuserfake) {
        System.out.println("entró al post");
        //return pocService.getDTO(123);
        //usersService.createUser();
        return usersService.getUserHC(1234L);
    }
    /*
    public ResponseTransfer postResponseController(
            @RequestBody LoginForm loginForm) {
        return new ResponseTransfer("Thanks For Posting!!!");
    }
     */
}
