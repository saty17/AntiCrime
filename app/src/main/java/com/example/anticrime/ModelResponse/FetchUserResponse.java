package com.example.anticrime.ModelResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchUserResponse {

//    int Id;
//    String Name, Details, ImageLocation;
//
//    public FetchUserResponse(int id, String name, String details, String imageLocation) {
//        Id = id;
//        Name = name;
//        Details = details;
//        ImageLocation = imageLocation;
//    }
//
//    public int getId() {
//        return Id;
//    }
//
//    public void setId(int id) {
//        Id = id;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }
//
//    public String getDetails() {
//        return Details;
//    }
//
//    public void setDetails(String details) {
//        Details = details;
//    }
//
//    public String getImageLocation() {
//        return ImageLocation;
//    }
//
//    public void setImageLocation(String imageLocation) {
//        ImageLocation = imageLocation;
//    }

        @SerializedName("users")
        List<User> userList;
    String error;

    public FetchUserResponse(List<User> userList, String error) {
        this.userList = userList;
        this.error = error;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
