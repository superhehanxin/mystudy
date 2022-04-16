package com.hhx.jvm.day001;

/**
 * @author he
 * @date 2022/1/25
 * @description:
 * @packagename: com.hhx.jvm.day001
 */

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
//        order=null;
        a(order);
        System.out.println(order.getId());
        System.out.println(order == null);
    }
    public static void a(Order order){
//        order=null;
        order.setId(1);
        System.out.println(order == null);
        System.out.println(order.getId());

    }
}
