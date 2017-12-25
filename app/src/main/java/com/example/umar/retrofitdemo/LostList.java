package com.example.umar.retrofitdemo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LostList extends AppCompatActivity {
    Button btnSubmit, btnCancel;
    FloatingActionButton add;
    private RecyclerView recyclerView;
    private LostRecyclerAdapter adapter;
    List<LostThings> own=new ArrayList<LostThings>();
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);


        add = findViewById(R.id.floatingActionButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LostList.this, LostPost.class));
            }
        });
        recyclerView = findViewById(R.id.lostRecyclerView);
        Log.d("MTAG", "onCreate: ");


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

      /*  btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),MainActivity.class));
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),MainActivity.class));
            }
        });*/


        final String BASE_URL = "http://192.168.10.3/app/public/api/";
        //own = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
        Call<List<LostThings>> cal = apiInterface.getLostThings();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        cal.enqueue(new Callback<List<LostThings>>() {
            @Override
            public void onResponse(Call<List<LostThings>> call, Response<List<LostThings>> response) {
                List<LostThings> list = response.body();
                if (response.isSuccessful()) {
                    for (LostThings x : list) {
                        own.add(x);
                    }
                    //Log.d("MTAG", "onResponse: is successfully" + response.body().get(0).getOwner_name());
                    //adapter = new LostRecyclerAdapter(own,this);
                    adapter = new LostRecyclerAdapter(own,LostList.this);
                    recyclerView.setAdapter(adapter);
                }

            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             *
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<List<LostThings>> call, Throwable t) {
                Log.d("MTAG", "onResponse: is Fail" + t.getLocalizedMessage());
            }

        });


    }
}
