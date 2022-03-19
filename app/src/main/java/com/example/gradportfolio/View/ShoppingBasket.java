package com.example.gradportfolio.View;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gradportfolio.Model.BasketData;
import com.example.gradportfolio.Presenter.RecyclerAdapter;
import com.example.gradportfolio.R;

import java.util.Arrays;
import java.util.List;


public class ShoppingBasket extends Fragment {

    private RecyclerAdapter adapter;
    private View rootView;
    Context ct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shopping_basket, container, false);
        ct = container.getContext();
        init();
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

    private void getData() {
        // 임의의 데이터입니다.
        List<String> listTitle = Arrays.asList("욕조", "침대", "장식품", "의자", "레인지", "사무실 책상", "서랍", "타일");
        List<String> listContent = Arrays.asList(
                "120,000원",
                "150,000원",
                "30,000원",
                "43,000원",
                "60,000원",
                "39,000원",
                "50.000원",
                "27,000원"
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.image_bath,
                R.drawable.image_bed,
                R.drawable.image_deco,
                R.drawable.image_furniture,
                R.drawable.image_living,
                R.drawable.image_office,
                R.drawable.image_storage,
                R.drawable.image_textile
        );
        for (int i = 0; i < listTitle.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            BasketData data = new BasketData();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            data.setResId(listResId.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }

}
