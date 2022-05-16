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

import com.example.anticrime.ModelResponse.MissingResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MissingRegister extends AppCompatActivity implements View.OnClickListener{

    int IMG_REQUEST = 21;
    Bitmap bitmap;
    ImageView imageView;
    Button btnSelectImage, btnRegister;
    EditText name, age, lastseen, details;
    SharedPrefManager sharedPrefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_register);

        imageView = findViewById(R.id.person_img);
        name = findViewById(R.id.etname);
        age = findViewById(R.id.etage);
        lastseen = findViewById(R.id.etlastseen);
        details = findViewById(R.id.etcrimedetails);
        //imageView = findViewById(R.id.imageView);
        btnSelectImage = findViewById(R.id.btnselect);
        btnRegister = findViewById(R.id.btnregister);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnregister:
                registermissing();
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

    private void registermissing() {

        String txtname = name.getText().toString();
        String txtage = age.getText().toString();
        String txtlastseen = lastseen.getText().toString();
        String txtdetails = details.getText().toString();
        String txtUsername = sharedPrefManager.getUser().getUserName();
        String txtStatus = "Submitted";


        if(txtname.isEmpty()){
            name.requestFocus();
            name.setError("Please enter missing person's name");
            return;
        }

        if(txtage.isEmpty()){
            age.requestFocus();
            age.setError("Please enter age");
            return;
        }

        if(txtlastseen.isEmpty()){
            lastseen.requestFocus();
            lastseen.setError("Please enter lastseen");
            return;
        }

        if(txtdetails.isEmpty()){
            details.requestFocus();
            details.setError("Please enter details");
            return;
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,75, byteArrayOutputStream);
        byte[] imageInByte = byteArrayOutputStream.toByteArray();
        String encodedImage =  Base64.encodeToString(imageInByte,Base64.DEFAULT);

        Call<MissingResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .MissingRegister(txtname, txtage, txtlastseen, txtdetails, encodedImage, txtUsername, txtStatus);

        call.enqueue(new Callback<MissingResponse>() {
            @Override
            public void onResponse(Call<MissingResponse> call, Response<MissingResponse> response) {
                MissingResponse missingResponse = response.body();

                if(response.isSuccessful()){

                    Toast.makeText(MissingRegister.this, missingResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MissingRegister.this, missingResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MissingResponse> call, Throwable t) {

                Toast.makeText(MissingRegister.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}