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
    public static native String getTime();
    public static native String getTime1();
}
