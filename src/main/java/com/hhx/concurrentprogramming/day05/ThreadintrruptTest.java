package com.hhx.concurrentprogramming.day05;

/**
 * @author he
 * @date 2022/2/22
 * @description:
 * @packagename: com.hhx.concurrentprogramming.day05
 */

public class ThreadintrruptTest {
    static  int i =0;
    public static void main(String[] args) {
        System.out.println("begin");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public  void run() {
                while (true) {
                    i++;
                    System.out.println(i);
                    //Thread.interrupted()  清除中断标志位
                    //Thread.currentThread().isInterrupted() 不会清除中断标志位
                    if (Thread.interrupted()) {
                        System.out.println("=========");
                    }
                    if(i==10000){
                        break;
                    }

                }
            }
        });

        t1.start();
        //不会停止线程t1,只会设置一个中断标志位 flag=true
        t1.interrupt();
    }
}
