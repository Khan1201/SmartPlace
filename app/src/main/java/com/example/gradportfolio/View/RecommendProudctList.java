package com.example.gradportfolio.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.gradportfolio.Presenter.SearchRecyclerAdapter;
import com.example.gradportfolio.Model.SearchData;
import com.example.gradportfolio.R;

import java.util.ArrayList;


public class RecommendProudctList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_recommend_proudct_list, container, false);



    }
}