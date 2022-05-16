package com.example.anticrime;

import com.example.anticrime.ModelResponse.ComplaintResponse;
import com.example.anticrime.ModelResponse.CrimeResponse;
import com.example.anticrime.ModelResponse.FetchComplaintResponse;
import com.example.anticrime.ModelResponse.FetchCrimeResponse;
import com.example.anticrime.ModelResponse.FetchMissingResponse;
import com.example.anticrime.ModelResponse.FetchUserResponse;
import com.example.anticrime.ModelResponse.LoginResponse;
import com.example.anticrime.ModelResponse.MissingResponse;
import com.example.anticrime.ModelResponse.RegisterResponse;
import com.example.anticrime.ModelResponse.UpdatePassResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("aadhar_no") String aadhar_no,
            @Field("phone_no") String phone_no
    );
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("complaintreg.php")
    Call<ComplaintResponse> ComplaintRegister(
            @Field("address") String address,
            @Field("city") String city,
            @Field("pincode") String pincode,
            @Field("subject") String subject,
            @Field("complaint") String complaint,
            @Field("username") String username,
            @Field("status") String status
    );
    @FormUrlEncoded
    @POST("missingreg.php")
    Call<MissingResponse> MissingRegister(
            @Field("name") String name,
            @Field("age") String age,
            @Field("lastseen") String lastseen,
            @Field("details") String details,
            @Field("EN_IMAGE") String encodedImage,
            @Field("username") String username,
            @Field("status") String status
    );
    @FormUrlEncoded
    @POST("crimereg.php")
    Call<CrimeResponse> CrimeRegister(
            @Field("crimestreet") String street,
            @Field("crimecity") String city,
            @Field("crimepincode") String pincode,
            @Field("crimedetails") String crimedetails,
            @Field("EN_IMAGE") String encodedImage,
            @Field("username") String username,
            @Field("status") String status
    );

    @FormUrlEncoded
    @POST("updatepaswword.php")
    Call<UpdatePassResponse> UpdateUserPass(
            @Field("email") String email,
            @Field("current") String currentPassword,
            @Field("new") String newPassword
    );

    @FormUrlEncoded
    @POST("getmissing.php")
    Call<FetchMissingResponse> StatusMissing(
            @Field("userN") String username
    );

    @FormUrlEncoded
    @POST("getcrime.php")
    Call<FetchCrimeResponse> StatusCrime(
            @Field("userN") String username
    );

    @FormUrlEncoded
    @POST("getcomplaint.php")
    Call<FetchComplaintResponse> StatusComplaint(
            @Field("userN") String username
    );

    @GET("fetchmissing.php")
    Call<FetchMissingResponse> fetchAllMissing();

    @GET("fetchcrime.php")
    Call<FetchCrimeResponse> fetchAllCrime();

    @GET("fetchcomplaint.php")
    Call<FetchComplaintResponse> fetchAllComplaint();

    @GET("fetchusers.php")
    Call<FetchUserResponse> fetchAllUsers();

}
