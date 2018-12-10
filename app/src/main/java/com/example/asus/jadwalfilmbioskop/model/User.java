package com.example.asus.jadwalfilmbioskop.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("idUser")
    private int idUser;

    @SerializedName("email")
    private String email;

    @SerializedName("nama")
    private String nama;

    @SerializedName("password")
    private String password;

    public User(int idUser, String email, String nama, String password) {
        this.idUser = idUser;
        this.email = email;
        this.nama = nama;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

