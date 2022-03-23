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
    Context ct;

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
        // 임의의 데이터입니다.
        List<String> listBrandTitle = Arrays.asList(
                "Alloso",
                "Meister",
                "Casamia",
                "Hansaem",
                "iLoom",
                "Ikea",
                "Uami",
                "Samik"
        );
        List<String> listProductName = Arrays.asList(
                "1인 원룸 휴대용 욕조",
                "일반 헤드형 수납 침대",
                "심플 검은말 장식품 2P",
                "고급 1인용 사무실 의자",
                "가정용 4구 레인지",
                "사무용 6인 책상 블루",
                "3단 가정용 서랍",
                "가정 인테리어용 타일"
        );
        List<String> listProductPrice = Arrays.asList(
                "₩ 120,000",
                "₩ 150,000",
                "₩ 30,000",
                "₩ 43,000",
                "₩ 60,000",
                "₩ 39,000",
                "₩ 50.000",
                "₩ 27,000"
        );
        List<Integer> listImageId = Arrays.asList(
                R.drawable.image_bath,
                R.drawable.image_bed,
                R.drawable.image_deco,
                R.drawable.image_furniture,
                R.drawable.image_living,
                R.drawable.image_office,
                R.drawable.image_storage,
                R.drawable.image_textile
        );

        for (int i = 0; i < listBrandTitle.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            BasketData data = new BasketData();
            data.setSpinnerAdapter(spinner_adapter);
            data.setBrandTitle(listBrandTitle.get(i));
            data.setProductName(listProductName.get(i));
            data.setProductPrice(listProductPrice.get(i));
            data.setImageId(listImageId.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }

}
