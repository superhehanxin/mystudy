package com.hhx.testjavacomputer;

/**
 * @author he
 * @date 2022/2/19
 * @description:
 * @packagename: com.hhx.testjavacomputer
 */

public class JavaBinary {
    public static void main(String[] args) {
        int a = -733183670;
        int b=a << 8;
        System.out.println(b);
        int c = 733183670;
        int d =c << 8;
        System.out.println(d);
        int e =43;
        int f=-43;
        String eString = Integer.toBinaryString(e);
        String fString = Integer.toBinaryString(f);
        System.out.println("43二进制 ："+eString);
        System.out.println("-43二进制 ："+fString);
        int g=f<<24;
        System.out.println(Integer.toBinaryString(g));
        System.out.println(g);
        int h = -733183670;
        int i=h<<8;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(h));

        int j=h<<9;
        System.out.println(j);
        System.out.println(Integer.toBinaryString(j));

    }
}
