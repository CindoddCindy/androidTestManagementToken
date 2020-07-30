
package com.example.tokenmanagementsesion.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponGetToken {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("user_login")
    @Expose
    private String userLogin;
    @SerializedName("user_nicename")
    @Expose
    private String userNicename;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("user_url")
    @Expose
    private String userUrl;
    @SerializedName("user_registered")
    @Expose
    private String userRegistered;
    @SerializedName("user_activation_key")
    @Expose
    private String userActivationKey;
    @SerializedName("user_status")
    @Expose
    private long userStatus;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("zona_status")
    @Expose
    private String zonaStatus;
    @SerializedName("zona_lokasi")
    @Expose
    private String zonaLokasi;
    @SerializedName("zona_latitude")
    @Expose
    private String zonaLatitude;
    @SerializedName("zona_longitude")
    @Expose
    private long zonaLongitude;
    @SerializedName("zona_nama_depan")
    @Expose
    private String zonaNamaDepan;
    @SerializedName("zona_nama_belakang")
    @Expose
    private String zonaNamaBelakang;
    @SerializedName("zona_jenis_kelamin")
    @Expose
    private String zonaJenisKelamin;
    @SerializedName("zona_email")
    @Expose
    private String zonaEmail;
    @SerializedName("zona_telp")
    @Expose
    private long zonaTelp;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponGetToken() {
    }

    /**
     * 
     * @param zonaLatitude
     * @param userStatus
     * @param displayName
     * @param zonaStatus
     * @param zonaEmail
     * @param zonaTelp
     * @param userRegistered
     * @param userNicename
     * @param zonaJenisKelamin
     * @param userLogin
     * @param zonaLongitude
     * @param userEmail
     * @param zonaNamaDepan
     * @param id
     * @param userActivationKey
     * @param zonaNamaBelakang
     * @param userUrl
     * @param zonaLokasi
     */
    public ResponGetToken(long id, String userLogin, String userNicename, String userEmail, String userUrl, String userRegistered, String userActivationKey, long userStatus, String displayName, String zonaStatus, String zonaLokasi, String zonaLatitude, long zonaLongitude, String zonaNamaDepan, String zonaNamaBelakang, String zonaJenisKelamin, String zonaEmail, long zonaTelp) {
        super();
        this.id = id;
        this.userLogin = userLogin;
        this.userNicename = userNicename;
        this.userEmail = userEmail;
        this.userUrl = userUrl;
        this.userRegistered = userRegistered;
        this.userActivationKey = userActivationKey;
        this.userStatus = userStatus;
        this.displayName = displayName;
        this.zonaStatus = zonaStatus;
        this.zonaLokasi = zonaLokasi;
        this.zonaLatitude = zonaLatitude;
        this.zonaLongitude = zonaLongitude;
        this.zonaNamaDepan = zonaNamaDepan;
        this.zonaNamaBelakang = zonaNamaBelakang;
        this.zonaJenisKelamin = zonaJenisKelamin;
        this.zonaEmail = zonaEmail;
        this.zonaTelp = zonaTelp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserNicename() {
        return userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(String userRegistered) {
        this.userRegistered = userRegistered;
    }

    public String getUserActivationKey() {
        return userActivationKey;
    }

    public void setUserActivationKey(String userActivationKey) {
        this.userActivationKey = userActivationKey;
    }

    public long getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(long userStatus) {
        this.userStatus = userStatus;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getZonaStatus() {
        return zonaStatus;
    }

    public void setZonaStatus(String zonaStatus) {
        this.zonaStatus = zonaStatus;
    }

    public String getZonaLokasi() {
        return zonaLokasi;
    }

    public void setZonaLokasi(String zonaLokasi) {
        this.zonaLokasi = zonaLokasi;
    }

    public String getZonaLatitude() {
        return zonaLatitude;
    }

    public void setZonaLatitude(String zonaLatitude) {
        this.zonaLatitude = zonaLatitude;
    }

    public long getZonaLongitude() {
        return zonaLongitude;
    }

    public void setZonaLongitude(long zonaLongitude) {
        this.zonaLongitude = zonaLongitude;
    }

    public String getZonaNamaDepan() {
        return zonaNamaDepan;
    }

    public void setZonaNamaDepan(String zonaNamaDepan) {
        this.zonaNamaDepan = zonaNamaDepan;
    }

    public String getZonaNamaBelakang() {
        return zonaNamaBelakang;
    }

    public void setZonaNamaBelakang(String zonaNamaBelakang) {
        this.zonaNamaBelakang = zonaNamaBelakang;
    }

    public String getZonaJenisKelamin() {
        return zonaJenisKelamin;
    }

    public void setZonaJenisKelamin(String zonaJenisKelamin) {
        this.zonaJenisKelamin = zonaJenisKelamin;
    }

    public String getZonaEmail() {
        return zonaEmail;
    }

    public void setZonaEmail(String zonaEmail) {
        this.zonaEmail = zonaEmail;
    }

    public long getZonaTelp() {
        return zonaTelp;
    }

    public void setZonaTelp(long zonaTelp) {
        this.zonaTelp = zonaTelp;
    }

}
