package com.example.anticrime;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.anticrime.ModelResponse.CrimeResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CrimeRegister extends AppCompatActivity implements View.OnClickListener{

    int IMG_REQUEST = 21;
    Bitmap bitmap;
    ImageView imageView;
    Button btnSelectImage, btnRegister;
    EditText street, city, pincode, crimedetails;

    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_register);

        imageView = findViewById(R.id.crime_img);
        street = findViewById(R.id.etstreet);
        city = findViewById(R.id.etcity);
        pincode = findViewById(R.id.etpincode);
        crimedetails = findViewById(R.id.etcrimedetails);
        //imageView = findViewById(R.id.imageView);
        btnSelectImage = findViewById(R.id.btnselect);
        btnRegister = findViewById(R.id.btnregister);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnregister:
                registercrime();
                break;
            case R.id.btnselect:
                selectimage();
                break;

        }

    }

    private void selectimage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMG_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null){

            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void registercrime() {

        String txtstreet = street.getText().toString();
        String txtcity = city.getText().toString();
        String txtpincode = pincode.getText().toString();
        String txtcrimedetails = crimedetails.getText().toString();
        String txtUsername = sharedPrefManager.getUser().getUserName();
        String txtStatus = "Submitted";

        if(txtstreet.isEmpty()){
            street.requestFocus();
            street.setError("Please enter street name");
            return;
        }

        if(txtcity.isEmpty()){
            city.requestFocus();
            city.setError("Please enter city name");
            return;
        }

        if(txtpincode.isEmpty()){
            pincode.requestFocus();
            pincode.setError("Please enter pincode");
            return;
        }

        if(txtcrimedetails.isEmpty()){
            crimedetails.requestFocus();
            crimedetails.setError("Please enter crime details");
            return;
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,75, byteArrayOutputStream);
        byte[] imageInByte = byteArrayOutputStream.toByteArray();
        String encodedImage =  Base64.encodeToString(imageInByte,Base64.DEFAULT);

        Call<CrimeResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .CrimeRegister(txtstreet, txtcity, txtpincode, txtcrimedetails, encodedImage, txtUsername, txtStatus);

        call.enqueue(new Callback<CrimeResponse>() {
            @Override
            public void onResponse(Call<CrimeResponse> call, Response<CrimeResponse> response) {
                CrimeResponse crimeResponse = response.body();

                if(response.isSuccessful()){

                    Toast.makeText(CrimeRegister.this, crimeResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CrimeRegister.this, crimeResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CrimeResponse> call, Throwable t) {
                Toast.makeText(CrimeRegister.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}