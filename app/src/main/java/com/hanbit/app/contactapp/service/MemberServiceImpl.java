package com.hanbit.app.contactapp.service;

import android.content.Context;

import com.hanbit.app.contactapp.dao.MemberDao;
import com.hanbit.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hanbit on 2017-02-04.
 */
public class MemberServiceImpl implements MemberService{

    MemberDao dao;

    public MemberServiceImpl(Context context) {

        dao = new MemberDao(context);

    }

    @Override
    public void add(MemberBean bean) {
    }
    @Override
    public MemberBean findOne(MemberBean bean) {

     return   dao.SelectOne(bean);
    }

    @Override
    public boolean login(MemberBean member) {
        MemberBean result = this.findOne(member);
        return (!member.getId().equals("fail") && member.getPass().equals(member.getPass()));
    }

    @Override
    public ArrayList<MemberBean> findSome(String keyword) {
        return null;
    }

    @Override
    public ArrayList<MemberBean> list() {
        return null;
    }

    @Override
    public void update(MemberBean bean) {

    }

    @Override
    public void delete(MemberBean bean) {

    }
}
