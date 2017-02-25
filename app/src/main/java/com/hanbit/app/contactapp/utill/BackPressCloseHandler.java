package com.hanbit.app.contactapp.utill;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by hanbit on 2017-02-25.
 */
public class BackPressCloseHandler {

    private long backKeyPressTime = 0;
    private Activity activity;

    public BackPressCloseHandler(Activity activity) {
        this.activity = activity;
    }

    public void onBackPressed(){
        if(System.currentTimeMillis() > backKeyPressTime + 2000 ){
            backKeyPressTime = System.currentTimeMillis();
            Toast.makeText(activity," \'뒤로\' 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_LONG).show();
        }

    }
}
