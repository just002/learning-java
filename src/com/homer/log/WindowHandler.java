package com.homer.log;

import javax.swing.*;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * 扩展一个Handler，在一个窗口中输入日志信息。
 */
public class WindowHandler extends StreamHandler {

    //持有一个窗口
    private JFrame frame;

    private final static int FRAME_WIDTH = 600;
    private final static int FRAME_HEIGHT = 400;

    public WindowHandler() {
        //初始化窗口
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);

        //这个用到了局部内部类，setOutputStream()方法的参数是一个匿名内部类，并且直接调用了构造函数的局部变量output
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) {
            }

            @Override
            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        });
    }

    @Override
    public void publish(LogRecord record) {
        if(!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}
