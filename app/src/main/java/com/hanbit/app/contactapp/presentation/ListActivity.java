package com.hanbit.app.contactapp.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hanbit.app.contactapp.R;
import com.hanbit.app.contactapp.domain.MemberBean;
import com.hanbit.app.contactapp.service.MemberService;
import com.hanbit.app.contactapp.service.MemberServiceImpl;
import com.hanbit.app.contactapp.utill.MemberAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    MemberService service;
    ListView lvMemberlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        service = new MemberServiceImpl(this.getApplicationContext());

        lvMemberlist = (ListView) findViewById(R.id.lvMemberlist);


        ArrayList<MemberBean> list = service.list();


        lvMemberlist.setAdapter(new MemberAdapter(list, this));
        lvMemberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {


                MemberBean member = (MemberBean) lvMemberlist.getItemAtPosition(i);

                //Intent
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getId());

                startActivity(intent);

            }
        });



        lvMemberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {


                final MemberBean member = (MemberBean) lvMemberlist.getItemAtPosition(i);

                 new AlertDialog.Builder(ListActivity.this)
                         .setTitle("삭제 ? ")
                         .setMessage("정말로 삭제 하시겟습니까? ")
                         .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                             /// YES
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 service.delete(member);

                                 Intent intent = new Intent(ListActivity.this, ListActivity.class);
                                 startActivity(intent);


                             }
                         })
                         .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                             // No
                             @Override
                             public void onClick(DialogInterface dialog, int which) {

                             }
                         }).show();
                return true;
            }
        });

    }
}
