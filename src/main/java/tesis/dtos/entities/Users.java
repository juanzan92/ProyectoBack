package tesis.dtos.entities;

public class Users {
    Long userId;
    String name;
    String userRole;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Users(Long userId, String name, String userRole) {
        this.userId = userId;
        this.name = name;
        this.userRole = userRole;
    }
    public Users(Long userId, String userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }
}
