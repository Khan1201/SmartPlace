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
import com.example.gradportfolio.R;

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

        textView1 = findViewById(R.id.category_text1);









        switch (number)
        {
            case 0:
                textView1.setText(img_name);



                break;


            case 1:
                textView1.setText(img_name);

                break;

            case 2:
                textView1.setText(img_name);

                break;

            case 3:
                textView1.setText(img_name);

                break;

            case 4:
                textView1.setText(img_name);
                break;

        }

    }








}
