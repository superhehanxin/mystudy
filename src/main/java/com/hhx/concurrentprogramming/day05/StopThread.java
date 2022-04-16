package com.hhx.concurrentprogramming.day05;

/**
 * @author he
 * @date 2022/2/22
 * @description:
 * @packagename: com.hhx.concurrentprogramming.day05
 */

public class StopThread implements Runnable{
    @Override
    public void run() {
        int count = 0;
        /**
         * interrupt()： 将线程的中断标志位设置为true，不会停止线程
         * isInterrupted(): 判断当前线程的中断标志位是否为true，不会清除中断标志位
         * Thread.interrupted()：判断当前线程的中断标志位是否为true，并清除中断标志位，重置为fasle
         */
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count = " + count++);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //重新设置线程中断状态为true
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("线程停止： stop thread");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }
}
