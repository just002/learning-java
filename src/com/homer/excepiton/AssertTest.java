package com.homer.excepiton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssertTest {

    public static void main(String[] args) {

        /**
         * 测试断言功能
         * 断言默认应该是关闭，需要在IDE的VM options中加入-ea参数开启，否则相关代码会被忽略。
         */
        String test = "100f";
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(test);
        assert m.matches();

        Integer.valueOf(test);
    }
}
