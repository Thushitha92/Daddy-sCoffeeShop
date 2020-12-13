package com.example.daddycoffie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;


public class ViewproductAdapter extends RecyclerView.Adapter<ViewproductAdapter.MyViewHolder> {
    List<product> productList;
    Context context;

    public ViewproductAdapter(List<product> productList, Context context) {
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
        holder.name.setText(p.getPname());
        holder.price.setText(""+p.getPrice());
//        holder.price.setText(p.getDescription());
        String name = p.getPname();
        int pid = p.getId();



        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, pid+""+name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, SingleViewProduct.class);
                intent.putExtra("pid",p.getId());
                intent.putExtra("pname",p.getPname());
                intent.putExtra("pdes",p.getDescription());
                intent.putExtra("pimg",p.getImg());
                intent.putExtra("pprice",p.getPrice());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView image;
        AppCompatButton button;
        AppCompatTextView name,description,price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.productname);
            price = itemView.findViewById(R.id.productprice);
            button = itemView.findViewById(R.id.viewbtn);



        }
    }
}
