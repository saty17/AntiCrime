package com.example.anticrime.ModelResponse;

public class CrimeFetch {

    int Id;
    String CrimeStreet, CrimeCity, CrimePincode, CrimeDetails, ImageTitle, ImageLocation, UserName, Status;

    public CrimeFetch(int id, String crimeStreet, String crimeCity, String crimePincode, String crimeDetails, String imageTitle, String imageLocation, String userName, String status) {
        Id = id;
        CrimeStreet = crimeStreet;
        CrimeCity = crimeCity;
        CrimePincode = crimePincode;
        CrimeDetails = crimeDetails;
        ImageTitle = imageTitle;
        ImageLocation = imageLocation;
        UserName = userName;
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCrimeStreet() {
        return CrimeStreet;
    }

    public void setCrimeStreet(String crimeStreet) {
        CrimeStreet = crimeStreet;
    }

    public String getCrimeCity() {
        return CrimeCity;
    }

    public void setCrimeCity(String crimeCity) {
        CrimeCity = crimeCity;
    }

    public String getCrimePincode() {
        return CrimePincode;
    }

    public void setCrimePincode(String crimePincode) {
        CrimePincode = crimePincode;
    }

    public String getCrimeDetails() {
        return CrimeDetails;
    }

    public void setCrimeDetails(String crimeDetails) {
        CrimeDetails = crimeDetails;
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
