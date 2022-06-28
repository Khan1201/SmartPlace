package com.example.gradportfolio.Model;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradportfolio.Presenter.CategoryRecyclerAdapter;
import com.example.gradportfolio.R;
import com.example.gradportfolio.View.MainActivity;

import java.util.ArrayList;

public class CategoryData1 extends AppCompatActivity {
    private  Intent intent;
    private  int number;
    private String img_name;
    private TextView textView1;



    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        intent = getIntent();
        number = intent.getIntExtra("number", -1);
        img_name = intent.getStringExtra("img_name");

        RecyclerView recyclerView = findViewById(R.id.category_recyclerview);
        ArrayList<CategoryData2> productItemArrayList = new ArrayList<>();
        CategoryRecyclerAdapter categoryRecyclerAdapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        categoryRecyclerAdapter = new CategoryRecyclerAdapter(productItemArrayList, this);
        recyclerView.setAdapter(categoryRecyclerAdapter);


        textView1 = findViewById(R.id.category_text1);

        switch (number)
        {
            case 0: // 책장
                textView1.setText(img_name);

                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(3).getProduct_name(),MainActivity.productList.get(3).getBrand_name(), MainActivity.productList.get(3).getPrice(),MainActivity.productList.get(3).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(9).getProduct_name(),MainActivity.productList.get(9).getBrand_name(), MainActivity.productList.get(9).getPrice(),MainActivity.productList.get(9).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(10).getProduct_name(),MainActivity.productList.get(10).getBrand_name(), MainActivity.productList.get(10).getPrice(),MainActivity.productList.get(10).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(12).getProduct_name(),MainActivity.productList.get(12).getBrand_name(), MainActivity.productList.get(12).getPrice(),MainActivity.productList.get(12).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(13).getProduct_name(),MainActivity.productList.get(13).getBrand_name(), MainActivity.productList.get(13).getPrice(),MainActivity.productList.get(13).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(16).getProduct_name(),MainActivity.productList.get(16).getBrand_name(), MainActivity.productList.get(16).getPrice(),MainActivity.productList.get(16).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(19).getProduct_name(),MainActivity.productList.get(19).getBrand_name(), MainActivity.productList.get(19).getPrice(),MainActivity.productList.get(19).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(21).getProduct_name(),MainActivity.productList.get(21).getBrand_name(), MainActivity.productList.get(21).getPrice(),MainActivity.productList.get(21).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(22).getProduct_name(),MainActivity.productList.get(22).getBrand_name(), MainActivity.productList.get(22).getPrice(),MainActivity.productList.get(22).getUrl()));
                break;


            case 1: // 침대
                textView1.setText(img_name);
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(1).getProduct_name(),MainActivity.productList.get(1).getBrand_name(), MainActivity.productList.get(1).getPrice(),MainActivity.productList.get(1).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(2).getProduct_name(),MainActivity.productList.get(2).getBrand_name(), MainActivity.productList.get(2).getPrice(),MainActivity.productList.get(2).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(5).getProduct_name(),MainActivity.productList.get(5).getBrand_name(), MainActivity.productList.get(5).getPrice(),MainActivity.productList.get(5).getUrl()));
                break;

            case 2: // 의자
                textView1.setText(img_name);
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(6).getProduct_name(),MainActivity.productList.get(6).getBrand_name(), MainActivity.productList.get(6).getPrice(),MainActivity.productList.get(6).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(8).getProduct_name(),MainActivity.productList.get(8).getBrand_name(), MainActivity.productList.get(8).getPrice(),MainActivity.productList.get(8).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(14).getProduct_name(),MainActivity.productList.get(14).getBrand_name(), MainActivity.productList.get(14).getPrice(),MainActivity.productList.get(14).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(18).getProduct_name(),MainActivity.productList.get(18).getBrand_name(), MainActivity.productList.get(18).getPrice(),MainActivity.productList.get(18).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(23).getProduct_name(),MainActivity.productList.get(23).getBrand_name(), MainActivity.productList.get(23).getPrice(),MainActivity.productList.get(23).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(24).getProduct_name(),MainActivity.productList.get(24).getBrand_name(), MainActivity.productList.get(24).getPrice(),MainActivity.productList.get(24).getUrl()));
                break;

            case 3: // 책상
                textView1.setText(img_name);
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(4).getProduct_name(),MainActivity.productList.get(4).getBrand_name(), MainActivity.productList.get(4).getPrice(),MainActivity.productList.get(4).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(7).getProduct_name(),MainActivity.productList.get(7).getBrand_name(), MainActivity.productList.get(7).getPrice(),MainActivity.productList.get(7).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(11).getProduct_name(),MainActivity.productList.get(11).getBrand_name(), MainActivity.productList.get(11).getPrice(),MainActivity.productList.get(11).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(15).getProduct_name(),MainActivity.productList.get(15).getBrand_name(), MainActivity.productList.get(15).getPrice(),MainActivity.productList.get(15).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(17).getProduct_name(),MainActivity.productList.get(17).getBrand_name(), MainActivity.productList.get(17).getPrice(),MainActivity.productList.get(17).getUrl()));
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(20).getProduct_name(),MainActivity.productList.get(20).getBrand_name(), MainActivity.productList.get(20).getPrice(),MainActivity.productList.get(20).getUrl()));
                break;

            case 4: // 욕조
                textView1.setText(img_name);
                productItemArrayList.add(new CategoryData2(MainActivity.productList.get(0).getProduct_name(),MainActivity.productList.get(0).getBrand_name(), MainActivity.productList.get(0).getPrice(),MainActivity.productList.get(0).getUrl()));
                break;
        }

    }








}