package com.example.daddycoffie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import Util.Constants;
import Util.JSONPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingleViewProduct extends AppCompatActivity {
    AppCompatButton plus_btn,min_btn ,orderbtn;
    AppCompatTextView txtqty,pname,des,pro_price;
    AppCompatImageView image;

    private Retrofit retrofit;
    private JSONPlaceHolderApi jsonPlaceHolderapi;
    private Gson gson;
    int pid,qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view_product);

        gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(Constants.HTTP.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        jsonPlaceHolderapi = retrofit.create(JSONPlaceHolderApi.class);

        plus_btn = findViewById(R.id.plus);
        min_btn = findViewById(R.id.min);
        orderbtn = findViewById(R.id.orderbtn);
        txtqty = findViewById(R.id.TextNumber);


        String name = getIntent().getStringExtra("pname");
        String img = getIntent().getStringExtra("pimg");
        double price = getIntent().getDoubleExtra("pprice",0);
        String description = getIntent().getStringExtra("pdes");
        image = findViewById(R.id.img1);
        pname = findViewById(R.id.txtname);
        des = findViewById(R.id.desc);
        pro_price = findViewById(R.id.uprice);

        pname.setText(name);
        des.setText(description);
        pro_price.setText(""+price);
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(getApplicationContext()).setDefaultRequestOptions(requestOptions).load(img).into(image);





        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pid = getIntent().getIntExtra("pid",0);

                qty = Integer.parseInt(txtqty.getText().toString());
                Order order = new Order(qty,pid);
                makeOrder(order);
            }
        });

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int txt = Integer.parseInt(txtqty.getText().toString());
                int couont = txt + 1;
                txtqty.setText(""+couont);


            }
        });
        min_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int txt = Integer.parseInt(txtqty.getText().toString());

                if (txt!=1){
                    int couont = txt - 1;
                    txtqty.setText(""+couont);
                }else{
                    Toast.makeText(SingleViewProduct.this, "Invalid", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    private void makeOrder(Order order) {

        Call<String> products = jsonPlaceHolderapi.addOrder(order);
        products.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){
                    String body = response.body();
                    Toast.makeText(SingleViewProduct.this, "Order Success", Toast.LENGTH_SHORT).show();
                }
                System.out.println("ds");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                System.out.println(t);
            }
        });

    }


}
