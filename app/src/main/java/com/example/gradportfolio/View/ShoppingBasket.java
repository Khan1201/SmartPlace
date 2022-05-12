package com.example.gradportfolio.View;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gradportfolio.Model.BasketData;
import com.example.gradportfolio.Presenter.RecyclerAdapter;
import com.example.gradportfolio.R;

import java.util.Arrays;
import java.util.List;


public class ShoppingBasket extends Fragment {

    private RecyclerAdapter adapter;
    private View rootView;
    private View holderView;
    public static Context ct;


    ArrayAdapter<Integer> spinner_adapter;
    Integer[] listProductQuantity;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shopping_basket, container, false);
        holderView = inflater.inflate(R.layout.recycle_product,container,false);
        ct = container.getContext();
        init();
        setSpinner();
        getData();
        return rootView;
    }

    private void init() {
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ct);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);


    }

    private void setSpinner() {
        Spinner spinner = holderView.findViewById(R.id.recycle_spinner);
        listProductQuantity = new Integer[]{
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10
        };
       spinner_adapter = new ArrayAdapter<Integer>
               (ct, android.R.layout.simple_spinner_item,listProductQuantity);
       spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
    }

    private void getData() {

        for (int i = 0; i < MainActivity.productList.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            BasketData data = new BasketData();
            data.setSpinnerAdapter(spinner_adapter);
            data.setBrandTitle(MainActivity.productList.get(i).getBrand_name());
            data.setProductName(MainActivity.productList.get(i).getProduct_name());
            data.setProductPrice(MainActivity.productList.get(i).getPrice());
            data.setImageUrl(MainActivity.productList.get(i).getUrl());

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }

}
