package com.heek.controller.impl;

import model.UserEntity;
import org.hibernate.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by huangfei on 2015/6/22.
 */
@Component
public class BaseImpl implements Serializable {

    SessionFactory sessionFactory;

    Session session;
    //初始化dataSource
    DataSource dataSource;
    //初始化jdbcTemplate
    JdbcTemplate jdbcTemplate;

    //提交事务
    Transaction tx;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return session;
    }


    //TODO different version  with different way to seesion
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        //hibernate3 obtain session
        // this.session = sessionFactory.getCurrentSession();
        //hibernate4 obtain session
        this.session = sessionFactory.openSession();
      //  this.session = sessionFactory.getCurrentSession();
        tx = session.beginTransaction();
    }


    public void save(Object o) {
        //sessionFactory.openSession().save(o);
//        try {
//            Connection conn = dataSource.getConnection();
//            PreparedStatement preparedStatement = conn.prepareStatement();
//            preparedStatement.executeUpdate("INSERT INTO ");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        session.save(o);
        session.flush();
    }

    public void saveOrUpdate(Collection collection) {
        session.saveOrUpdate(collection);
        commit();
    }

    public void jdbcSave(String sql) {
        jdbcTemplate.update(sql);
    }

    public List queryForList(String sql) {


        return session.createQuery(sql).list();
    }

    public List jdbcQueryForList(String sql) {

        return jdbcTemplate.queryForList(sql);
    }


    public void delete(Collection collection) {
        session.delete(collection);
        session.flush();
    }

    public void jdbcDelete(Collection collection) {

    }


    public List findAll(Class object, String obj) {
        SQLQuery query = session.createSQLQuery("SELECT * FROM " + obj).addEntity(object);
        return query.list();

    }

    public Object findObjectById(Class Object, Long id) {

        return session.byId(Object).load(id);
    }


    public void commit() {
        tx.commit();
//        session.flush();
    }


}
