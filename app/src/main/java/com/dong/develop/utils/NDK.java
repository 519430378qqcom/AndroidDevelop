package com.dong.develop.utils;

/**
 * @author: CuiDong
 * @date: 2017/7/19
 * @version: 1.0.0
 * @email: dgsimle@sina.com
 * @desc: ndk开发
 */

public class NDK {
    static {
        System.loadLibrary("MyJni");
    }
    public native String getTime();
    public native String getTime1();
    public native String getTime2();
    public native String getTime3();
    public native String getTime4();
}
