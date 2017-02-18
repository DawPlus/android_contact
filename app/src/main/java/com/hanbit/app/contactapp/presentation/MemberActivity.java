package com.hanbit.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hanbit.app.contactapp.R;
import com.hanbit.app.contactapp.domain.MemberBean;
import com.hanbit.app.contactapp.service.MemberService;
import com.hanbit.app.contactapp.service.MemberServiceImpl;

public class MemberActivity extends AppCompatActivity implements View.OnClickListener {


    Button btAdd, btFindById, btFindByName, btList, btUpdate, btDelte;
    MemberBean member;
    MemberService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        btAdd = (Button) findViewById(R.id.btAdd);
        btFindById = (Button) findViewById(R.id.btFindById);
        btFindByName = (Button) findViewById(R.id.btFindByName);
        btList = (Button) findViewById(R.id.btList);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelte = (Button) findViewById(R.id.btDelte);

        btAdd.setOnClickListener(this);
        btFindById.setOnClickListener(this);
        btFindByName.setOnClickListener(this);
        btList.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelte.setOnClickListener(this);

        member = new MemberBean();
        service = new MemberServiceImpl(this.getApplicationContext());

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btAdd:
                service.add(member);
                break;
            case R.id.btFindById:
                service.findOne(member);
                break;
            case R.id.btFindByName:
                service.findSome("");
                break;
            case R.id.btList:
                service.list();
                break;
            case R.id.btUpdate:
                service.update(member);
                break;
            case R.id.btDelte:
                service.delete(member);
                break;

        }


    }
}
