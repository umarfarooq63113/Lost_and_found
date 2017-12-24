package com.example.umar.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    /*private static final String MTAG = "UOL";
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ApiInterface apiInterface;
    ArrayList<Owner> own;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*recyclerView = findViewById(R.id.recyclerView);
        Log.d("MTAG", "onCreate: ");
        own = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);*/


            // Creating post




        // Getting from api





         /*retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Owner>> cal = apiInterface.getOwner();
        ApiInterface apiInterface= retrofit.create(ApiInterface.class);
        cal.enqueue(new Callback<List<Owner>>() {
            @Override
            public void onResponse(Call<List<Owner>> call, Response<List<Owner>> response) {
                List<Owner> list = response.body();
                if (response.isSuccessful()) {
                    for (Owner x : list) {
                        own.add(x);
                    }
                    Log.d("MTAG", "onResponse: is successfully" + response.body().get(0).getOwner_name());
                    adapter = new RecyclerAdapter(own);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Owner>> call, Throwable t) {
                Log.d("MTAG", "onResponse: is Fail" + t.getLocalizedMessage());
            }
        });*/
    }
}
