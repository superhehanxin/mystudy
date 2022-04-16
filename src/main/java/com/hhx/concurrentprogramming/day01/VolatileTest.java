package com.hhx.concurrentprogramming.day01;

import java.util.HashSet;

/**
 * @author he
 * @date 2022/2/18
 * @description:
 * @packagename: com.hhx.concurrentprogramming.day01
 */

public class VolatileTest {
    private static  int x = 0;
    private static  int y = 0;

    private static volatile int a = 0;
    private static  volatile int b=0;
    public static void main(String[] args) throws InterruptedException {
        HashSet<String> sets = new HashSet<>();
        int i=0;
        while (true) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            /**
             *  x,y:
             */
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;

                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            sets.add("("+x+","+y+")");
            System.out.println(sets.toString());
            if (x == 0 && y ==0) {
                System.out.println(i);
                break;
            }
    }
}
}
