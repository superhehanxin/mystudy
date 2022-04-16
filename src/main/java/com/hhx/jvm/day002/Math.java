package com.hhx.jvm.day002;

/**
 * @author he
 * @date 2021/8/5
 * @description: 测试javap
 * @packagename: com.hhx.jvm.day002
 */

public class Math {
    public int add(){
        int a=5;
        int b=10;
        int c=(a+b)*9;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        int add = math.add();
        System.out.println(add);
    }
}
