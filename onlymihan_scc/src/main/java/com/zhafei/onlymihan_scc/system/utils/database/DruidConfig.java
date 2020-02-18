package com.zhafei.onlymihan_scc.system.utils.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * druid连接池配置类
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return  new DruidDataSource();
    }
    /**
     * 后台监控
     */
    @Bean
    public ServletRegistrationBean statView(){
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(),"/druid/*");
        Map<String,String> initParameterMap = new LinkedHashMap<String,String>();
        //初始化设置
        initParameterMap.put("loginUsername","admin");
        initParameterMap.put("loginPassword","123456");
        //开放访问权限
        servletRegistrationBean.addInitParameter("allow","localhost");
        //禁止访问
        /**
         *...
         */
        servletRegistrationBean.setInitParameters(initParameterMap);
        return  servletRegistrationBean;
    }
}
