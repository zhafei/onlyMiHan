package com.zhafei.onlymihan_scc.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhafei.onlymihan_scc.system.dao.MhUserMapper;
import com.zhafei.onlymihan_scc.system.model.MhUser;
import com.zhafei.onlymihan_scc.system.model.MhUserExample;
import com.zhafei.onlymihan_scc.system.service.MhUserService;
import com.zhafei.onlymihan_scc.system.utils.IDUtil;
import com.zhafei.onlymihan_scc.system.utils.MessageBox;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 用户信息操作实现类
 */
@Service
public class MhUserServiceImpl implements MhUserService {
    private static final Logger logger = Logger.getLogger(MhUserServiceImpl.class);
    @Autowired
    private MhUserMapper mhUserMapper;

    @Override
    public int countByExample(MhUserExample example) {
        return 0;
    }

    @Override
    public MessageBox deleteMhUserByExample(MhUserExample example) {
        return null;
    }

    @Override
    public MessageBox insertMhUser(MhUser record) {
        MessageBox box = new MessageBox();
        boolean flag = false;
        String className = Thread.currentThread().getStackTrace()[2].getClassName();//调用的类名
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();//调用的方法名
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();//调用的行数
        logger.info("执行方法："+className+"."+methodName);

        String uuid = IDUtil.getUUID();
        record.setId(uuid);
        logger.info("参数>>>>>>>>>>>>>>"+ JSON.toJSON(record));
        flag = mhUserMapper.insertSelective(record) > 0;
        if(flag){
            box.setOjbk(flag);
            box.setMessage(MessageBox.DES_OK);
        }
        box.setMethodName(className+"."+methodName);
        return box;
    }

    @Override
    public List<MhUser> selectMhUserByExample(MhUserExample example) {
        return null;
    }

    @Override
    public int updateMhUserByExample(MhUser record, MhUserExample example) {
        return 0;
    }
}
