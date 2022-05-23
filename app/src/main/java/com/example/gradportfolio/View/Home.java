package com.example.gradportfolio.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradportfolio.Model.HotdealData1;
import com.example.gradportfolio.Model.HotdealData2;
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
//    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = container.getContext();
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home,container,false);

        hotdeal_inti(rootView); //hotdeal_layout1

        recommend_inti(rootView);//hotdeal_layout2

//        swipeRefreshLayout=(SwipeRefreshLayout)rootView.findViewById(R.id.swipe_layout_home);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                try {
//                    Glide.with(context).load(MainActivity.productList.get(0).getUrl()).into(mainImage1);
//                    Glide.with(context).load(MainActivity.productList.get(1).getUrl()).into(mainImage2);
//                    Glide.with(context).load(MainActivity.productList.get(2).getUrl()).into(hdImage1);
//                    Glide.with(context).load(MainActivity.productList.get(3).getUrl()).into(hdImage2);
//                    swipeRefreshLayout.setRefreshing(false);
//                }
//                catch(Exception e){
//                    Toast.makeText(context, "데이터 연결상태를 확인하세요.", Toast.LENGTH_SHORT).show();
//                    swipeRefreshLayout.setRefreshing(false);
//                }
//            }
//        });
//
//        mainImage1 = (ImageView)rootView.findViewById(R.id.recommend_image1);
//        mainImage2 = (ImageView)rootView.findViewById(R.id.recommend_image2);
//        hdImage1 = (ImageView)rootView.findViewById(R.id.hotdeal_image1);
//        hdImage2 = (ImageView)rootView.findViewById(R.id.hotdeal_image2);
//
//        if(MainActivity.productList.size() != 0){
//            try{
//                Glide.with(this).load(MainActivity.productList.get(0).getUrl()).into(mainImage1);
//                Glide.with(this).load(MainActivity.productList.get(1).getUrl()).into(mainImage2);
//                Glide.with(this).load(MainActivity.productList.get(2).getUrl()).into(hdImage1);
//                Glide.with(this).load(MainActivity.productList.get(3).getUrl()).into(hdImage2);
//            }
//            catch(Exception e){
//                Log.v("error", "로딩 오류");
//            }
//        }
//        else{
//            mainImage1.setImageResource(R.drawable.image_loading);
//            mainImage2.setImageResource(R.drawable.image_loading);
//            hdImage1.setImageResource(R.drawable.image_loading);
//            hdImage2.setImageResource(R.drawable.image_loading);
//            Toast.makeText(getContext(), "데이터 연결상태를 확인하세요.", Toast.LENGTH_SHORT).show();
//        }
//
//
//        imageView = (LinearLayout)rootView.findViewById(R.id.recommend_product_list);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                try {
//                    builder.setTitle("데이터").setMessage
//                            ("ID : " + MainActivity.productList.get(1).getId() + "\n"
//                                    + "URL : " + MainActivity.productList.get(1).getUrl() + "\n"
//                                    + "브랜드명 : " + MainActivity.productList.get(1).getBrand_name() + "\n"
//                                    + "상품명 : " + MainActivity.productList.get(1).getProduct_name() + "\n"
//                                    + "가격 : " + MainActivity.productList.get(1).getPrice() + "\n");
//                    AlertDialog alertDialog = builder.create();
//                    alertDialog.show();
//                }
//                catch(Exception e){
//                    builder.setTitle("연결 실패").setMessage
//                            ("네트워크 연결을 확인해주세요.");
//                    AlertDialog alertDialog = builder.create();
//                    alertDialog.show();
//                }
//            }
//        });
//
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

        private void hotdeal_inti(ViewGroup rootView)
    {
        hotdeal_recyclerView = rootView.findViewById(R.id.hotdeal1_recycler);
        hotdealData1ArrayList = new ArrayList<>();
        hotDealRecyclerAdapter = new HotDealRecyclerAdapter(hotdealData1ArrayList, this);
        hotdeal_linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false); //가로
        hotdeal_recyclerView.setLayoutManager(hotdeal_linearLayoutManager);
        hotdeal_recyclerView.setAdapter(hotDealRecyclerAdapter);

        hotdealData1ArrayList.add(new HotdealData1("제품 1", R.drawable.chair1));
        hotdealData1ArrayList.add(new HotdealData1("제품 2", R.drawable.image_bed));
        hotdealData1ArrayList.add(new HotdealData1("제품 3", R.drawable.bath4));
        hotdealData1ArrayList.add(new HotdealData1("제품 4", R.drawable.image_deco));
    }

    private void recommend_inti(ViewGroup rootView)
    {
        hotdeal_recyclerView2 = rootView.findViewById(R.id.hotdeal2_recycler2);
        hotdealData2ArrayList = new ArrayList<>();
        hotDealRecyclerAdapter2 = new HotDealRecyclerAdapter2(hotdealData2ArrayList, this);
        hotdeal_linearLayoutManager2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false); //가로
        hotdeal_recyclerView2.setLayoutManager(hotdeal_linearLayoutManager2);
        hotdeal_recyclerView2.setAdapter(hotDealRecyclerAdapter2);

        hotdealData2ArrayList.add(new HotdealData2("제품 1", R.drawable.image_office));
        hotdealData2ArrayList.add(new HotdealData2("제품 2", R.drawable.image_furniture));
        hotdealData2ArrayList.add(new HotdealData2("제품 3", R.drawable.image_textile));
        hotdealData2ArrayList.add(new HotdealData2("제품 4", R.drawable.image_living));

    }

}