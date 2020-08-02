package com.example.tokenmanagementsesion.retro;

import com.example.tokenmanagementsesion.pojo.PostRespon;
import com.example.tokenmanagementsesion.pojo.ResponGetToken;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("http://153.92.4.177:90/api/auth/getuser")
    Call<ResponGetToken>  getUserResponse(@Header("Authorization") String token);
/*
    @GET("http://153.92.4.177:90/api/auth/getuser")
    @Headers("Accept: application/json")
    Call<ResponGetToken>  getUserResponse(@Header("Authorization") String token);

 */



    @FormUrlEncoded
    @POST("http://153.92.4.177:90/api/auth/login")
    Call<PostRespon> loginAccount(@Field("user_email")String user_email ,@Field("user_pass")String user_pass );
}
