package com.example.gradportfolio.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.gradportfolio.Model.HotdealData1;
import com.example.gradportfolio.Model.HotdealData2;
import com.example.gradportfolio.Model.SearchData;
import com.example.gradportfolio.Presenter.HotDealRecyclerAdapter;
import com.example.gradportfolio.Presenter.HotDealRecyclerAdapter2;
import com.example.gradportfolio.R;

import java.util.ArrayList;

public class Home extends Fragment {
    ArrayList<HotdealData1> hotdealData1ArrayList;
    HotDealRecyclerAdapter hotDealRecyclerAdapter;
    RecyclerView hotdeal_recyclerView;
    LinearLayoutManager hotdeal_linearLayoutManager;

    ArrayList<HotdealData2> hotdealData2ArrayList;
    HotDealRecyclerAdapter2 hotDealRecyclerAdapter2;
    RecyclerView hotdeal_recyclerView2;
    LinearLayoutManager hotdeal_linearLayoutManager2;

//    static View rootView;
//    LinearLayout imageView;
   public static Context context;
//    ImageView mainImage1, mainImage2, hdImage1, hdImage2;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = container.getContext();
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home,container,false);

        if(MainActivity.productList.size() != 0){
            try{
                hotdeal_init(rootView); //hotdeal_layout1
                recommend_init(rootView);//hotdeal_layout2
            }
            catch(Exception e){
                Log.v("error", "로딩 오류");
            }
        }
        else{
            Toast.makeText(getContext(), "데이터 연결상태를 확인하세요.", Toast.LENGTH_SHORT).show();
        }

        swipeRefreshLayout=(SwipeRefreshLayout)rootView.findViewById(R.id.swipe_layout_home);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    if(MainActivity.productList.isEmpty()){
                        MainActivity.makeRequest();
                    }
                    hotdeal_init(rootView);
                    recommend_init(rootView);
                    swipeRefreshLayout.setRefreshing(false);
                }
                catch(Exception e){
                    Toast.makeText(context, "데이터 연결상태를 확인하세요.", Toast.LENGTH_SHORT).show();
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        WebView webView = rootView.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
            }
        });

        String html = "<div style=\"height: 50px\">\n" +
                "\t\t\t\t<script src=\"https://ads-partners.coupang.com/g.js\"></script>\n" +
                "\t\t\t\t<script>\n" +
                "\t\t\t\t\tnew PartnersCoupang.G({\n" +
                "\t\t\t\t\t\t\"id\": 1,\n" +
                "\t\t\t\t\t\t\"height\": 80,\n" +
                "\t\t\t\t\t\t\"bordered\": true\n" +
                "\t\t\t\t\t});\n" +
                "\t\t\t\t</script>\t\t\n" +
                "\t\t</div>";
        webView.loadData(html, "text/html", "UTF8");

        return rootView;
    }

        private void hotdeal_init(ViewGroup rootView)
    {
        hotdeal_recyclerView = rootView.findViewById(R.id.hotdeal1_recycler);
        hotdealData1ArrayList = new ArrayList();
        hotDealRecyclerAdapter = new HotDealRecyclerAdapter(hotdealData1ArrayList, this);
        hotdeal_linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false); //가로
        hotdeal_recyclerView.setLayoutManager(hotdeal_linearLayoutManager);
        hotdeal_recyclerView.setAdapter(hotDealRecyclerAdapter);

        for (int i = 7; i < 13; i++) {
            hotdealData1ArrayList.add(new HotdealData1(MainActivity.productList.get(i).getProduct_name(), MainActivity.productList.get(i).getBrand_name(), MainActivity.productList.get(i).getPrice(), MainActivity.productList.get(i).getUrl(),
                    MainActivity.productList.get(i).getDetails(), MainActivity.productList.get(i).getUrl2(),
                    MainActivity.productList.get(i).getUrl3(), MainActivity.productList.get(i).getUrl4(),MainActivity.productList.get(i).getPurchaseUrl()));
        }
    }

    private void recommend_init(ViewGroup rootView)
    {
        hotdeal_recyclerView2 = rootView.findViewById(R.id.hotdeal2_recycler2);
        hotdealData2ArrayList = new ArrayList<>();
        hotDealRecyclerAdapter2 = new HotDealRecyclerAdapter2(hotdealData2ArrayList, this);
        hotdeal_linearLayoutManager2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false); //가로
        hotdeal_recyclerView2.setLayoutManager(hotdeal_linearLayoutManager2);
        hotdeal_recyclerView2.setAdapter(hotDealRecyclerAdapter2);

        for (int i = 13; i < 19; i++) {
            hotdealData2ArrayList.add(new HotdealData2(MainActivity.productList.get(i).getProduct_name(), MainActivity.productList.get(i).getBrand_name(), MainActivity.productList.get(i).getPrice(), MainActivity.productList.get(i).getUrl(),
                    MainActivity.productList.get(i).getDetails(), MainActivity.productList.get(i).getUrl2(),
                    MainActivity.productList.get(i).getUrl3(), MainActivity.productList.get(i).getUrl4(),MainActivity.productList.get(i).getPurchaseUrl()));
        }

    }

}