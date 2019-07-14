package tesis.dtos.entities;

public class Users {
    String tableName = "users";
    String tablePrimary = "userId";
    String userId;
    String name;
    String userRole;

//
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
//
    public String getTablePrimary() {
        return tablePrimary;
    }

    public void setTablePrimary(String tablePrimary) {
        this.tablePrimary = tablePrimary;
    }
//
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
//
    public Users (String userId, String name, String userRole) {
        this.userId = userId;
        this.name = name;
        this.userRole = userRole;
    }

    /*public Users(String userId, String name, String userRole) {
        this.userId = userId;
        this.name = name;
        this.userRole = userRole;
        this.TableName = "users";
        this.TablePrimary = "userId";
    }*/
/*
    public Users(String name, String userRole) {
        this.name = name;
        this.userRole = userRole;
        this.TableName = "users";
        this.TablePrimary = "userId";
    }*/
    // alt + insert = Generate - ie: constructor

    public Users() { }
}
