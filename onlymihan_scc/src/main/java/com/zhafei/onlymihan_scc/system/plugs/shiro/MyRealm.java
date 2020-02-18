package com.zhafei.onlymihan_scc.system.plugs.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义Realm
 */
public class MyRealm extends AuthorizingRealm {
    /**
     * 授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //给资源授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission("授权字符串");
        return simpleAuthorizationInfo;
    }

    /**
     * 认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String logintype="";
        String logintoken="";
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if(!logintype.equals(token.getUsername())){
            return null;
        }
        //密码错误
        return new SimpleAuthenticationInfo("",logintoken,"");
    }
}
