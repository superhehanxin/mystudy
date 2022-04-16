package com.hhx.concurrentprogramming.day01;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author he
 * @date 2021/11/22
 * @description:
 * @packagename: com.hhx.concurrentprogramming.day01
 */

public class VisibilityTest {
    private boolean flag = true;
    private static ReentrantReadWriteLock reentrantReadWriteLock= new ReentrantReadWriteLock();

    public void refresh() {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改flag");
    }

    public void load() {
        System.out.println(Thread.currentThread().getName() + "开始执行.....");
        int i = 0;
        while (flag) {
//            System.out.println("ssssssssss");
            reentrantReadWriteLock.writeLock().lock();
            try {
                i++;
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
            //TODO  业务逻辑

        }
        System.out.println(Thread.currentThread().getName() + "跳出循环: i=" + i);
    }

    public static void main(String[] args) {
        VisibilityTest visibilityTest = new VisibilityTest();
        new Thread(() -> {
            visibilityTest.load();
        },"线程 1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            visibilityTest.refresh();
        },"线程 2").start();
    }
}
