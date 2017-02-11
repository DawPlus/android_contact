package com.hanbit.app.contactapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hanbit.app.contactapp.domain.MemberBean;

import java.util.ArrayList;
/**
 * Created by hanbit on 2017-02-11.
 */
public class MemberDao extends SQLiteOpenHelper {


    public MemberDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = String.format("%s","CREATE TABLE Member( " +
                "id text(10) PRIMARY KEY, " +
                "password text(10), " +
                "name text(10), " +
                "phone text(13), " +
                "addr text(10), " +
                "profile text(10) " +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




    //CREATE
    void add(MemberBean bean) {

        String sql = String.format("INSERT INTO Member " +
                        "(id, password, name, phone, addr, profile) " +
                        "VALUES('%s','%s','%s','%s','%s','%s')"
                , bean.getId(), bean.getPassword(), bean.getName(), bean.getPhone(), bean.getAddr(), bean.getProfile()
        );


    }

    //READ ONE
    MemberBean SelectOne(MemberBean bean) {

        String sql = String.format("SELECT  id, password, name, phone, addr, profile " +
                " FROM Member WHERE id= '%s' ", bean.getId());

        return new MemberBean();

    }

    //READ SOME
    ArrayList<MemberBean> selectSome(String keyword) {


        String sql = String.format("SELECT  id, password, name, phone, addr, profile " +
                " FROM Member WHERE name= '%s' ", keyword);


        return new ArrayList<MemberBean>();
    }

    //READ ALL
    ArrayList<MemberBean> selectAll() {

        String sql = "SELECT  id, password, name, phone, addr, profile "
                + " FROM Member";


        return new ArrayList<MemberBean>();
    }

    //UPDATE
    void update(MemberBean bean) {

        String sql = String.format("UPDATE Member " +
                " SET pass = '%s'" +
                    ",phone = '%s' " +
                    ",addr = '%s' " +
                    ",profile = '%s' " +
                " WHERE id='%s'",
                bean.getPassword(), bean.getPhone(), bean.getAddr(),bean.getProfile()
                );
    }

    //DELETE
    void delete(MemberBean bean) {

        String sql = String.format("DELETE FROM MEMBER WHERE id ='%s", bean.getId());

    }

}
