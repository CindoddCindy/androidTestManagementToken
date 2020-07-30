package com.example.tokenmanagementsesion.retro;

import com.example.tokenmanagementsesion.pojo.PostRespon;
import com.example.tokenmanagementsesion.pojo.ResponGetToken;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    String URL = "https://api.example.com" + "/v1/";

    @POST("login")
    Call<PostRespon> loginAccount(@Header("Authorization") String authKey);

    @GET("accounts/{accountId}")
    Call<ResponGetToken> getAccountInfo(@Header("Authorization") String authKey,
                                        @Path("accountId") String accountId);
}
