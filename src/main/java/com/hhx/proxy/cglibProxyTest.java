package com.hhx.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author he
 * @date 2022/3/14
 * @description: cglib动态代理
 * @packagename: com.hhx.proxy
 */

public class cglibProxyTest {
    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(AliexpressServiceImpl.class);
////        enhancer.setSuperclass(WalmartService.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("cglib执行逻辑前");
//                Object invoke = methodProxy.invokeSuper(o, objects);
//                System.out.println("cglib执行逻辑后");
//                return invoke;
//            }
//        });
//        AliexpressService walmartService = (AliexpressService) enhancer.create();
//        walmartService.test();
//        System.out.println(walmartService.getClass());
        ProxyAliexpress proxyAliexpress = new ProxyAliexpress(new AliexpressServiceImpl());
        AliexpressService proxyInstance = (AliexpressService)Proxy.newProxyInstance(AliexpressServiceImpl.class.getClassLoader(), AliexpressServiceImpl.class.getInterfaces(), proxyAliexpress);
//        System.out.println(proxyInstance);
        proxyInstance.test();
        System.out.println("-----");
        System.out.println(proxyInstance.getClass());

        int[] arr=new int[]{10,9,100,20,99,77,2,8};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i+1; j++) {
               if (arr[j]<arr[j-1]){
                   int temp=arr[j];
                   arr[j]=arr[j-1];
                   arr[j-1]=temp;
               }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
