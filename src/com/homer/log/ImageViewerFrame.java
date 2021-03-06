package com.homer.log;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageViewerFrame extends JFrame {

    private final static Logger logger = Logger.getLogger("com.homer.log");

    private final static int FRAME_WIDTH = 600;
    private final static int FRAME_HEIGHT = 400;

    private JLabel label;

    public ImageViewerFrame() {
        //logger.entering()、logger.exiting()仅仅只是打印进入和推出函数的日志而已，并无其他含义。实际上调用的都是logp()。
        logger.entering("ImageViewerFrame","<init>");
        //logger.throwing()是打印stack trace信息
        logger.throwing("ImageViewerFrame", "<init>", new Exception("这是一条logger.throwing()测试日志信息"));

        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("exit");
        menu.add(exitItem);
        exitItem.addActionListener(e -> {
            logger.fine("Exiting...");
            System.exit(0);
        });

        label = new JLabel();
        add(label);

        logger.exiting("ImageViewerFrame","<init>");
    }

    private class FileOpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", e);

            //文件选择器
            JFileChooser fileChooser = new JFileChooser();
            //设置默认路径
            fileChooser.setCurrentDirectory(new File("."));

            //FileFilter是一个抽象类，而且有两个方法，因此不能用lambda表达式
            fileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF图片";
                }
            });

            //ImageViewerFrame.this 应该是指内部类FileOpenListener
            int r = fileChooser.showOpenDialog(ImageViewerFrame.this);
            if(r == JFileChooser.APPROVE_OPTION) {
                String imagePath = fileChooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", imagePath);
                label.setIcon(new ImageIcon(imagePath));
            }
            else {
                //与这条语句完全一样 logger.log(Level.FINE, "File open dialog is cancelled.");
                logger.fine("File open dialog is cancelled.");
            }

            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");

        }
    }

}
