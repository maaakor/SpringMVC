package com.heek.controller.impl;

import Service.UserService;
import model.LogEntity;
import model.UserEntity;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by huangfei on 2015/6/21.
 */
public class UserImpl extends BaseImpl implements UserService {


    @Override
    public void add(UserEntity u) {

        this.save(u);
        commit();
    }

    @Override
    public List getAllUser() {
        return null;
    }

    @Override
    public List getUserByParam(Map<String, Object> data) {

        List list = jdbcTemplate.queryForList("SELECT * FROM user u where u.name='" + data.get("username") + "' and u.passowrd='" + data.get("password") + "'");

        return list;
    }

    @Override
    public void addUser(List<Object[]> list) {

        String saveSql = "insert into tables user (id,name,passowrd) values(?,?,?)";
        //SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(list.toArray());

        //getJdbcTemplate().update(saveSql);
       jdbcTemplate.batchUpdate(saveSql,list);
        // session.saveOrUpdate(list.get(0));
    }
}
