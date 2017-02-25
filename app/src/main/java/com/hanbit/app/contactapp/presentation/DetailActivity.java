package com.hanbit.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.app.contactapp.R;
import com.hanbit.app.contactapp.domain.MemberBean;
import com.hanbit.app.contactapp.service.MemberService;
import com.hanbit.app.contactapp.service.MemberServiceImpl;
import com.hanbit.app.contactapp.utill.Phone;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvID, tvName, tvPhone, tvAddr;
    Button btnMessage, btPhone, btLocation, btDelete;
    Button btUpdate, btList;
    MemberService service;
    MemberBean member;
    ImageView ivProfile;
    String id;

    Phone phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Intent
        Intent intent = this.getIntent();
        id = intent.getExtras().getString("id");
        member = new MemberBean();

        // Service
        service = new MemberServiceImpl(this.getApplicationContext());
        // Member
        member.setId(id);
        member = service.findOne(member);




        // Activity 초기화
        phone = new Phone(this, this);

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btList = (Button) findViewById(R.id.btList);

        ivProfile = (ImageView) findViewById(R.id.ivProfile);

        tvID = (TextView) findViewById(R.id.tvID);
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvAddr = (TextView) findViewById(R.id.tvAddr);

        btnMessage = (Button) findViewById(R.id.btnMessage);
        btDelete = (Button) findViewById(R.id.btDelete);
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


        tvID.setText(member.getId());
        tvName.setText(member.getName());
        tvPhone.setText(member.getPhone());
        tvAddr.setText(member.getAddr());

        int temp = getResources().getIdentifier(this.getPackageName()+":drawable/default_profile",null,null);


        ivProfile.setImageDrawable(getResources()
                                .getDrawable(temp, this.getApplicationContext().getTheme()));


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnMessage:

                Intent smsIntent = new Intent(DetailActivity.this, MessageActivity.class);
                smsIntent.putExtra("phone", member.getPhone());
                startActivity(smsIntent);

                break;

            case R.id.btPhone:
                Toast.makeText(this, "Test", Toast.LENGTH_LONG);
                phone.directCall("tel:"+member.getPhone());
                break;

            case R.id.btLocation:
                break;

            case R.id.btUpdate:
                Toast.makeText(DetailActivity.this, "go To SignIn", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;

            case R.id.btList:
                Toast.makeText(DetailActivity.this, "go To List", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;

        }


    }
}
