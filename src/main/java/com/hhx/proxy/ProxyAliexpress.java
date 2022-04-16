package com.hhx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author he
 * @date 2022/3/14
 * @description:
 * @packagename: com.hhx.proxy
 */

public class ProxyAliexpress implements InvocationHandler {
    private AliexpressService aliexpressService;
    public ProxyAliexpress(AliexpressService aliexpressService){
        this.aliexpressService=aliexpressService;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk 增强前");
        Object invoke = method.invoke(aliexpressService, args);
        System.out.println("jdk 增强后");
        return invoke;
    }
}
