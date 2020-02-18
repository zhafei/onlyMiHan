package com.zhafei.onlymihan_scc.system.service;

import com.zhafei.onlymihan_scc.system.model.MhUser;
import com.zhafei.onlymihan_scc.system.model.MhUserExample;
import com.zhafei.onlymihan_scc.system.utils.MessageBox;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息操作接口
 */
public interface MhUserService {

    /**
     * 根据条件查询记录总数
     */
    public int countByExample(MhUserExample example);

    /**
     * 根据条件注销用户
     */
    public MessageBox deleteMhUserByExample(MhUserExample example);

    /**
     * 新增用户
     */
    public MessageBox insertMhUser(MhUser record);

    /**
     * 根据条件查询用户信息
     */
    public List<MhUser> selectMhUserByExample(MhUserExample example);

    /**
     * 根据条件修改用户信息
     */
    public int updateMhUserByExample(@Param("record") MhUser record, @Param("example") MhUserExample example);
}
