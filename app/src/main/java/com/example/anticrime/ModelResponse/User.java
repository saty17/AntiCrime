package com.example.anticrime.ModelResponse;

public class User {

    int Id;
    String UserName,Email;

    public User(int id, String userName, String email) {
        this.Id = id;
        this.UserName = userName;
        this.Email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
