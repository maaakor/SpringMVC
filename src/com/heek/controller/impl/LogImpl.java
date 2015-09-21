package com.heek.controller.impl;

import Service.LogService;
import model.LogEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huangfei on 2015/8/31.
 */
@Transactional
public class LogImpl extends BaseImpl implements LogService {
    public static String LOG = "LogEntity";

    @Override
    public List getAllLog() {
        List list = this.findAll(LogEntity.class, LOG);

        return list;
    }

    @Override
    public List getLogByTime(String start, String end) {

        List list = this.getLogByTime(start, end);

        return null;
    }


    @Override
    public LogEntity getLog(LogEntity log) {

        return (LogEntity) this.findObjectById(LogEntity.class, Long.parseLong(log.getId() + ""));
    }

    //����ط�Ҫ��envict����,ò����һ����Ҫ����Id,����һ������Ҫ
    //�������Ӧ������ҪID��,��Ϊ�漰��update
    @Rollback(false)
    @Override
    public void saveOrUpdate(LogEntity log) {
        //session.clear();
        //this.save(log);
        //�������Ҫ��ID
       //  session.update(log);
        session.saveOrUpdate(log);
        //session.merge(log);
       // commit();
        //session.persist(log);

    }

    @Override
    public void batchSaveOrUpdate(List<LogEntity> logEntities) {

        session.saveOrUpdate(logEntities);
    }

    public void save(LogEntity log) {
        session.save(log);
    }

    /*
    *template batchUpdate
    * */
    public void templateBactchUpdateOrSave(List<Object[]> logEntities, String sql) {
        //String saveSql="insert into tables(id...) values(?,?) "
        getJdbcTemplate().batchUpdate(sql, logEntities);
    }


}
