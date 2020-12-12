package com.example.daddycoffie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;


public class ViewproductAdapter extends RecyclerView.Adapter<ViewproductAdapter.MyViewHolder> {
    ArrayList<product> productList;
    Context context;

    public ViewproductAdapter(ArrayList<product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.productviewactivity, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final product p = productList.get(position);
        RequestOptions requestOptions = new RequestOptions();

        Glide.with(context).setDefaultRequestOptions(requestOptions).load(p.getImg()).into(holder.image);
        holder.name.setText(p.getName());
        holder.price.setText(""+p.getPrice());
//        holder.price.setText(p.getDescription());
    }

    @Override
    public int getItemCount() {
        return productList.size();
//    return 5;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView image;
        AppCompatTextView name,description,price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.productname);
            price = itemView.findViewById(R.id.productprice);
//            description = itemView.findViewById(R.id.description);


        }
    }
}
