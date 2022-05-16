package com.example.gradportfolio.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradportfolio.Presenter.CategoryRecyclerAdapter;
import com.example.gradportfolio.Presenter.SearchRecyclerAdapter;
import com.example.gradportfolio.Presenter.SearchRecyclerAdapter2;
import com.example.gradportfolio.R;
import com.example.gradportfolio.View.MainActivity;

import java.util.ArrayList;

public class Category_1 extends AppCompatActivity {
    private  Intent intent;
    private  int number;
    private String img_name;
    private TextView textView1;



    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_1);
        intent = getIntent();
        number = intent.getIntExtra("number", -1);
        img_name = intent.getStringExtra("img_name");

        RecyclerView recyclerView = findViewById(R.id.category_recyclerview);
        ArrayList<CategoryData> productItemArrayList = new ArrayList<>();
       CategoryRecyclerAdapter categoryRecyclerAdapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        categoryRecyclerAdapter = new CategoryRecyclerAdapter(productItemArrayList, this);
        recyclerView.setAdapter(categoryRecyclerAdapter);





        textView1 = findViewById(R.id.category_text1);

        switch (number)
        {
            case 0: // 욕조
                textView1.setText(img_name);




                productItemArrayList.add(new CategoryData(MainActivity.productList.get(0).getProduct_name(),MainActivity.productList.get(0).getBrand_name(), MainActivity.productList.get(0).getPrice(),MainActivity.productList.get(0).getUrl()));
                productItemArrayList.add(new CategoryData(MainActivity.productList.get(1).getProduct_name(),MainActivity.productList.get(1).getBrand_name(), MainActivity.productList.get(1).getPrice(),MainActivity.productList.get(1).getUrl()));
                productItemArrayList.add(new CategoryData(MainActivity.productList.get(2).getProduct_name(),MainActivity.productList.get(2).getBrand_name(), MainActivity.productList.get(2).getPrice(),MainActivity.productList.get(2).getUrl()));
                productItemArrayList.add(new CategoryData(MainActivity.productList.get(3).getProduct_name(),MainActivity.productList.get(3).getBrand_name(), MainActivity.productList.get(3).getPrice(),MainActivity.productList.get(3).getUrl()));



                break;


            case 1: // 침대
                textView1.setText(img_name);



                break;

            case 2: // 의자
                textView1.setText(img_name);
//                productItemArrayList.add(new CategoryData("예시 1","예시 1","예시 1",R.drawable.chair1));
//                productItemArrayList.add(new CategoryData("예시 1","예시 1","예시 1",R.drawable.chair2));
//                productItemArrayList.add(new CategoryData("예시 1","예시 1","예시 1",R.drawable.char4));
//                productItemArrayList.add(new CategoryData("예시 1","예시 1","예시 1",R.drawable.char3));
//                productItemArrayList.add(new CategoryData("예시 1","예시 1","예시 1",R.drawable.chair1));



                break;

            case 3: // 책상
                textView1.setText(img_name);

                break;

            case 4: // 가구 5
                textView1.setText(img_name);
                break;

        }

    }








}
