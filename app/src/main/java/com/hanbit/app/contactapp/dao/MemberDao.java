package com.hanbit.app.contactapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hanbit.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hanbit on 2017-02-11.
 */
public class MemberDao extends SQLiteOpenHelper {


    public MemberDao(Context context) {
       // super(context);
        // (Context , DB 주소값 , 내장형 쓸래 말래  , DB 버전전 )
        super(context, "hanbit.db", null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = String.format("%s", "CREATE TABLE IF NOT EXISTS Member( " +
                "id text(20) PRIMARY KEY, " +
                "pass text(20), " +
                "name text(20), " +
                "email text(20), " +
                "phone text(20), " +
                "addr text(20), " +
                "profile text(20) " +
                ")");

        db.execSQL(sql);


        db.execSQL("CREATE TABLE IF NOT EXISTS Message(\n" +
                "  \t _id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    sender TEXT(20),\n" +
                "    receiver TEXT(20),\n" +
                "    content TEXT(20),\n" +
                "    writeTime TEXT(20),\n" +
                "    id TEXT(20),\n" +
                "    FOREIGN KEY(id) REFERENCES Member(id)\n" +
                ");\n");

/*


        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,profile, addr)\n" +
                "VALUES('hong','1','홍길동','hong@test.com','010-1234-5678','default','서울');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone,profile, addr)\n" +
                "VALUES('kim','1','김유신','kim@test.com','010-1234-5678','default','서울');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone, profile, addr)\n" +
                "VALUES('lee','1','이순신','lee@test.com','010-1234-5678','default','서울');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone, profile, addr)\n" +
                "VALUES('park','1','박지성','park@test.com','010-1234-5678','default','부산');");
        db.execSQL("INSERT INTO Member(id,pass,name,email,phone, profile, addr)\n" +
                "VALUES('yoo','1','유비','yoo@test.com','010-1234-5678','default','인천');");
*/


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //CREATE
    public void add(MemberBean bean) {

        String sql = String.format("INSERT INTO Member " +
                        "(id, pass, name, email,phone, addr, profile) " +
                        "VALUES('%s','%s','%s','%s','%s','%s','%s')"
                , bean.getId(), bean.getPass(), bean.getName(), bean.getEmail(),bean.getPhone(), bean.getAddr(), bean.getProfile()
        );

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();


    }

    //READ ONE
    public MemberBean SelectOne(MemberBean bean) {

        MemberBean member=new MemberBean();
        String sql=String.format("SELECT id,pass,name,email,phone,profile,addr " +
                " FROM Member WHERE id = '%s';",bean.getId());
        Log.d("login SQL:",sql);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            Log.d("ID 결과:",cursor.getString(0));
            member.setId(cursor.getString(0));
            member.setPass(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setProfile(cursor.getString(5));
            member.setAddr(cursor.getString(6));
        }else{
            member.setId("fail");
        }
        Log.d("login result:",member.getId());
        return member;



    }

    //READ SOME
    public  ArrayList<MemberBean> selectSome(String keyword) {

        ArrayList<MemberBean> list = new ArrayList<MemberBean>();


        String sql = String.format("SELECT  id, pass, name, email, phone, addr, profile " +
                " FROM Member WHERE name= '%s' ", keyword);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        if(cursor != null){
            cursor.moveToFirst();
        }
        do{
            MemberBean member = new MemberBean();


            member.setId(cursor.getString(0));

            member.setPass(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setAddr(cursor.getString(5));
            member.setProfile(cursor.getString(6));

            list.add(member);
        }while(cursor.moveToNext());

        Log.d("member Size",String.valueOf(list.size()));




        return list;

    }

    //READ ALL
    public ArrayList<MemberBean> selectAll() {


        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        String sql = "SELECT  id, pass, name, email, phone, addr, profile "
                + " FROM Member";


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        if(cursor != null){
            cursor.moveToFirst();
        }
        do{
            MemberBean member = new MemberBean();


            member.setId(cursor.getString(0));

            member.setPass(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setAddr(cursor.getString(5));
            member.setProfile(cursor.getString(6));

            list.add(member);
        }while(cursor.moveToNext());

            Log.d("member Size",String.valueOf(list.size()));




        return list;
    }

    //UPDATE
    public void update(MemberBean bean) {

        String sql = String.format("UPDATE Member " +
                        " SET pass = '%s'" +
                        ",phone = '%s' " +
                        ",addr = '%s' " +
                        ",profile = '%s' " +
                        " WHERE id='%s'",
                bean.getPass(), bean.getPhone(), bean.getAddr(), bean.getProfile(), bean.getId()
        );

        Log.d("update SQL:",sql);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    //DELETE
    public void delete(MemberBean bean) {

        String sql = String.format("DELETE FROM MEMBER WHERE id ='%s'", bean.getId());


        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

}
