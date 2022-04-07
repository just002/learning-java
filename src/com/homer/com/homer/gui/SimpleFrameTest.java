package com.homer.com.homer.gui;

import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {

    public static void main(String[] args) {

        float f = 1.2f;
        double d = 1.2d;

        EventQueue.invokeLater(() -> {
            SimpleFrame sf = new SimpleFrame(800,600);
            sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sf.setVisible(true);
        });
    }

    static class SimpleFrame extends JFrame {
        private int HEIGHT;
        private int WIDTH;

        SimpleFrame(int HEIGHT, int WIDTH) {
            setSize(HEIGHT, WIDTH);
        }
    }
}
