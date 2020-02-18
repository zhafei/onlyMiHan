package com.zhafei.onlymihan_scc.system.common;

import com.zhafei.onlymihan_scc.system.utils.StrUtil;
import com.zhafei.onlymihan_scc.system.utils.UnderlineToCamel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公用条件查询类 用于查询集合对象时构造SQl语句的过滤条件
 */
public class Criteria implements Serializable {

	private static final long serialVersionUID = -3235609856621308967L;

	/** 存放查询条件参数、值对象集合. */
	private Map<String, Object> condition;
	
	/** 批量操作条件集合适用于大数据事物操作*/
	private Map<String, List<String>> conditionList;

	/** 是否相异. */
	protected boolean distinct;

	/** 排序字段. */
	protected String orderByClause;
	/** 排序方式. */
	protected String orderByType;

	/** 开始记录数 */
	private Integer oracleStart;

	/** 结束记录数. */
	private Integer oracleEnd;
	
	/** 当前查看页数 */
	private Integer pageNo;
	/** 每页条数 */
	private Integer pageSize;

	public Criteria() {
		condition = new HashMap<String, Object>();
	}

	protected Criteria(Criteria example) {
		if(example.orderByClause.indexOf("_")>0){
			this.orderByClause = example.orderByClause;
		}else{
			 int len = example.orderByClause.length();
			 int daxie = 0;
			 int xiaoxie = 0;
			 for(int i=0;i<len;i++){
				   char c = example.orderByClause.charAt(i);
				   if (Character.isUpperCase(c)) {
					  daxie ++;
				   }else{
					  xiaoxie ++;
				   }
			 }
			 if(daxie==0||xiaoxie==0){
				 this.orderByClause = example.orderByClause;
			 }else{
				 this.orderByClause = UnderlineToCamel.camelToUnderline(example.orderByClause);
			 }
		}
//		this.orderByClause = example.orderByClause;
		this.condition = example.condition;
		this.conditionList = example.conditionList;
		this.distinct = example.distinct;
		this.oracleStart = example.oracleStart;
		this.oracleEnd = example.oracleEnd;
		this.orderByType = example.orderByType;
		
	}

	public void clear() {
		condition.clear();
		conditionList.clear();
		orderByClause = null;
		orderByType = null;
		distinct = false;
		this.oracleStart = null;
		this.oracleEnd = null;
	}
	
	/**
	 * 获得查询条件对象集合
	 * 
	 * @return the condition
	 */
	public Map<String, List<String>> getConditionList() {
		return conditionList;
	}
	
	/**
	 * @param conditionList  查询的条件名称
	 * @param value 查询的值
	 */
	public Criteria put(String conditionList, List<String> value) {
		this.conditionList.put(conditionList, value);
		return (Criteria) this;
	}

	/**
	 * 设置查询条件对象集合
	 * 
	 * @param conditionList
	 */
	public void setConditionList(Map<String, List<String>> conditionList) {
		this.conditionList = conditionList;
	}
	
	/**
	 * 获得查询条件对象集合
	 * 
	 * @return the condition
	 */
	public Map<String, Object> getCondition() {
		return condition;
	}

	/**
	 * @param condition 查询的条件名称
	 * @param value 查询的值
	 */
	public Criteria put(String condition, Object value) {
		this.condition.put(condition, value);
		return (Criteria) this;
	}

	/**
	 * 设置查询条件对象集合
	 * 
	 * @param condition
	 */
	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	/**
	 * @param distinct 是否相异
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * @param oracleEnd  结束记录数
	 */
	public void setOracleEnd(Integer oracleEnd) {
		this.oracleEnd = oracleEnd;
	}

	/**
	 * @param oracleStart 开始记录数
	 */
	public void setOracleStart(Integer oracleStart) {
		this.oracleStart = oracleStart;
	}

	/**
	 * @param orderByClause 排序字段
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	
	public String getOrderByClause() {
		if(StrUtil.isNotNull(orderByClause)){
			if(orderByClause.indexOf("_")>0){
				return orderByClause;
			}else{
				int len = orderByClause.length();
				 int daxie = 0;
				 int xiaoxie = 0;
				 for(int i=0;i<len;i++){
					   char c = orderByClause.charAt(i);
					   if (Character.isUpperCase(c)) {
						  daxie ++;
					   }else{
						  xiaoxie ++;
					   }
				 }
				 if(daxie==0||xiaoxie==0){
					 return orderByClause;
				 }else{
					 return UnderlineToCamel.camelToUnderline(orderByClause);
				 }
				
			}
		}else{
			return null;
		}
	}

	public String getOrderByType() {
		return orderByType;
	}

	public void setOrderByType(String orderByType) {
		this.orderByType = orderByType;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}