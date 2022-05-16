package com.example.anticrime.ui.ProfileSetting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.anticrime.ModelResponse.UpdatePassResponse;
import com.example.anticrime.R;
import com.example.anticrime.RetrofitClient;
import com.example.anticrime.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileSettingFragment extends Fragment implements View.OnClickListener {

    TextView etname,etemail;
    EditText currentPass,newPass;
    SharedPrefManager sharedPrefManager;
    int userId;
    Button updateuserpasswordBtn;
    String userEmailId;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profilesetting, container, false);

        etname = view.findViewById(R.id.etname);
        etemail = view.findViewById(R.id.etemail);

        sharedPrefManager = new SharedPrefManager(getActivity());

        String userName="Hey! " + sharedPrefManager.getUser().getUserName();
        etname.setText(userName);
        etemail.setText(sharedPrefManager.getUser().getEmail());

        currentPass = view.findViewById(R.id.currentPass);
        newPass = view.findViewById(R.id.newPassword);
        updateuserpasswordBtn = view.findViewById(R.id.btnUpdatepassword);
        userId = sharedPrefManager.getUser().getId();
        userEmailId = sharedPrefManager.getUser().getEmail();


        updateuserpasswordBtn.setOnClickListener(this);


        return view;
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnUpdatepassword:
                updatepassword();
                break;
        }
    }

    private void updatepassword() {
        String userCurrentPassword = currentPass.getText().toString().trim();
        String userNewPassword = newPass.getText().toString().trim();

        if (userCurrentPassword.isEmpty()) {
            currentPass.setError("Enter Current Password");
            currentPass.requestFocus();
            return;
        }

        if (userCurrentPassword.length() < 8) {
            currentPass.setError("Enter 8 digit Password");
            currentPass.requestFocus();
            return;
        }
        if (userNewPassword.isEmpty()) {
            newPass.setError("Enter New Password");
            newPass.requestFocus();
            return;
        }

        if (userNewPassword.length() < 8) {
            newPass.setError("Enter 8 digit Password");
            newPass.requestFocus();
            return;
        }

        Call<UpdatePassResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .UpdateUserPass(userEmailId, userCurrentPassword, userNewPassword);

        call.enqueue(new Callback<UpdatePassResponse>() {
            @Override
            public void onResponse(Call<UpdatePassResponse> call, Response<UpdatePassResponse> response) {
                UpdatePassResponse passwordResponse = response.body();
                if(response.isSuccessful()){

                    if(passwordResponse.getError().equals("200")){
                        Toast.makeText(getActivity(), passwordResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getActivity(), "failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdatePassResponse> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}