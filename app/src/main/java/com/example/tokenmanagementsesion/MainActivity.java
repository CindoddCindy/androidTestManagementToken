package com.example.tokenmanagementsesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tokenmanagementsesion.retro.ApiService;
import com.example.tokenmanagementsesion.retro.AuthorizationInterceptor;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public EditText editText_email, editText_pass;
    public Button btn_get_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_email=findViewById(R.id.et_email);
        editText_pass=findViewById(R.id.et_pass);
        btn_get_data=findViewById(R.id.btn_post);

        btn_get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void loginUser(){
        String login_email=editText_email.getText().toString();
        String login_password=editText_pass.getText().toString();


        AuthorizationInterceptor authorizationInterceptor = ApiService..getRetrofit().create(RetrofitServices.class);
        Call<LoginResponse> call=retrofitServices.isValidUser(login_email,login_password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                String status = response.body().getMessage();
                LoginResponse loginResponse = response.body();
                if (response.isSuccessful()) {
                    Log.d("Server Response", "failed" + loginResponse.getData());
                    //textView_log.setText(loginResponse.getMessage());
                    Intent intent = new Intent(LoginOrMakeAccount.this,ActivityNampungFragmnet.class);
                    startActivity(intent);
                    finish();
                }

                else  {
                    textView_log.setText("User Not Found");

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("Server Response","success"+t.toString());
                textView_log.setText("Connection not found");




            }
        });


    }


}