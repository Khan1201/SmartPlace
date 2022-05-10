package com.example.gradportfolio.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gradportfolio.Model.ProductData;
import com.example.gradportfolio.R;
import com.example.gradportfolio.View.MypageLogin;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import com.example.gradportfolio.View.Home;


public class MainActivity extends AppCompatActivity {

    static Integer page;
    BottomNavigationView bottomNavigationView;
    static RequestQueue requestQueue; // 주로 1개만 선언
    public static ArrayList<ProductData> productList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (requestQueue == null) {
            // requestQueue 초기화
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        makeRequest(); //DB접근 후 모든 DB를 객체리스트에 담아옴

        bottomNavigationView = findViewById(R.id.bottom_menu);

        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new Home()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.first_tab:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Home()).commit();
                        page = 1;
                        break;
                    case R.id.second_tab:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new MenuSearch()).commit();
                        page = 2;
                        break;
                    case R.id.third_tab:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new ShoppingBasket()).commit();
                        page = 3;
                        break;
//                    case R.id.fourth_tab:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new MypageLogin()).commit();
//                        break;
                }
                return true;
            }
        });
    }

    void makeRequest() {
        String url = "http://172.30.1.27:3000/data";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 응답 성공
                Document doc = Jsoup.parse(response);
                String text1 = doc.text();
                String text2 = text1.substring(9);
                try {
                    JSONObject jsonObject = new JSONObject(text2);
                    JSONArray jsonArray = jsonObject.getJSONArray("product");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject output = jsonArray.getJSONObject(i);
                        ProductData product = new ProductData();
                        product.setId(output.getString("id"));
                        product.setUrl(output.getString("url"));
                        product.setBrand_name(output.getString("brand_name"));
                        product.setProduct_name(output.getString("product_name"));
                        product.setPrice(output.getString("price"));
                        productList.add(product);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 응답 실패
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // POST 방식을 사용할 때 요청 파라미터를 전달하고자 할 때 사용한다.
                Map<String, String> params = new HashMap<>();
                return params;
            }
        };

        request.setShouldCache(false);  // 이전 응답 결과를 사용하지 않는다.
        requestQueue.add(request);
    }
}