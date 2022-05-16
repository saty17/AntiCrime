package com.example.anticrime.ui.ProfileSetting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileSettingViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProfileSettingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Profile Setting fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}