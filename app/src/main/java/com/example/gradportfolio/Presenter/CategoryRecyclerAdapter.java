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

import com.example.gradportfolio.Model.CategoryData;
import com.example.gradportfolio.Model.Category_1;
import com.example.gradportfolio.Model.SearchData;
import com.example.gradportfolio.R;
import com.example.gradportfolio.View.MenuSearch;
import com.example.gradportfolio.View.ProductDetail;

import java.util.ArrayList;

public class  CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.ViewHolder> {
    ArrayList<CategoryData> productItemArrayList;
    Category_1 activity;
    private Intent intent;
    public CategoryRecyclerAdapter(ArrayList<CategoryData> productItemArrayList, Category_1 activity) {
        this.productItemArrayList = productItemArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_recycler,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.productName.setText(productItemArrayList.get(position).getProductName());
        holder.productPrice.setText(productItemArrayList.get(position).getProduct_price());
        holder.productTitle.setText(productItemArrayList.get(position).getBrand_title());
        holder.image1.setImageResource(productItemArrayList.get(position).getImageId());

        //holder.image1.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
               // intent = new Intent(v.getContext(), Category_1.class);
              //  intent.putExtra("number" ,position);
                //intent.putExtra("title", productItemArrayList.get(position).getBrand_title());
                //intent.putExtra("image",productItemArrayList.get(position).getImageId());
                //intent.putExtra("product_name", productItemArrayList.get(position).getProductName());
                //intent.putExtra("price",productItemArrayList.get(position).getProduct_price());
                //v.getContext().startActivity(intent);
//            }
  //      });



    }

    @Override
    public int getItemCount() {
        return productItemArrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView productName;
        TextView productTitle;
        TextView productPrice;
        ImageView image1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.productName=itemView.findViewById(R.id.category_product_name);
            this.productTitle = itemView.findViewById(R.id.category_brand_title);
            this.productPrice = itemView.findViewById(R.id.category_product_price);
            this.image1 = itemView.findViewById(R.id.category_product_image);


        }
    }
}
