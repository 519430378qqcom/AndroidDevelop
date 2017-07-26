package com.dong.develop;

import android.os.Environment;
import android.os.Process;

import com.develop.core.utils.DateUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;


/**
 * @author: CuiDong
 * @date: 2017/7/21
 * @version: 1.0.0
 * @email: dgsimle@sina.com
 * @desc: 作者很懒什么都没有留下
 */

public class MyUncatchException implements Thread.UncaughtExceptionHandler {
    private String crashFilePath;

    public MyUncatchException() {
        crashFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ACrash/"
                + DateUtils.timeFormat(new Date(System.currentTimeMillis()), DateUtils.PATTERN_yMd) + ".txt";
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        File file = new File(crashFilePath);
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//        BufferedWriter bufferedWriter = null;
//        try {
//            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
//            bufferedWriter.write(e.getMessage(), 0, e.getMessage().length());
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }finally {
//            try {
//                bufferedWriter.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }
        //退出程序
        Process.killProcess(Process.myPid());
    }
}
