package com.homer.log;

import java.util.Random;
import java.util.logging.Logger;

/**
 * 1\通过包装一个代理类，实现方法调用的跟踪
 * 2 我还在启动类加了-verbose参数，可以看到类的加载过程
 */
public class loggingProxyTest {


    public final static Random generator = new Random() {
        @Override
        public int nextInt() {
            int result = super.nextInt();
            Logger.getLogger("loggingProxyTest").warning("代理方法起作用了。。。。。");
            return result;
        }
    };

    public static void main(String[] args) {
        /**
         * 我的理解：包装了一个子类，覆盖其中需要跟踪的方法，实际上是通过super调用了父类，效果完全一样，但这时加入调试语句。
         * 这样只有调用了这个方法，就会有日志打印出来。
         */
        System.out.println(generator.nextInt());
    }

}
