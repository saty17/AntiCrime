package com.example.anticrime;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anticrime.ModelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity implements View.OnClickListener {

    TextView loginlink;
    EditText username,email,password,aadhar_no,phone_no;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //hide action bar
       // getSupportActionBar().hide();

        //hide status bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    username = findViewById(R.id.etname);
    email = findViewById(R.id.etemail);
    password = findViewById(R.id.etpassword);
    aadhar_no = findViewById(R.id.etaadhar);
    phone_no = findViewById(R.id.etphone);
    register = findViewById(R.id.btnregister);
    loginlink = findViewById(R.id.loginlink);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnregister:
                registerUser();
                break;
            case R.id.loginlink:
                    switchOnLogin();


        }

    }

    private void registerUser() {

        String UserName = username.getText().toString();
        String UserEmail = email.getText().toString();
        String UserPassword = password.getText().toString();
        String UserAadhar = aadhar_no.getText().toString();
        String UserPhone = phone_no.getText().toString();



        if(UserName.isEmpty()){
            username.requestFocus();
            username.setError("Please enter your name");
            return;
        }
        if(UserEmail.isEmpty()){
            email.requestFocus();
            email.setError("Please enter your Email");
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(UserEmail).matches()){
            email.requestFocus();
            email.setError("Please enter correct Email");
            return;
        }
        if(UserPassword.isEmpty()){
            password.requestFocus();
            password.setError("Please enter your Password");
            return;
        }
        if(UserPassword.length()<8){
            password.requestFocus();
            password.setError("Please enter password with 8 length");
            return;
        }
        if(UserAadhar.isEmpty()){
            aadhar_no.requestFocus();
            aadhar_no.setError("Please enter your Aadhar no.");
            return;
        }
        if(UserAadhar.length()<12){
            aadhar_no.requestFocus();
            aadhar_no.setError("Please enter aadhar no with 12 length");
            return;
        }
        if(UserPhone.isEmpty()){
            phone_no.requestFocus();
            phone_no.setError("Please enter your Phone no");
            return;
        }
        if(UserPhone.length()<10){
            phone_no.requestFocus();
            phone_no.setError("Please enter phone no  of 10 digit");
            return;
        }


        Call<RegisterResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .register(UserName,UserEmail,UserPassword,UserAadhar,UserPhone);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse=response.body();
                if(response.isSuccessful()){

                    Intent intent = new Intent(register.this,login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                    Toast.makeText(register.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(register.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(register.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void switchOnLogin() {

        Intent i = new Intent(register.this,login.class);
        startActivity(i);
    }


}
