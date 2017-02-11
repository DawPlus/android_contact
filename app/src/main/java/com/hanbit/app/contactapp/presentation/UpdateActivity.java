package com.hanbit.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hanbit.app.contactapp.R;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etID, etName, etPhone, etAddr;
    Button btUpdate, btList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etID = (EditText) findViewById(R.id.etID);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btList = (Button) findViewById(R.id.btList);

        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btUpdate:
                break;
            case R.id.btList:
                startActivity(new Intent(UpdateActivity.this, DetailActivity.class));
                break;
        }
    }
}
