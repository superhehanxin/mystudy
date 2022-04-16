package com.hhx.concurrentprogramming.day006;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author he
 * @date 2021/11/8
 * @description:
 * @packagename: com.hhx.concurrentprogramming.day006
 */

public class CASTest {
    public static  int sum=0;
    private static Object obj=new Object();
    private static ReentrantLock lock=new ReentrantLock();
    private static  AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {

                for (int j = 0; j < 1000000; j++) {
                    atomicInteger.incrementAndGet();
                    }
//                synchronized (obj) {
//                try {
//                    lock.lock();
//                    for (int j = 0; j < 1000000; j++) {
//                        sum++;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }

               // }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(sum);
        System.out.println(atomicInteger.get());
    }
}
