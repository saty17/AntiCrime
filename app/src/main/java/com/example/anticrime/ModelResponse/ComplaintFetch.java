package com.example.anticrime.ModelResponse;

public class ComplaintFetch {

    int Id;
    String CompAddress, CompCity, CompPincode, CompSubject, Complaint, UserName, Status;

    public ComplaintFetch(int id, String compAddress, String compCity, String compPincode, String compSubject, String complaint, String userName, String status) {
        Id = id;
        CompAddress = compAddress;
        CompCity = compCity;
        CompPincode = compPincode;
        CompSubject = compSubject;
        Complaint = complaint;
        UserName = userName;
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCompAddress() {
        return CompAddress;
    }

    public void setCompAddress(String compAddress) {
        CompAddress = compAddress;
    }

    public String getCompCity() {
        return CompCity;
    }

    public void setCompCity(String compCity) {
        CompCity = compCity;
    }

    public String getCompPincode() {
        return CompPincode;
    }

    public void setCompPincode(String compPincode) {
        CompPincode = compPincode;
    }

    public String getCompSubject() {
        return CompSubject;
    }

    public void setCompSubject(String compSubject) {
        CompSubject = compSubject;
    }

    public String getComplaint() {
        return Complaint;
    }

    public void setComplaint(String complaint) {
        Complaint = complaint;
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
