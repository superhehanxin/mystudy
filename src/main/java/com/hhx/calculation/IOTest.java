package com.hhx.calculation;

import java.time.Instant;

/**
 * @author he
 * @date 2021/12/16
 * @description:
 * @packagename: com.hhx.calculation
 */

public class IOTest {
    public static void main(String[] args) {
        int[][] arr = new int[10000][10000];
        int sum=0;
        Instant start = Instant.now();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        //按行读
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                sum+=arr[i][j];
//            }
//        }
        Instant end = Instant.now();
        System.out.println("按行读："+(end.toEpochMilli()-start.toEpochMilli())+"ms");
        //按列读
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                sum+=arr[j][i];
//            }
//        }
        Instant end1 = Instant.now();
        System.out.println("按列读："+(end1.toEpochMilli()-end.toEpochMilli())+"ms");


    }
}
