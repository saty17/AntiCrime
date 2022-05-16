package com.example.anticrime.ModelResponse;

public class MissingFetch {

    int Id;
    String Name, Age, LastSeen, Details, ImageTitle, ImageLocation, UserName, Status;

    public MissingFetch(int id, String name, String age, String lastSeen, String details, String imageTitle, String imageLocation, String userName, String status) {
        Id = id;
        Name = name;
        Age = age;
        LastSeen = lastSeen;
        Details = details;
        ImageTitle = imageTitle;
        ImageLocation = imageLocation;
        UserName = userName;
        Status =status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getLastSeen() {
        return LastSeen;
    }

    public void setLastSeen(String lastSeen) {
        LastSeen = lastSeen;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getImageTitle() {
        return ImageTitle;
    }

    public void setImageTitle(String imageTitle) {
        ImageTitle = imageTitle;
    }

    public String getImageLocation() {
        return ImageLocation;
    }

    public void setImageLocation(String imageLocation) {
        ImageLocation = imageLocation;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
