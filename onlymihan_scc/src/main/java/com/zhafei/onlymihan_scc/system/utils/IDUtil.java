package com.zhafei.onlymihan_scc.system.utils;

import java.util.UUID;

public class IDUtil {
    /**
     * 通过去除 java 产生的 uuid 中的横线并转换小写，产生 32 位纯小写的 uuid
     *
     * @return uuid
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
    /**
     * 通过去除 java 产生的 uuid 中的横线并转换小写，产生 8 位纯小写的 uuid
     *
     * @return uuid
     */
    public static String getEightbitsUUID() {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return uuid;
    }
}
