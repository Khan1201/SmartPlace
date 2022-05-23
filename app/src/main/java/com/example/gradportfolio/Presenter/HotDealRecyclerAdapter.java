package com.example.gradportfolio.Presenter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradportfolio.Model.HotdealData1;
import com.example.gradportfolio.R;
import com.example.gradportfolio.View.RecommendProudctList;

import java.util.ArrayList;

public class HotDealRecyclerAdapter extends RecyclerView.Adapter<HotDealRecyclerAdapter.ViewHolder> {
    ArrayList<HotdealData1> hotdealData1ArrayList;
    RecommendProudctList activity;

    public HotDealRecyclerAdapter(ArrayList<HotdealData1> hotdealData1ArrayList, RecommendProudctList activity) {
        this.hotdealData1ArrayList = hotdealData1ArrayList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public HotDealRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotdeal_layout1,null);
        HotDealRecyclerAdapter.ViewHolder viewHolder=new HotDealRecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull HotDealRecyclerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.hotdeal1_text.setText(hotdealData1ArrayList.get(position).getHotdeal1_title());
        holder.hotdeal1_image1.setImageResource(hotdealData1ArrayList.get(position).getHotdeal1_image());

    }

    @Override
    public int getItemCount() {
        return hotdealData1ArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView hotdeal1_text;
        ImageView hotdeal1_image1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.hotdeal1_text=itemView.findViewById(R.id.hotdeal1_text);
            this.hotdeal1_image1 = itemView.findViewById(R.id.hotdeal1_image);


        }
    }


}
