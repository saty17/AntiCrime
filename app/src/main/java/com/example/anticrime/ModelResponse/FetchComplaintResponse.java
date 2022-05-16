package com.example.anticrime.ModelResponse;

import java.util.List;

public class FetchComplaintResponse {

    List<ComplaintFetch> complaintList;
    String error;

    public FetchComplaintResponse(List<ComplaintFetch> complaintList, String error) {
        this.complaintList = complaintList;
        this.error = error;
    }

    public List<ComplaintFetch> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<ComplaintFetch> complaintList) {
        this.complaintList = complaintList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
