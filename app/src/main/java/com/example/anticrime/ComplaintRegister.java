package com.example.anticrime;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anticrime.ModelResponse.ComplaintResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComplaintRegister extends AppCompatActivity implements View.OnClickListener{

    EditText address,city,pincode,subject,complaint;
    Button complaintregister;
    //String username = AppPreference.getUserName(this);

    SharedPrefManager sharedPrefManager;
//    String username = sharedPrefManager.getUser().getUserName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_register);

        address = findViewById(R.id.etaddress);
        city = findViewById(R.id.etcity);
        pincode = findViewById(R.id.etpincode);
        subject = findViewById(R.id.etsubject);
        complaint = findViewById(R.id.etcomplaint);
        //username.setText(sharedPrefManager.getUser().getUserName());
        complaintregister = findViewById(R.id.btnregister);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnregister:
                registercomplaint();
                break;

    }


}

    private void registercomplaint() {
        String txtAddress = address.getText().toString();
        String txtCity = city.getText().toString();
        String txtPincode = pincode.getText().toString();
        String txtSubject = subject.getText().toString();
        String txtComplaint = complaint.getText().toString();
        String txtUsername = sharedPrefManager.getUser().getUserName();
        String txtStatus = "Submitted";
        //String txtUsername = AppPreference.getUserName(this);
        //AppPreference.setUserName(this, "username");

        if(txtAddress.isEmpty()){
            address.requestFocus();
            address.setError("Please enter your name");
            return;
        }
        if(txtCity.isEmpty()){
            city.requestFocus();
            city.setError("Please enter your name");
            return;
        }
        if(txtPincode.isEmpty()){
            pincode.requestFocus();
            pincode.setError("Please enter your name");
            return;
        }
        if(txtSubject.isEmpty()){
            subject.requestFocus();
            subject.setError("Please enter your name");
            return;
        }
        if(txtComplaint.isEmpty()){
            complaint.requestFocus();
            complaint.setError("Please enter your name");
            return;
        }

        Call<ComplaintResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .ComplaintRegister(txtAddress, txtCity, txtPincode, txtSubject, txtComplaint, txtUsername, txtStatus);

        call.enqueue(new Callback<ComplaintResponse>() {
            @Override
            public void onResponse(Call<ComplaintResponse> call, Response<ComplaintResponse> response) {
                ComplaintResponse complaintResponse= response.body();
                if(response.isSuccessful()){

                    Toast.makeText(ComplaintRegister.this, complaintResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ComplaintRegister.this, complaintResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ComplaintResponse> call, Throwable t) {
                Toast.makeText(ComplaintRegister.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}