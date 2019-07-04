package tesis.services.impl;


import org.springframework.stereotype.Service;
import tesis.dtos.entities.PocDTO;
import tesis.dtos.entities.Users;

@Service
public class UsersService {

    public Users createUser(Long id,String role){
        Users user = new Users(id,role);
        return user;
    }

}
