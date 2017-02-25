package com.hanbit.app.contactapp.presentation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.app.contactapp.R;

public class MessageActivity extends AppCompatActivity {

    TextView tvToSms;
    EditText etMessage;
    Button btSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


        tvToSms = (TextView) findViewById(R.id.tvToSms);
        etMessage = (EditText) findViewById(R.id.etMessage);
        btSend = (Button) findViewById(R.id.btSend);

        String phoneNo = this.getIntent().getExtras().getString("phone");

        btSend.setOnClickListener((View)->{sendSMS();});



    }

    protected void sendSMS() {

        String telNo = tvToSms.getText().toString();
        Uri smsUri= Uri.parse("tel:"+telNo);
        Intent smsIntent = new Intent(Intent.ACTION_VIEW, smsUri);

        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", telNo);
        smsIntent.putExtra("sms_body", etMessage.getText().toString());

        try{
            startActivity(smsIntent);
            finish();
        }catch(Exception e){

            Toast.makeText(MessageActivity.this,"SMS Fail",Toast.LENGTH_LONG).show();
        }


    }
}
