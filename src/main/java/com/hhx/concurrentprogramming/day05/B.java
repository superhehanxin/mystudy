package com.hhx.concurrentprogramming.day05;

import java.io.Serializable;

/**
 * @author he
 * @date 2022/1/4
 * @description:
 * @packagename: com.hhx.concurrentprogramming.day05
 */

public class B implements Serializable {

   private String name;
   private Integer age;

    public B(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
