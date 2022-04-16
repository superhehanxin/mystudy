package com.hhx.jvm.day001;

/**
 * @author he
 * @date 2022/1/14
 * @description:
 * @packagename: com.hhx.jvm.day001
 */

public class LauncherObj {
    static {
        System.out.println("静态代码块执行..开始");
    }
    static {
        System.out.println("静态代码块执行..中");
    }
//    private static String ss=new String();
     static LauncherObj launcherObj=new LauncherObj();

//    {
//        System.out.println("构造代码块");
//    }
    public LauncherObj() {
        System.out.println("构造方法执行...");
    }

    static {
        System.out.println("静态代码块执行..结束");

    }

    public static LauncherObj getLauncherObj() {
        return launcherObj;
    }
    public static void getVoidLauncherObj(){
        System.out.println("void");
    }
}
