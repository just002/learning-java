package com.homer.log;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingImageViewer {

    public static void main(String[] args) {
        //进行日志设置
        if(System.getProperty("java.util.logging.config.class") == null && System.getProperty("java.util.logging.config.file") == null) {

            try {
                //Logger.getLogger("") 是所有日志记录器的父类,相当于是设置了一个全局的级别
                Logger.getLogger("").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                //%h-->系统属性user.home的值  %t-->系统临时目录  %u-->用于解决冲突的唯一编码的值
                Handler handler = new FileHandler("%h/myapp.log",0, LOG_ROTATION_COUNT);
                Logger.getLogger("").addHandler(handler);

            } catch (IOException e) {
                Logger.getLogger("com.homer.log").log(Level.SEVERE, "创建FileHandler失败！", e);
            }
        }

        //构建窗口
        EventQueue.invokeLater(() -> {
            //打开记录窗口
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.homer.log").addHandler(windowHandler);

            //打开图片查看器
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Logger.getLogger("com.homer.log").finest("Showing frame");
            frame.setVisible(true);
        });
    }
}
