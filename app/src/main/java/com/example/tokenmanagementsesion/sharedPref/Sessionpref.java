package com.example.tokenmanagementsesion.sharedPref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import com.example.tokenmanagementsesion.MainActivity;

import java.util.HashMap;

public class Sessionpref {public static final String SP_USER_LOGIN="user_login";
    public static final String SP_EMAIL="email";
    public static final String SP_PASS="pass";
    public static final String SP_SUDAH_LOGIN="spSudahLogin";
    public static final String SP_DAPAT_TOKEN="dapatToken";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor spEditor;


    public Sessionpref(Context context){
        sharedPreferences=context.getSharedPreferences(SP_USER_LOGIN,Context.MODE_PRIVATE);
        spEditor= sharedPreferences.edit();
    }

    public void saveSPString (String keySP, String value){
        spEditor.putString(keySP,value);
        spEditor.commit();
    }

    public void saveSPInt(String keySp, int value){
        spEditor.putInt(keySp,value);
        spEditor.commit();
    }
    public void saveSpBoolean(String keySp,boolean value){
        spEditor.putBoolean(keySp,value);
        spEditor.commit();
    }

    public String getEmail(){
        return sharedPreferences.getString(SP_EMAIL,"");
    }
    public String getPassword(){
        return sharedPreferences.getString(SP_PASS,"");
    }

    public Boolean isLoggedIn(){
        return sharedPreferences.getBoolean(SP_SUDAH_LOGIN,false);
    }


    public void saveToken(String namaToken, String tokenValue) {
        spEditor.putString(namaToken,tokenValue);
        spEditor.commit();
       }


    public String getToken() {
        return sharedPreferences.getString(SP_DAPAT_TOKEN,"");

          }
}
