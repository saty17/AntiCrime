package com.example.anticrime.ModelResponse;

import java.util.List;

public class FetchMissingResponse {

    //@SerializedName("missing")
    List<MissingFetch> missingList;
    String error;

    public FetchMissingResponse(List<MissingFetch> missingList, String error) {
        this.missingList = missingList;
        this.error = error;
    }

    public List<MissingFetch> getMissingList() {
        return missingList;
    }

    public void setMissingList(List<MissingFetch> missingList) {
        this.missingList = missingList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
