package com.hanbit.app.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hanbit.app.contactapp.presentation.SigninActivity;
import com.hanbit.app.contactapp.presentation.SignupActivity;
import com.hanbit.app.contactapp.service.MemberService;
import com.hanbit.app.contactapp.service.MemberServiceImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btSignUp, btSignIn;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = new MemberServiceImpl(this.getApplicationContext());


        btSignUp = (Button) findViewById(R.id.btSignUp);
        btSignIn = (Button) findViewById(R.id.btSignIn);

        btSignIn.setOnClickListener(this);
        btSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btSignIn:



                Toast.makeText(MainActivity.this, "Go To Login", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, SigninActivity.class));
                break;
            case R.id.btSignUp:
                Toast.makeText(MainActivity.this, "Go To SignUp", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
                break;

        }


    }
}
