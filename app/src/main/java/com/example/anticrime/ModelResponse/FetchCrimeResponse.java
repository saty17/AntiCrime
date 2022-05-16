package com.example.anticrime.ModelResponse;

import java.util.List;

public class FetchCrimeResponse {

    List<CrimeFetch> crimeList;
    String error;

    public FetchCrimeResponse(List<CrimeFetch> crimeFetchList, String error) {
        this.crimeList = crimeFetchList;
        this.error = error;
    }

    public List<CrimeFetch> getCrimeFetchList() {
        return crimeList;
    }

    public void setCrimeFetchList(List<CrimeFetch> crimeFetchList) {
        this.crimeList = crimeFetchList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
