package com.heek.controller;

import Service.LogService;
import Service.UserService;
import model.LogEntity;
import model.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by huangfei on 2015/6/21.
 */
@Component
@Controller
public class UserController {

    UserService userService;
    LogService logService;

    public LogService getLogService() {
        return logService;
    }

    @Resource
    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request) {

        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
        UserService s = (UserService) context.getBean("userService");
       // userService.add();
        return "index";
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String admin(ModelAndView view) {

        return "admin";
    }


    @RequestMapping(value = "json", method = RequestMethod.GET)
    @ResponseBody
    public UserEntity json() {
        UserEntity u = new UserEntity();
        u.setName("huangfei");
        userService.add(u);
        return u;
    }

    @RequestMapping(value = "string", method = RequestMethod.GET)
    public String obj() {

        return "admin/register";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    public Object login(String username, String password) {

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("username", username);
        data.put("password", password);
        List list = userService.getUserByParam(data);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return "fail";
    }

    LogEntity log;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    @ResponseBody
    public Object register(UserEntity u) {

        List list = new ArrayList();
        u.setId(2);
        list.add(u);
        List<Object[]> data = new ArrayList<Object[]>();

        Object[] obj = list.toArray();
        data.add(obj);
        userService.addUser(data);

        return "fail";
    }

}
