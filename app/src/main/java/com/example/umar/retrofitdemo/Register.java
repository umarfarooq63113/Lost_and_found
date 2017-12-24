package com.example.umar.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {
    Button btnCancel, btnReg;
    EditText email, password, reg_id, owner_name, owner_department, owner_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnCancel = findViewById(R.id.btnCancel);
        btnReg = findViewById(R.id.btnReg);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        reg_id = findViewById(R.id.etRegNo);
        owner_name = findViewById(R.id.etName);
        owner_department = findViewById(R.id.etDept);
        owner_mobile = findViewById(R.id.etPhone);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), Login.class));
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String BASE_URL = "http://192.168.10.3/app/public/api/";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Owner owner = new Owner(owner_name.getText().toString(), password.getText().toString(),
                        reg_id.getText().toString(), owner_name.getText().toString(),
                        owner_department.getText().toString(),
                        owner_mobile.getText().toString());

                ApiInterface api = retrofit.create(ApiInterface.class);
                Call<Owner> call = api.createOwner(owner);
                call.enqueue(new Callback<Owner>() {
                    @Override
                    public void onResponse(Call<Owner> call, Response<Owner> response) {
                        startActivity(new Intent(getApplication(), Login.class));
                    }

                    @Override
                    public void onFailure(Call<Owner> call, Throwable t) {
                        String s = "";
                    }
                });

            }
        });
    }
}
