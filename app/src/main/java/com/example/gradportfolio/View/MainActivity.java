package com.example.gradportfolio.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.gradportfolio.R;
import com.example.gradportfolio.View.MypageLogin;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

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
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new MypageLogin()).commit();
                        break;
            }
                return true;
        }
        });
    }

}