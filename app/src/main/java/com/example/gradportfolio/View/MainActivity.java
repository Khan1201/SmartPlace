package com.example.gradportfolio.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gradportfolio.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_menu);
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new Home()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.first_tab:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Home()).commit();
                        break;
                    case R.id.second_tab:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new MenuSearch()).commit();
                        break;
                    case R.id.third_tab:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new ShoppingBasket()).commit();
                        break;
                    case R.id.fourth_tab:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new MyPage()).commit();
                        break;
            }
                return true;
        }
        });
    }
}