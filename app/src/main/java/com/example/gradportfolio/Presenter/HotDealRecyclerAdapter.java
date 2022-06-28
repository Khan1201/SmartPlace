package com.example.gradportfolio.Presenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gradportfolio.Model.HotdealData1;
import com.example.gradportfolio.R;
import com.example.gradportfolio.View.Home;
import com.example.gradportfolio.View.ProductDetail;

import java.util.ArrayList;

public class HotDealRecyclerAdapter extends RecyclerView.Adapter<HotDealRecyclerAdapter.ViewHolder> {
    ArrayList<HotdealData1> hotdealData1ArrayList;
    Home activity;
    Intent intent;

    public HotDealRecyclerAdapter(ArrayList<HotdealData1> hotdealData1ArrayList, Home activity) {
        this.hotdealData1ArrayList = hotdealData1ArrayList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public HotDealRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_recommend_product,null);
        HotDealRecyclerAdapter.ViewHolder viewHolder=new HotDealRecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull HotDealRecyclerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Glide.with(Home.context).load(hotdealData1ArrayList.get(position).getImageUrl()).into(holder.hotdeal1_image1);
        holder.hotdeal1_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), ProductDetail.class);
                intent.putExtra("number" ,position);
                intent.putExtra("title", hotdealData1ArrayList.get(position).getBrand_title());
                intent.putExtra("image",hotdealData1ArrayList.get(position).getImageUrl());
                intent.putExtra("product_name", hotdealData1ArrayList.get(position).getProductName());
                intent.putExtra("price",hotdealData1ArrayList.get(position).getProduct_price());
                intent.putExtra("details",hotdealData1ArrayList.get(position).getDetails());
                intent.putExtra("image2",hotdealData1ArrayList.get(position).getImageUrl2());
                intent.putExtra("image3",hotdealData1ArrayList.get(position).getImageUrl3());
                intent.putExtra("image4",hotdealData1ArrayList.get(position).getImageUrl4());
                intent.putExtra("purchase", hotdealData1ArrayList.get(position).getPurchaseUrl());
                intent.putExtra("name","home");
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotdealData1ArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView hotdeal1_image1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.hotdeal1_image1 = itemView.findViewById(R.id.hotdeal1_image);


        }
    }


}
