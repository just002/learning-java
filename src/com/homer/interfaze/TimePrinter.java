package com.homer.interfaze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimePrinter  implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("执行监听动作！-->" + new Date());
    }
}
