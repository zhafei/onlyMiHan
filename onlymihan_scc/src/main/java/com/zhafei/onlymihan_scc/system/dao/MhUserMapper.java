/**
*MhUserMapper.java
* @2020-02-16 Created
*/
package com.zhafei.onlymihan_scc.system.dao;

import com.zhafei.onlymihan_scc.system.model.MhUser;
import com.zhafei.onlymihan_scc.system.model.MhUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MhUserMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(MhUserExample example);

    /**
     * 根据条件删除记录
     */
    int deleteByExample(MhUserExample example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MhUser record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MhUser record);

    /**
     * 根据条件查询记录集
     */
    List<MhUser> selectByExample(MhUserExample example);

    /**
     * 根据主键查询记录
     */
    MhUser selectByPrimaryKey(String id);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByExampleSelective(@Param("record") MhUser record, @Param("example") MhUserExample example);

    /**
     * 根据条件更新记录
     */
    int updateByExample(@Param("record") MhUser record, @Param("example") MhUserExample example);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MhUser record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MhUser record);
}