package com.heek.controller;

import Service.LogService;
import model.LogEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huangfei on 2015/9/16.
 */
public class TestUnit {


    /**
     * classpath 指的是目录D:\SpringMVC\out\production\SpringMVC\下面的xml文件
     */
    @Test
    public void test() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:/*.xml");

        LogService log = (LogService) context.getBean("logService");
        LogEntity obj=new LogEntity();
        obj.setId(2);
        obj.setContent("测试...");
        log.saveOrUpdate(obj);

    }

}
