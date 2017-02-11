package com.hanbit.app.contactapp.dao;

import com.hanbit.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hanbit on 2017-02-11.
 */
public class MemberDao {


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
    }

    //DELETE
    void delete(MemberBean bean) {
    }


}
