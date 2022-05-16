package com.example.anticrime.ui.CrimeStatus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CrimeStatusViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CrimeStatusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Crime Status fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}