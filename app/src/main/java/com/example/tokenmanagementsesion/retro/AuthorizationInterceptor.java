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
     private  Sessions sessions;


    public AuthorizationInterceptor(ApiService apiService,Sessions sessions) {
        this.apiService = apiService;
        this.sessions = sessions;
    }

    public void getRetrofit(){
        intercept();
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        //return null;
        Response mainResponse = chain.proceed(chain.request());
        Request mainRequest = chain.request();

        if (sessions.isLoggedIn()) {
            // if response code is 401 or 403, 'mainRequest' has encountered authentication error
            if (mainResponse.code() == 401 || mainResponse.code() == 403) {
               // String authKey = getAuthorizationHeader(sessions.getEmail(), sessions.getPassword());
                String email =getEmail(sessions.getEmail());
                String pass = getPassword(sessions.getPassword());
                // request to login API to get fresh token
                // synchronously calling login API
                retrofit2.Response<PostRespon> loginResponse = apiService.loginAccount(email,pass).execute();

                if (loginResponse.isSuccessful()) {
                    // login request succeed, new token generated
                    PostRespon authorization = loginResponse.body();
                    // save the new token
                    sessions.saveToken(authorization.getToken());
                    // retry the 'mainRequest' which encountered an authentication error
                    // add new token into 'mainRequest' header and request again
                    Request.Builder builder = mainRequest.newBuilder().header("Authorization", sessions.getToken()).
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
    public static String getEmail(String email) {
        /*
        String credential = email + ":" + password;
        return "Basic " + Base64.encodeToString(credential.getBytes(), Base64.DEFAULT);

         */
        return email;

    }

    public static String getPassword(String password){
        return password;

    }
}
