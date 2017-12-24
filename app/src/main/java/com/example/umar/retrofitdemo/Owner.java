package com.example.umar.retrofitdemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by umar on 16/12/2017.
 */

public class Owner {
    public Owner(String email, String password, String reg_id, String owner_name, String owner_department, String owner_mobile) {
        this.email = email;
        this.password = password;
        this.reg_id = reg_id;
        this.owner_name = owner_name;
        this.owner_department = owner_department;
        this.owner_mobile = owner_mobile;
    }

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("reg_id")
    private String reg_id;

    @SerializedName("owner_name")
    private String owner_name;

    @SerializedName("owner_department")
    private String owner_department;

    @SerializedName("owner_mobile")
    private String owner_mobile;

    public int getId() {
        return id;
    }

    public String getEmai() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getReg_id() {
        return reg_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public String getOwner_department() {
        return owner_department;
    }

    public String getOwner_mobile() {
        return owner_mobile;
    }
}
