package com.hanbit.app.contactapp.utill;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hanbit.app.contactapp.MainActivity;
import com.hanbit.app.contactapp.R;

public class IntroActivity extends AppCompatActivity {


    TextView intro_txt;
    ProgressBar pg_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_intro);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        },2000);

    }


    @Override
    protected void onStart() {
        super.onStart();
    }
}
