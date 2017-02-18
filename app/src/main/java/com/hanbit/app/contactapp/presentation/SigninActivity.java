package com.hanbit.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.app.contactapp.R;
import com.hanbit.app.contactapp.domain.MemberBean;
import com.hanbit.app.contactapp.service.MemberService;
import com.hanbit.app.contactapp.service.MemberServiceImpl;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etID, etPass;
    Button btLogin, btCancel;
    MemberService service ;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        service = new MemberServiceImpl(this.getApplicationContext());
        member = new MemberBean();

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

                String id = etID.getText().toString();
                String pass = etPass.getText().toString();

                member.setId(id);
                member.setPass(pass);

                MemberBean result = service.findOne(member);


                if("".equals(id) || "".equals(pass)){
                    return;
                }

                if(result.getPass().equals(pass)){
                    startActivity(new Intent(SigninActivity.this, ListActivity.class));

                }else{
                    startActivity(new Intent(SigninActivity.this, SigninActivity.class));
                }

                Toast.makeText(SigninActivity.this , "Go To Sign In" , Toast.LENGTH_LONG).show();
                startActivity(new Intent(SigninActivity.this, DetailActivity.class));
                break;
            case R.id.btCancel:


        }

    }
}
