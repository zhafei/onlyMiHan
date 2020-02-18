package com.zhafei.onlymihan_scc.system.controller;

import com.alibaba.fastjson.JSON;
import com.zhafei.onlymihan_scc.system.model.MhUser;
import com.zhafei.onlymihan_scc.system.service.impl.MhUserServiceImpl;
import com.zhafei.onlymihan_scc.system.utils.MessageBox;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/loginCtrl")
public class LoginCtrl {
    private static final Logger logger = Logger.getLogger(LoginCtrl.class);
    @Autowired
    private MhUserServiceImpl mhUserService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String logintype = request.getParameter("logintype");
        String logintoken = request.getParameter("logintoken");
        MessageBox box = new MessageBox();
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(logintype, logintoken);
        //执行登录方法
        try{
            subject.login(token);//走Realm认证
        }catch (UnknownAccountException e){
            logger.info("用户名不存在");
            box.setMessage("用户名不存在");
        }catch (IncorrectCredentialsException e){
            logger.info("密码错误");
            box.setMessage("密码错误");
        }

        return JSON.toJSONString(box);
    }

    @ResponseBody
    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        String logintype = request.getParameter("logintype");
        String logintoken = request.getParameter("logintoken");
        MhUser userVO = new MhUser();
        userVO.setLogintype(logintype);
        userVO.setLogintoken(logintoken);
        logger.info("参数>>>>>>>>>>>>>>" + JSON.toJSON(userVO));
        MessageBox box = mhUserService.insertMhUser(userVO);

        return JSON.toJSONString(box);
    }
}
