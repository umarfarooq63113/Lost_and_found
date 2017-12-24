package com.example.umar.retrofitdemo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by umar on 16/12/2017.
 */

public interface ApiInterface {
    @GET("owner")
    Call<List<Owner>> getOwner();
    @POST("owner")
    Call<Owner> createOwner(@Body Owner owner);
}
