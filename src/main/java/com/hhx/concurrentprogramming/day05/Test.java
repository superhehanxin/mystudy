package com.hhx.concurrentprogramming.day05;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author he
 * @date 2022/1/1
 * @description:
 * @packagename: com.hhx.concurrentprogramming.day05
 */

public class Test {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        B a = new B("tom",2);
        HashMap<String, String> map = new HashMap<>();
        map.put("a","c");
        map.put("b","c");
        map.put("c","c");
        map.put("d","c");

        JSONObject jsonObject = new JSONObject();
//        JSONObject jsonObject2 = new JSONObject();
//        jsonObject2.put("c",a);
        jsonObject.put("a",a);
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.toString());
//        System.out.println(jsonObject2.toJSONString());
//        System.out.println(jsonObject2.toString());
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("a","tom");
        jsonObject1.put("b",null);
        System.out.println(jsonObject1.toJSONString());
        System.out.println(jsonObject1.toString());

        //json合并 相同的字段会被后一个覆盖
        JSONObject oldjson1=new JSONObject();

        String json = "{'name':'zhang san'}";
        JSONObject jsonObject7 = JSONObject.parseObject(json);
        oldjson1.put("person",jsonObject7);
        System.out.println(oldjson1.toJSONString());
        System.out.println(oldjson1.toString());

    }
    static class A implements Serializable{
        private static final long serialVersionUID = 1L;
        String name;
        Integer age;

        public A(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
