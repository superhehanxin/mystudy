package com.hhx.jvm.day003;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author he
 * @date 2021/8/31
 * @description:
 * @packagename: com.hhx.jvm.day003
 */

public class GcTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6;
        allocation1 = new byte[100000*1024];


//        allocation2 = new byte[8000*1024];
/*      allocation3 = new byte[1000*1024];
     allocation4 = new byte[1000*1024];
     allocation5 = new byte[1000*1024];
     allocation6 = new byte[1000*1024];*/

    }

}
