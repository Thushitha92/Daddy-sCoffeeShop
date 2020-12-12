package com.example.daddycoffie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.SyncStateContract;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import Util.Constants;
import Util.JSONPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePage extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<product> plist;

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

        plist = new ArrayList<>();
        recyclerView = findViewById(R.id.homerecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        viewAllProducts();
    }

    private void viewAllProducts() {

        Call<ProductList> products = jsonPlaceHolderapi.getProducts();
        products.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {

                if(response.isSuccessful()){

                    ProductList body = response.body();
                    plist = body.getPlist();
                    ViewproductAdapter adapter = new ViewproductAdapter( plist,HomePage.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                System.out.println(t);
            }
        });

    }


}
