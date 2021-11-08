package com.homer.ClassAndObject;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarPrinter {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        GregorianCalendar gd = new GregorianCalendar();//临时使用的日期对象
        gd.set(Calendar.DAY_OF_MONTH,1); //首先都要先定位到当月的第一天
        //我的写法：第一天是星期几，跟中文历法有差异（我没有考虑这个差异）
        //int indent = gd.get(Calendar.DAY_OF_WEEK);//用于计算第一行的偏移量

        //作者的写法
        /**
         * 与作者的程序相比，偏移量的计算有较大的差异。
         * 作者的写法引入了GregorianCalendar.getFirstDayOfWeek()，通过获得当月第一天和星期，再往前循环dayOfMouth-1，直到当前的星期数==firstDayOfWeek（英美是sunday-1）
         * 我的写法：直接获取当前是星期数，没有考虑不同历法。虽然也能实现，但是适应性更差
         */
        int firstDayOfWeek = gd.getFirstDayOfWeek();
        //int firstDayOfWeek = 4;
        int indent = 0;
        int weekday = gd.get(Calendar.DAY_OF_WEEK);//6对应friday
        while(firstDayOfWeek != weekday) {
            indent++;
            gd.add(Calendar.DAY_OF_MONTH, -1);
            weekday = gd.get(Calendar.DAY_OF_WEEK);
        }

//        System.out.println("firstDay-->" + firstDayOfWeek);
//        System.out.println("Calendar.SUNDAY-->" + Calendar.SUNDAY);
//        System.out.println("Calendar.SATURDAY-->" + Calendar.SATURDAY);
//        gd.set(Calendar.DAY_OF_MONTH, 1);
//        System.out.println("Calendar.DAY_OF_WEEK-->" + gd.get(Calendar.DAY_OF_WEEK));


        String[] weekName = new DateFormatSymbols().getShortWeekdays();


        /**
         * 此处写法又有不同。
         * weekName这个数组0号元素是空的
         */
        //for (int i = 1; i< weekName.length; i++)
        //    System.out.printf("%4s", weekName[i]);

        //难怪没出问题，此处日期又加回来了！但这个写法并不好，没有必要复用gd对象，容易出问题
        do{
            System.out.printf("%4s", weekName[weekday]);
            gd.add(Calendar.DAY_OF_MONTH, 1);
            weekday = gd.get(Calendar.DAY_OF_WEEK);
        }while (firstDayOfWeek != weekday);
        System.out.println();

        for (int i = 1; i <= indent; i++)
            System.out.printf("%4s", " ");

        //计算完偏移量月份已经不对了，在此重新生成一个当前时间的日期对象，这样程序更加清晰
        //书上的程序并没有这步操作，难道运行没有问题？
        //System.out.println("gd.get(Calendar.MONTH)-->" + gd.get(Calendar.MONTH));
        GregorianCalendar now = new GregorianCalendar();
        int month = now.get(Calendar.MONTH);//当前月份
        int today = now.get(Calendar.DAY_OF_MONTH);//当前日期

        now.set(Calendar.DAY_OF_MONTH, 1);
        do{

            if(today == now.get(Calendar.DAY_OF_MONTH)) {
                System.out.printf("%4s", now.get(Calendar.DAY_OF_MONTH) + "*");
            } else {
                System.out.printf("%4d", now.get(Calendar.DAY_OF_MONTH));
            }

            now.add(Calendar.DAY_OF_MONTH,1);

            //如果当天为SATURDAY则打印一个换行
            /**
             * 此处作者又用到了firstDayOfWeek，用于启用了这个参数，三次关键逻辑：计算首行缩进、打印星期头、打印日历，都用到了！如果需要调整每周从哪天开始
             * 只需要调节firstDayOfWeek即可，而不是要修改多处！作者的程序整体性要强的多，这是最根本的差异
             */
            if(now.get(Calendar.DAY_OF_WEEK) == firstDayOfWeek)
                System.out.println();

        }while (month == now.get(Calendar.MONTH));

//        System.out.printf("%4s", "1");
//
//        System.out.println("*****************************");
//        System.out.println(gd.get(Calendar.DAY_OF_MONTH));
//        for(int i = 1; i < 50; i++) {
//            gd.add(Calendar.DAY_OF_MONTH,1);
//            System.out.printf("%4s" , gd.get(Calendar.DAY_OF_MONTH));
//        }



    }
}
