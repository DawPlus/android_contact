package com.hanbit.app.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hanbit.app.contactapp.presentation.SigninActivity;
import com.hanbit.app.contactapp.presentation.SignupActivity;
import com.hanbit.app.contactapp.service.MemberService;
import com.hanbit.app.contactapp.service.MemberServiceImpl;
import com.hanbit.app.contactapp.utill.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btSignUp, btSignIn, btKaKaoStory;
    MemberService service;
    View customBar;
    private BackPressCloseHandler back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Action Bar 변경

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        customBar = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_bar, null);
        actionBar.setCustomView(customBar);
        setContentView(R.layout.activity_main);

        service = new MemberServiceImpl(this.getApplicationContext());

        btSignUp = (Button) findViewById(R.id.btSignUp);
        btSignUp.setOnClickListener(this);

        btSignIn = (Button) findViewById(R.id.btSignIn);
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SigninActivity.class));

            }
        });

        btKaKaoStory = (Button) findViewById(R.id.btKakaoStory);
        btKaKaoStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "카카오 스토리", Toast.LENGTH_LONG);
            }
        });


        back = new BackPressCloseHandler(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btSignUp:
                Toast.makeText(MainActivity.this, "Go To SignUp", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
                break;

        }


    }
}
