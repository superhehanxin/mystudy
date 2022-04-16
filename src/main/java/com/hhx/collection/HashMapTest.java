package com.hhx.collection;

import java.util.HashMap;

/**
 * @author he
 * @date 2021/12/16
 * @description:
 * @packagename: com.hhx.collection
 */

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 13; i++) {
            map.put(String.valueOf(i),String.valueOf(i));
        }
    }
}
