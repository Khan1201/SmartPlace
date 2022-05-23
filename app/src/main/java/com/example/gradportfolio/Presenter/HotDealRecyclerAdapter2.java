package com.example.gradportfolio.Presenter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradportfolio.Model.HotdealData2;
import com.example.gradportfolio.R;
import com.example.gradportfolio.View.Home;

import java.util.ArrayList;

public class HotDealRecyclerAdapter2 extends RecyclerView.Adapter<HotDealRecyclerAdapter2.ViewHolder> {
    ArrayList<HotdealData2> hotdealData2ArrayList;
    Home activity;

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
        holder.hotdeal2_text.setText(hotdealData2ArrayList.get(position).getHotdeal2_title());
        holder.hotdeal2_image1.setImageResource(hotdealData2ArrayList.get(position).getHotdeal2_image());

    }

    @Override
    public int getItemCount() {
        return hotdealData2ArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView hotdeal2_text;
        ImageView hotdeal2_image1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.hotdeal2_text=itemView.findViewById(R.id.hotdeal2_text);
            this.hotdeal2_image1 = itemView.findViewById(R.id.hotdeal2_image);


        }
    }


}
