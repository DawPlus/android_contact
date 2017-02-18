package com.hanbit.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.app.contactapp.R;
import com.hanbit.app.contactapp.domain.MemberBean;
import com.hanbit.app.contactapp.service.MemberService;
import com.hanbit.app.contactapp.service.MemberServiceImpl;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tvId;
    EditText etPass, etName, etPhone, etAddr;
    Button btUpdate, btList;
    MemberService service;
    String id;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        member = new MemberBean();
        service = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = this.getIntent();
        id = intent.getExtras().getString("id");
        member.setId(id);
        member = service.findOne(member);


        tvId = (TextView) findViewById(R.id.tvID);

        etPass = (EditText)findViewById(R.id.etPass);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btList = (Button) findViewById(R.id.btList);


        // Set EditView
        tvId.setText(member.getId());
        etPass.setText(member.getPass());
        etName.setText(member.getName());
        etAddr.setText(member.getAddr());
        etPhone.setText(member.getPhone());



    btUpdate.setOnClickListener(this);
        btList.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btUpdate:

                Toast.makeText(this,"클릭",Toast.LENGTH_SHORT);
                MemberBean newMember = new MemberBean();

                newMember.setId(id);
                newMember.setName(etName.getText().toString());
                newMember.setPass(etPass.getText().toString());
                newMember.setPhone(etPhone.getText().toString());
                newMember.setAddr(etAddr.getText().toString());
                service.update(newMember);
                Log.d("회원 정보   ",newMember.toString());
                startActivity(new Intent(UpdateActivity.this, ListActivity.class));


                break;
            case R.id.btList:
                startActivity(new Intent(UpdateActivity.this, DetailActivity.class));
                break;
        }
    }
}
