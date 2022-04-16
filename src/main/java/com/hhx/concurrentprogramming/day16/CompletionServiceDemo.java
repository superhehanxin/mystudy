package com.hhx.concurrentprogramming.day16;

import java.util.concurrent.*;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Fox
 * 电商询价业务
 */
@Slf4j
public class CompletionServiceDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //创建CompletionService
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        //异步向电商S1询价
        cs.submit(() -> getPriceByS1());
        //异步向电商S2询价
        cs.submit(() -> getPriceByS2());
        //异步向电商S3询价
        cs.submit(() -> getPriceByS3());
        //将询价结果异步保存到数据库
        for (int i = 0; i < 3; i++) {
            //从阻塞队列获取futureTask
            Future<Integer> take = cs.take();
            try {
                Integer r = take.get();
//                executor.execute(() -> save(r));
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        System.out.println("入库");


        executor.shutdown();
    }

    private static void save(Integer r) {
        log.debug("保存询价结果:{}",r);
    }

    private static Integer getPriceByS1() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5000);
        log.debug("电商S1询价信息5000");
//        int i =1/0;
        return 1200;
    }
    private static Integer getPriceByS2() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(8000);
        log.debug("电商S2询价信息8000");
        return 1000;
    }
    private static Integer getPriceByS3()  throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(3000);
        log.debug("电商S3询价信息3000");
        return 800;
    }
}
