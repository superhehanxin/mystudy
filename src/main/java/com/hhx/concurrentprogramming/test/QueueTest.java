package com.hhx.concurrentprogramming.test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author he
 * @date 2021/12/29
 * @description:
 * @packagename: com.hhx.concurrentprogramming.test
 */

public class QueueTest {
    public static void main(String[] args) {
        LinkedBlockingDeque<Object> objects = new LinkedBlockingDeque<>(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    System.out.println("入队");
                    executor.getQueue().put(r);
                    System.out.println("入队成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            threadPoolExecutor.execute(()->{
                try {
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ssss");
            });
        }
//        threadPoolExecutor.execute(()->{
//            try {
//                Thread.sleep(9000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("ssss");
//        });
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("sss");
//            }
//        }.start();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        threadPoolExecutor.execute(()->{
//            try {
//                System.out.println("开始唤醒...");
//                objects.put(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

//        try {
//            objects.put(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            objects.put(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("1");
//        }
        System.out.println("2");

    }
}
