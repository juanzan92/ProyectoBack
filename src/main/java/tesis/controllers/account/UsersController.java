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
    public User getUser(@RequestParam Map<String, String>  username) throws JsonProcessingException {
        return usersService.getUser(username);
    }

    @GetMapping("/get_all")
    public User[] getAllUser() throws JsonProcessingException {
        return usersService.getAllUser();
    }

    @GetMapping("/vendors")
<<<<<<< HEAD
    public Vendor getVendor(@RequestParam Map<String, String> username) throws JsonProcessingException {
        return usersService.getVendor(username);
=======
    public Vendor getVendor(@RequestParam Map<String, String> param) throws JsonProcessingException {
        return usersService.getVendor(param);
>>>>>>> d3a19691bd77038481b30f0c86ed5194232ed7e4
    }

    @PostMapping("/vendors")
    public String createVendor(@RequestBody Vendor newVendor) throws JsonProcessingException {
        return usersService.createVendorUser(newVendor);
    }

    @GetMapping("/vendors/get_all")
    public Vendor[] getAllVendor() throws JsonProcessingException {
        return usersService.getAllVendor();
    }
}

