package com.example.gradportfolio.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gradportfolio.R;

public class MypageLogin extends Fragment {

    Context ct;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_mypage_login, container, false);
        ct = container.getContext().getApplicationContext();
        Button sign_up = rootView.findViewById(R.id.login_sign_up_button);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ct, MyPageLogined.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}