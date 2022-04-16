package com.hhx.concurrentprogramming.day07;

import lombok.extern.slf4j.Slf4j;

/**
 * @author he
 * @date 2022/3/3
 * @description:
 * @packagename: com.hhx.concurrentprogramming.day07
 */
@Slf4j
public class SyncDemo {
    private static int counter = 0;

    public static void increment() {
        counter++;
    }

    public static void decrement() {
        counter--;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                decrement();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //思考： counter=？
        log.info("{}", counter);
    }
}
