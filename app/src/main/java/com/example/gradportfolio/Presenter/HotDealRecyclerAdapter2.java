package com.example.gradportfolio.Presenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gradportfolio.Model.HotdealData2;
import com.example.gradportfolio.R;
import com.example.gradportfolio.View.Home;
import com.example.gradportfolio.View.MenuSearch;
import com.example.gradportfolio.View.ProductDetail;

import java.util.ArrayList;

public class HotDealRecyclerAdapter2 extends RecyclerView.Adapter<HotDealRecyclerAdapter2.ViewHolder> {
    ArrayList<HotdealData2> hotdealData2ArrayList;
    Home activity;
    Intent intent;

    public HotDealRecyclerAdapter2(ArrayList<HotdealData2> hotdealData2ArrayList, Home activity) {
        this.hotdealData2ArrayList = hotdealData2ArrayList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public HotDealRecyclerAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotdeal_layout2,null);
        HotDealRecyclerAdapter2.ViewHolder viewHolder=new HotDealRecyclerAdapter2.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull HotDealRecyclerAdapter2.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Glide.with(Home.context).load(hotdealData2ArrayList.get(position).getImageUrl()).into(holder.hotdeal2_image1);
        holder.hotdeal2_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), ProductDetail.class);
                intent.putExtra("number" ,position);
                intent.putExtra("title", hotdealData2ArrayList.get(position).getBrand_title());
                intent.putExtra("image",hotdealData2ArrayList.get(position).getImageUrl());
                intent.putExtra("product_name", hotdealData2ArrayList.get(position).getProductName());
                intent.putExtra("price",hotdealData2ArrayList.get(position).getProduct_price());
                intent.putExtra("details",hotdealData2ArrayList.get(position).getDetails());
                intent.putExtra("image2",hotdealData2ArrayList.get(position).getImageUrl2());
                intent.putExtra("image3",hotdealData2ArrayList.get(position).getImageUrl3());
                intent.putExtra("image4",hotdealData2ArrayList.get(position).getImageUrl4());
                intent.putExtra("purchase", hotdealData2ArrayList.get(position).getPurchaseUrl());
                intent.putExtra("name","home");
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hotdealData2ArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView hotdeal2_image1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.hotdeal2_image1 = itemView.findViewById(R.id.hotdeal2_image);


        }
    }


}
