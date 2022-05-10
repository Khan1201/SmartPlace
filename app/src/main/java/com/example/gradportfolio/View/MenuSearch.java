package com.example.gradportfolio.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.gradportfolio.Model.MenuList;
import com.example.gradportfolio.Presenter.RecyclerAdapter;
import com.example.gradportfolio.Presenter.SearchRecyclerAdapter;
import com.example.gradportfolio.Model.SearchData;
import com.example.gradportfolio.Presenter.SearchRecyclerAdapter2;
import com.example.gradportfolio.R;

import java.sql.Array;
import java.util.ArrayList;


public class MenuSearch extends Fragment {
    ArrayList<SearchData> productItemArrayList, filteredList;
    SearchRecyclerAdapter searchRecyclerAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    EditText searchET;

    RecyclerView recyclerView2;
    ArrayList<MenuList> mList;
    SearchRecyclerAdapter2 searchRecyclerAdapter2;
    LinearLayoutManager linearLayoutManager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_menu_search1, container, false);

        intiProduct(rootView);
        secondList(rootView);


        // Inflate the layout for this fragment
        return rootView;
    }

    private void secondList(ViewGroup rootView)
    {
        recyclerView2 = rootView.findViewById(R.id.recyclerview2);

        mList = new ArrayList<>();
        searchRecyclerAdapter2 = new SearchRecyclerAdapter2(mList, this);
        //linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false); //가로
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(searchRecyclerAdapter2);

        mList.add(new MenuList("욕조", R.drawable.menu_bath));
        mList.add(new MenuList("침대", R.drawable.menu_bed));
        mList.add(new MenuList("의자", R.drawable.menu_chair));
        mList.add(new MenuList("책상", R.drawable.menu_table));
        mList.add(new MenuList("가구 5",R.drawable.image_textile));


        searchRecyclerAdapter2.notifyDataSetChanged();

    }



    private void intiProduct(ViewGroup rootView){
        recyclerView = rootView.findViewById(R.id.recyclerview);
        searchET = rootView.findViewById(R.id.edit_text);

        filteredList=new ArrayList<>();
        productItemArrayList = new ArrayList<>();

        searchRecyclerAdapter = new SearchRecyclerAdapter(productItemArrayList, this);

        //linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false); //가로
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(searchRecyclerAdapter);

        productItemArrayList.add(new SearchData("1인 원룸 휴대용 욕조","Alloso", "₩ 120,000",R.drawable.image_bath));
        productItemArrayList.add(new SearchData("일반 헤드형 수납 침대","Meister", "₩ 150,000",R.drawable.image_bed));
        productItemArrayList.add(new SearchData("심플 검은말 장식품 2P","Casamia", "₩ 30,000",R.drawable.image_deco));
        productItemArrayList.add(new SearchData("고급 1인용 사무실 의자","Hansaem", "₩ 43,000",R.drawable.image_furniture));
        productItemArrayList.add(new SearchData("가정용 4구 레인지","iLoom", "₩ 60,000",R.drawable.image_living));
        productItemArrayList.add(new SearchData("사무용 6인 책상 블루","Ikea", "₩ 39,000",R.drawable.image_office));
        productItemArrayList.add(new SearchData("3단 가정용 서랍","Uami", "₩ 50,000",R.drawable.image_storage));


        searchRecyclerAdapter.notifyDataSetChanged();

        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String searchText = searchET.getText().toString();
                searchFilter(searchText);

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void searchFilter(String searchText) {
        filteredList.clear();

        for (int i = 0; i < productItemArrayList.size(); i++) {
            if (productItemArrayList.get(i).getProductName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(productItemArrayList.get(i));
            }
        }

        searchRecyclerAdapter.filterList(filteredList);
    }




}
