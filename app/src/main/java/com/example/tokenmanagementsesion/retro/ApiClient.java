package com.example.tokenmanagementsesion.retro;

import android.util.Log;

import androidx.annotation.Nullable;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient  {
    public static  final String BASE_URL="";
    private static Retrofit retrofitRefresh = null;
    private static Retrofit retrofit = null;
    public static Retrofit getAdapterRefresh() {
        if (retrofitRefresh==null) {
            final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            // add Authorization key on request header
                            // key will be using refresh token
                            .addHeader("Authorization", preferences.getRefreshToken())
                            .build();
                    return chain.proceed(request);
                }
            });
            retrofitRefresh= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofitRefresh;
    }

    public static Retrofit getAdapter() {
        if (retrofit==null) {
            final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", preferences.getAccessToken())
                            .build();
                    return chain.proceed(request);
                }
            });

            httpClient.authenticator(new Authenticator() {
                @Nullable
                @Override
                public Request authenticate(Route route, Response response) throws IOException {
                    if (!response.request().header("Authorization").equals(preferences.getAccessToken()))
                        return null;

                    // request new key
                    String accessToken = null;
                    ApiInterface apiService = ApiClient.getAdapterRefresh(context).create(ApiInterface.class);
                    Call<TokenResponse> call = apiService.requestAccessToken();
                    try {
                        retrofit2.Response responseCall = call.execute();
                        TokenResponse responseRequest = (TokenResponse) responseCall.body();
                        if (responseRequest != null) {
                            TokenDataResponse data = responseRequest.getData();
                            accessToken = data.getAccessToken();
                            // save new access token
                            preferences.setAccessToken(accessToken);
                        }
                    }catch (Exception ex){
                        Log.d("ERROR", "onResponse: "+ ex.toString());
                    }

                    if (accessToken != null)
                        // retry the failed 401 request with new access token
                        return response.request().newBuilder()
                                .header("Authorization", accessToken) // use the new access token
                                .build();
                    else
                        return null;
                }
            });

            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
