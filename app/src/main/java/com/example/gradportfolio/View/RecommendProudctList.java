package com.example.gradportfolio.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradportfolio.Model.HotdealData1;
import com.example.gradportfolio.Presenter.HotDealRecyclerAdapter;
import com.example.gradportfolio.R;

import java.util.ArrayList;


public class RecommendProudctList extends Fragment {
    ArrayList<HotdealData1> hotdealData1ArrayList;
    HotDealRecyclerAdapter hotDealRecyclerAdapter;
    RecyclerView hotdeal_recyclerView;
    LinearLayoutManager hotdeal_linearLayoutManager;

    public static Context ct;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_recommend_proudct_list,container,false);


//        hotdeal_inti(rootView);

        ct = getContext();
        // Inflate the layout for this fragment
        return rootView;



    }

//    private void hotdeal_inti(ViewGroup rootView)
//    {
//        hotdeal_recyclerView = rootView.findViewById(R.id.recommend_recycler1);
//        hotdealData1ArrayList = new ArrayList<>();
//        hotDealRecyclerAdapter = new HotDealRecyclerAdapter(hotdealData1ArrayList, this);
//        hotdeal_linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false); //가로
//        hotdeal_recyclerView.setLayoutManager(hotdeal_linearLayoutManager);
//        hotdeal_recyclerView.setAdapter(hotDealRecyclerAdapter);
//
//        hotdealData1ArrayList.add(new HotdealData1("제품 1", R.drawable.bath2));
//        hotdealData1ArrayList.add(new HotdealData1("제품 2", R.drawable.bath3));
//        hotdealData1ArrayList.add(new HotdealData1("제품 3", R.drawable.bath4));
//        hotdealData1ArrayList.add(new HotdealData1("제품 4", R.drawable.bath5));
//    }
}