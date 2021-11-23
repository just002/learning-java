package com.homer.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {

    //实际的对象
    private Object target;

    /**
     * 刚开始还以为这样记录不了，但是后来调试发现没问题。
     * 因为这个变量是static是属于类的，而不是对象，因此无论创建多少个对象，这个变量都存在。
     */
    //记录调用次数。
    private static int callCount = 0;

    public TraceHandler(Object target) {
        this.target = target;
    }

    public static int getCallCount() {
        return callCount;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        callCount++;

        System.out.print("对象-->" + target);
        System.out.print("调用了方法-->" + method.getName() + "(");

        //如果参数为空
        if(args == null) {
            System.out.println(")");
            return method.invoke(target);
        }

        for (int i = 0; i < args.length; i++) {
//            if(i == args.length - 1)
//                System.out.print(args[i]);
//            else
//                System.out.print(args[i] + ", ");
            /**
             * 以下为作者的写法，看起来要简洁一些。
             */
            System.out.print(args[i]);
            if(i < args.length - 1) System.out.print(", ");
        }

        System.out.println(")");
        return method.invoke(target, args);
    }
}
