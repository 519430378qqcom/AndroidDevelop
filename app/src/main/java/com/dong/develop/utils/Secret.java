package com.dong.develop.utils;

/**
 * @author: CuiDong
 * @date: 2017/8/2
 * @version: 1.0.0
 * @email: dgsimle@sina.com
 * @desc: 存放key等私密信息
 */

public class Secret {
    static {
        System.loadLibrary("secret");
    }

    /**
     * 获取友盟统计的appkey
     * @return
     */
    public static native String getUmkey();
}
