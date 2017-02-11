package com.hanbit.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.app.contactapp.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvID,  tvName, tvPhone,  tvAddr;
    Button btnMessage, btPhone, btLocation , btDelete;
    Button btUpdate, btList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btList = (Button) findViewById(R.id.btList);

        tvID = (TextView) findViewById(R.id.tvID);
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvAddr = (TextView) findViewById(R.id.tvAddr);

        btnMessage = (Button) findViewById(R.id.btnMessage);
        btDelete = (Button)findViewById(R.id.btDelete);
        btPhone = (Button) findViewById(R.id.btPhone);
        btLocation = (Button) findViewById(R.id.btLocation);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btList = (Button) findViewById(R.id.btList);


        btnMessage.setOnClickListener(this);
        btPhone.setOnClickListener(this);
        btLocation.setOnClickListener(this);
        btDelete.setOnClickListener(this);

        btUpdate.setOnClickListener(this);
        btList.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnMessage :
                break;

            case R.id.btPhone :
                break;

            case R.id.btLocation :
                break;

            case R.id.btUpdate:
                Toast.makeText(DetailActivity.this, "go To SignIn", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", "hong");
                startActivity(intent);
                break;

            case R.id.btList:
                Toast.makeText(DetailActivity.this, "go To List", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;

        }


    }
}
