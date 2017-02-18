package com.hanbit.app.contactapp.service;

import com.hanbit.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hanbit on 2017-02-04.
 */
public interface MemberService {

    //CREATE
    public void add(MemberBean bean);
    //READ ONE
    public MemberBean findOne(MemberBean bean);
    public boolean login(MemberBean bean);

    //READ SOME
    public ArrayList<MemberBean> findSome(String keyword);
    //READ ALL
    public ArrayList<MemberBean> list();
    //UPDATE
    public void update(MemberBean bean);
    //DELETE
    public void delete(MemberBean bean);


}
