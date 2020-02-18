package com.zhafei.onlymihan_scc.system.plugs.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean(name="shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器、
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器（拦截器）
        Map<String,String> filterMap =new LinkedHashMap<String,String>();
        //定义perms授权过滤器,
//        filterMap.put("","perms[授权字符串]");//走自定义授权Realm授权
        //修改跳转的登录页面
//        shiroFilterFactoryBean.setLoginUrl("");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(myRealm);
        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name="myRealm")
    public MyRealm getRealm(){
        return new MyRealm();
    }
}
