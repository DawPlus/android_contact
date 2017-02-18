package com.hanbit.app.contactapp.service;

import com.hanbit.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hanbit on 2017-02-04.
 */
public interface MemberService {

    //CREATE
    void add(MemberBean bean);
    //READ ONE
    MemberBean findOne(MemberBean bean);
    //READ SOME
    ArrayList<MemberBean> findSome(String keyword);
    //READ ALL
    ArrayList<MemberBean> list();
    //UPDATE
    void update(MemberBean bean);
    //DELETE
    void delete(MemberBean bean);


}
