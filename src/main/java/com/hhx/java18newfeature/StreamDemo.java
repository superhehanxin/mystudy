package com.hhx.java18newfeature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author he
 * @date 2022/3/29
 * @description:
 * @packagename: com.hhx.java18newfeature
 */

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User()
                .setName("lucy")
                .setPhone("123")
        );
        users.add(new User()
                .setName("hello")
                .setPhone("890")
        );
        users.add(new User()
                .setName("tom")
                .setPhone("567")
        );
        users.add(new User()
                .setName("tom")
                .setPhone("567")
        );
        List<String> names = users.stream().map(user -> user.getName()).collect(Collectors.toList());
        System.out.println(names.toString());


    }

}
