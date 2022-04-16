package com.hhx.proxy;

/**
 * @author he
 * @date 2022/3/14
 * @description:
 * @packagename: com.hhx.proxy
 */

public class AliexpressServiceImpl implements AliexpressService{

    @Override
    public String test() {
        System.out.println("速卖通相关执行逻辑");
        return "test";
    }
}
