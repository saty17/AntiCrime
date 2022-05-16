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

import com.example.anticrime.ModelResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class login extends AppCompatActivity implements View.OnClickListener {

    EditText email, password;
    Button login;
    TextView registerlink;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.etemail);
        password = findViewById(R.id.etpassword);
        login = findViewById(R.id.btnlogin);
        registerlink = findViewById(R.id.registerlink);

        registerlink.setOnClickListener(this);
        login.setOnClickListener(this);

        sharedPrefManager = new SharedPrefManager(getApplicationContext());

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnlogin:
                userLogin();
                break;
            case R.id.registerlink:
                switchOnRegister();

        }

    }

    private void userLogin() {


        String UserEmail = email.getText().toString();
        String UserPassword = password.getText().toString();

        if (sharedPrefManager.isLoggedIn()) {
            Intent intent = new Intent(login.this, skiphome.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        if (UserEmail.isEmpty()) {
            email.requestFocus();
            email.setError("Please enter your Email");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(UserEmail).matches()) {
            email.requestFocus();
            email.setError("Please enter correct Email");
            return;
        }
        if (UserPassword.isEmpty()) {
            password.requestFocus();
            password.setError("Please enter your Password");
            return;
        }
        if (UserPassword.length() < 8) {
            password.requestFocus();
            password.setError("Please enter password with 8 length");
            return;
        }

        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().login(UserEmail, UserPassword);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();

                if (response.isSuccessful()) {

                    if (loginResponse.getError().equals("200")) {

                        sharedPrefManager.saveUser(loginResponse.getUser());
                        Intent intent = new Intent(login.this, skiphome.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        Toast.makeText(login.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(login.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void switchOnRegister() {

        Intent i = new Intent(login.this, register.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (sharedPrefManager.isLoggedIn()) {
            Intent intent = new Intent(login.this, skiphome.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

}