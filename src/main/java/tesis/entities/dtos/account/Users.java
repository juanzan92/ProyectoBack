package tesis.entities.dtos.account;

import tesis.entities.dtos.ForDynamo;

public class Users extends ForDynamo {

    String userId;
    String name;
    String userRole;

    public Users() {
        super("users", "userId");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


}
