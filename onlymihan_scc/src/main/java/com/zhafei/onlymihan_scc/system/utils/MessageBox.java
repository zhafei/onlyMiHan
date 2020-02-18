package com.zhafei.onlymihan_scc.system.utils;

import java.io.Serializable;

/**
 * 函数方法执行结果返回对象
 */
public class MessageBox implements Serializable{ 
	private static final long serialVersionUID = 1L;

	/** 方法执行成功. */
	public static final String DES_OK = "执行成功";
	
	/** 方法执行失败. */
	public static final String DES_FAIL = "执行失败";
	
	/** 新增执行. */
	public static final String DES_ADD_OK = "新增成功";
	
	/** 新增失败. */
	public static final String DES_ADD_FAIL = "新增失败";
	
	/** 修改成功. */
	public static final String DES_UPDATE_OK = "修改成功";
	
	/** 修改失败. */
	public static final String DES_UPDATE_FAIL = "修改失败";
	
	/** 删除成功. */
	public static final String DES_DEL_OK = "删除成功";
	
	/** 删除失败. */
	public static final String DES_DEL_FAIL = "删除失败";
	
	
	/** 函数执行是否成功. */
	private boolean isOjbk = false;
	
	/** 执行情况说明. */
	private String message = "";
	
	/** 执行方法名称. */
	private String methodName = "";

	/**业务数据*/
	private String data = "";
	/**
	 * 判断是否执行成功
	 *
	 * @return true, if is success
	 */
	public boolean isOjbk() {
		return isOjbk;
	}
	/**
	 * 设置函数执行是否成功.
	 *
	 * @param ojbk 设置为 success
	 */
	public void setOjbk(boolean ojbk) {
		isOjbk = ojbk;
	}
	/**
	 * 获得执行方法.
	 *
	 * @return methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * 设置执行方法.
	 *
	 * @param
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * 获得执行情况说明.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置执行情况说明.
	 *
	 * @param
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 获得方法返回的业务数据
	 *
	 * @return data
	 */
	public String getData() {
		return data;
	}

	/**
	 * 设置方法执行数据
	 *
	 * @param data
	 */
	public void setObj(String data) {
		this.data = data;
	}

}
