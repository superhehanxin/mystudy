package com.hhx.concurrentprogramming.test;

import java.util.ArrayList;

/**
 * @author he
 * @date 2022/3/9
 * @description:
 * @packagename: com.hhx.concurrentprogramming.test
 */

public class TestList {
    public static void main(String[] args) {
        /*ArrayList<Integer> integers = new ArrayList<>();

        integers.remove(1);*/

        new AbstactDemo(){

            @Override
            void peocess() {
                System.out.println("process");
            }
        };
    }
}
