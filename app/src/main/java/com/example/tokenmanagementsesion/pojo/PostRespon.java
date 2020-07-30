
package com.example.tokenmanagementsesion.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostRespon {

    @SerializedName("token")
    @Expose
    private String token;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PostRespon() {
    }

    /**
     * 
     * @param token
     */
    public PostRespon(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
