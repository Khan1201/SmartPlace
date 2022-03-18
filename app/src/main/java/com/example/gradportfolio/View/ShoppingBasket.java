package com.example.gradportfolio.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gradportfolio.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket extends Fragment {

    ArrayList<Product> products;
    ListView productListView;
    private static CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_shopping_basket, container, false);
        products = new ArrayList<>();
            products.add(new Product("Bath", "https://www.google.com/url?sa=i&url=https%3A%2F%2Farfu.co.kr%2Fproduct%2F%25EB%25A7%259D%25EA%25B3%25A0%25EC%25B2%25B4%25EC%2596%25B4c338pu%2F1703%2F&psig=AOvVaw1uoEK8AiXWKJyGjMH-8Vqs&ust=1647673010409000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCJDf67aKz_YCFQAAAAAdAAAAABAD"));
        products.add(new Product("Desk", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5qHNjhtjMD4YWH3UP0rm4tKwxCL.jpg"));
        products.add(new Product("Note", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5qHNjhtjMD4YWH3UP0rm4tKwxCL.jpg"));
        products.add(new Product("Mirror", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5qHNjhtjMD4YWH3UP0rm4tKwxCL.jpg"));

        productListView = (ListView) rootView.findViewById(R.id.listView);
        customAdapter = new CustomAdapter(getContext(),products);
        productListView.setAdapter(customAdapter);
        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰
                String selectedItem = (String) view.findViewById(R.id.textView_name).getTag().toString();
                Toast.makeText(getContext(), "Clicked: " + position +" " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }
}

class Product {
    private String name;
    private String thumb_url;

    public Product(String name, String thumb_url) {
        this.name = name;
        this.thumb_url = thumb_url;
    }
    public String getName() {
        return name;
    }

    public String getThumb_url() {
        return thumb_url;
    }
}