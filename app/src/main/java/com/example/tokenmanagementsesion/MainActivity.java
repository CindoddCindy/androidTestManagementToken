package com.example.tokenmanagementsesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


}