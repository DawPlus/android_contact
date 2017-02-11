package com.hanbit.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hanbit.app.contactapp.R;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etID, etPass;
    Button btLogin, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        etID = (EditText) findViewById(R.id.etID);
        etPass = (EditText) findViewById(R.id.etPass);

        btLogin = (Button) findViewById(R.id.btLogin);
        btCancel = (Button) findViewById(R.id.btCancel);

        btLogin.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btLogin:
                break;
            case R.id.btCancel:
                break;

        }

    }
}
