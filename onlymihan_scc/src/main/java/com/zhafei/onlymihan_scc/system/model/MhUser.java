/**
*MhUser.java
* @2020-02-16 Created
*/
package com.zhafei.onlymihan_scc.system.model;

public class MhUser {
    /**
     * 主键
     */
    private String id;

    /**
     * 登录类型：1、username，2、email，3、phone，4、wechat，5、qq
     */
    private String logintype;

    /**
     * 用户唯一标识（手机号号,邮箱地址,用户名或第三方应用的唯一标识）
     */
    private String openid;

    /**
     * 登录凭证，站内的保存用户密码，站外的不保存或保存api接口的access_token凭证
     */
    private String logintoken;

    /**
     * 别名
     */
    private String nickname;

    /**
     * 头像
     */
    private String headimg;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * @return 主键
     */
    public String getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return 登录类型：1、username，2、email，3、phone，4、wechat，5、qq
     */
    public String getLogintype() {
        return logintype;
    }

    /**
     * @param logintype 
	 *            登录类型：1、username，2、email，3、phone，4、wechat，5、qq
     */
    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    /**
     * @return 用户唯一标识（手机号号,邮箱地址,用户名或第三方应用的唯一标识）
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid 
	 *            用户唯一标识（手机号号,邮箱地址,用户名或第三方应用的唯一标识）
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * @return 登录凭证，站内的保存用户密码，站外的不保存或保存api接口的access_token凭证
     */
    public String getLogintoken() {
        return logintoken;
    }

    /**
     * @param logintoken 
	 *            登录凭证，站内的保存用户密码，站外的不保存或保存api接口的access_token凭证
     */
    public void setLogintoken(String logintoken) {
        this.logintoken = logintoken;
    }

    /**
     * @return 别名
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname 
	 *            别名
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return 头像
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * @param headimg 
	 *            头像
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    /**
     * @return 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex 
	 *            性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age 
	 *            年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone 
	 *            手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 
	 *            地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
}