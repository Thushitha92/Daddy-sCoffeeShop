package com.example.daddycoffie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import Model.product;
import Util.Constants;
import Util.JSONPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePage extends AppCompatActivity {

    RecyclerView recyclerView;

    private Retrofit retrofit;
    private JSONPlaceHolderApi jsonPlaceHolderapi;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(Constants.HTTP.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        jsonPlaceHolderapi = retrofit.create(JSONPlaceHolderApi.class);

        recyclerView = findViewById(R.id.homerecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        viewAllProducts();
    }

    private void viewAllProducts() {

        Call<List<product>> products = jsonPlaceHolderapi.getProducts();
        products.enqueue(new Callback<List<product>>() {
            @Override
            public void onResponse(Call<List<product>> call, Response<List<product>> response) {

                if(response.isSuccessful()){

                    List<product> body = response.body();
                    ViewproductAdapter adapter = new ViewproductAdapter( body,HomePage.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                System.out.println("ds");
            }

            @Override
            public void onFailure(Call<List<product>> call, Throwable t) {

                System.out.println(t);
            }
        });

    }


}
