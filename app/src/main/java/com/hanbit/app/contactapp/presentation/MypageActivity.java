package com.hanbit.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.hanbit.app.contactapp.R;

public class MypageActivity extends AppCompatActivity {


    TextView tvID,  tvName, tvPhone,  tvAddr;
    Button btnMessage, btAlbum, btnSchedul, btUpdate, btUnRegist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
    }
}
