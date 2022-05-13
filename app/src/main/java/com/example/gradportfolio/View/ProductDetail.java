package com.example.gradportfolio.View;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.gradportfolio.R;

public class ProductDetail extends AppCompatActivity {

    private  Intent intent;
    private int number;
    private String title, product_name, product_price, image;

    private Button buttonAdd;
    private ImageView imageView1, imageView2, imageView3;
    private TextView textView1, textView2, textView3, textView4;

    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetail1);

        intent = getIntent();
        number = intent.getIntExtra("number", -1);
        title = intent.getStringExtra("title");
        image = intent.getStringExtra("image");
        product_name = intent.getStringExtra("product_name");
        product_price = intent.getStringExtra("price");



        imageView1 = findViewById(R.id.item_detail_image1);
        imageView2 = findViewById(R.id.item_detail_image2);
        imageView3 = findViewById(R.id.item_detail_image3);

        buttonAdd = findViewById(R.id.basket_add_button);

        textView1 = findViewById(R.id.item_detail_text1);
        textView2 = findViewById(R.id.item_detail_text2);
        textView3 = findViewById(R.id.item_detail_text3);
        textView4 = findViewById(R.id.item_detail_text4);



        switch (number)
        {
            case 0: //1인 원룸 휴대용 욕조

                Glide.with(MenuSearch.ct).load(image).into(imageView1);//클릭 시 가져오는 이미지

                textView1.setText(title); // 클릭 시 가져오는 타이틀

                textView2.setText(product_name); // 클릭 시 가져오는 제품 이름

                textView3.setText(product_price);

                textView4.append("제작사 : DCU\n");
                textView4.append("판매처 : Smart Place");

                imageView2.setImageResource(R.drawable.bath2);

                imageView3.setImageResource(R.drawable.bath3);
                break;

            case 1: // 일반 헤드형 수납 침대

                Glide.with(MenuSearch.ct).load(image).into(imageView1);//클릭 시 가져오는 이미지

                textView1.setText(title);
                textView2.setText(product_name);

                Glide.with(ShoppingBasket.ct).load(image).into(imageView1);//클릭 시 가져오는 이미지

                textView1.setText(title); // 클릭 시 가져오는 타이틀

                textView2.setText(product_name); // 클릭 시 가져오는 제품 이름

                textView3.setText(product_price);

                textView4.append("제작사 : DCU\n");
                textView4.append("판매처 : Smart Place");

                imageView2.setImageResource(R.drawable.bath2);

                imageView3.setImageResource(R.drawable.bath3);
                break;

            case 2://심플 검은말 장식품  2P
                Glide.with(MenuSearch.ct).load(image).into(imageView1);//클릭 시 가져오는 이미지
                textView1.setText(title);
                textView2.setText(product_name);
                textView1.append("\n");
                textView3.setText(product_price);

                textView4.append("제작사 : DCU\n");
                textView4.append("판매처 : Smart Place");

                imageView2.setImageResource(R.drawable.bath2);

                imageView3.setImageResource(R.drawable.bath3);

                break;

            case 3://고급 1인용 사무실 의자
                Glide.with(MenuSearch.ct).load(image).into(imageView1);//클릭 시 가져오는 이미지
                textView1.setText(title);
                textView2.setText(product_name);
                textView3.setText(product_price);

                textView4.append("제작사 : DCU\n");
                textView4.append("판매처 : Smart Place");
                imageView2.setImageResource(R.drawable.ic_launcher_background);

                imageView3.setImageResource(R.drawable.ic_launcher_background);

                break;

            case 4://가정용 4구 레인지
                Glide.with(MenuSearch.ct).load(image).into(imageView1);//클릭 시 가져오는 이미지
                textView1.setText(title);
                textView2.setText(product_name);
                textView1.append("\n");
                textView3.setText(product_price);

                textView4.append("제작사 : DCU\n");
                textView4.append("판매처 : Smart Place");
                imageView2.setImageResource(R.drawable.ic_launcher_background);

                imageView3.setImageResource(R.drawable.ic_launcher_background);
                break;

            case 5://사무용 6인 책상 블루
                Glide.with(MenuSearch.ct).load(image).into(imageView1);//클릭 시 가져오는 이미지
                textView1.setText(title);
                textView2.setText(product_name);
                textView1.append("\n");
                textView3.setText(product_price);

                textView4.append("제작사 : DCU IT\n");
                textView4.append("판매처 : Smart Place");
                imageView2.setImageResource(R.drawable.ic_launcher_background);

                imageView3.setImageResource(R.drawable.ic_launcher_background);

                break;

            case 6://3단 가정용 서랍
                Glide.with(MenuSearch.ct).load(image).into(imageView1);//클릭 시 가져오는 이미지
                textView1.setText(title);
                textView2.setText(product_name);
                textView1.append("\n");
                textView3.setText(product_price);

                textView4.append("제작사 : DCU IT2\n");
                textView4.append("판매처 : Smart Place");
                imageView2.setImageResource(R.drawable.ic_launcher_background);

                imageView3.setImageResource(R.drawable.ic_launcher_background);
                break;


        }

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("url",image);
                values.put("brand_name",title);
                values.put("product_name",product_name);
                values.put("price", product_price);
                MainActivity.db.insert("ShoppingBasket",null,values);
            }
        });
    }




}
