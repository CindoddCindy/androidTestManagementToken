package com.example.tokenmanagementsesion.retro;

import android.app.blob.BlobStoreManager;
import android.content.pm.PackageInstaller;
import android.media.tv.TvInputService;
import android.se.omapi.Session;
import android.service.textservice.SpellCheckerService;
import android.util.Base64;

import com.example.tokenmanagementsesion.pojo.PostRespon;
import com.example.tokenmanagementsesion.pojo.ResponGetToken;
import com.example.tokenmanagementsesion.sharedPref.Sessionpref;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {

    private ApiService apiService;
    private Sessionpref sessionpref;


    public AuthorizationInterceptor(ApiService apiService, Sessionpref sessionpref) {
        this.apiService = apiService;
        this.sessionpref = sessionpref;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        //return null;
        Response mainResponse = chain.proceed(chain.request());
        Request mainRequest = chain.request();

        if (sessionpref.isLoggedIn()) {
            // if response code is 401 or 403, 'mainRequest' has encountered authentication error
            if (mainResponse.code() == 401 || mainResponse.code() == 403) {
                String authKey = getAuthorizationHeader(sessionpref.getEmail(), sessionpref.getPassword());
                // request to login API to get fresh token
                // synchronously calling login API
                retrofit2.Response<PostRespon> loginResponse = apiService.loginAccount(authKey).execute();

                if (loginResponse.isSuccessful()) {
                    // login request succeed, new token generated
                    PostRespon authorization = loginResponse.body();
                    // save the new token
                    sessionpref.saveToken(authorization.getToken());
                    // retry the 'mainRequest' which encountered an authentication error
                    // add new token into 'mainRequest' header and request again
                    Request.Builder builder = mainRequest.newBuilder().header("Authorization", sessionpref.getToken()).
                            method(mainRequest.method(), mainRequest.body());
                    mainResponse = chain.proceed(builder.build());
                }
            }
        }

        return mainResponse;
    }

    /**
     * this method is API implemetation specific
     * might not work with other APIs
     **/
    public static String getAuthorizationHeader(String email, String password) {
        String credential = email + ":" + password;
        return "Basic " + Base64.encodeToString(credential.getBytes(), Base64.DEFAULT);

    }
}
