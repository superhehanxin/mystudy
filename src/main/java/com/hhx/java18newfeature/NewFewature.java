package com.hhx.java18newfeature;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @author he
 * @date 2022/2/19
 * @description: java1.8新特性
 * @packagename: com.hhx.java18newfeature
 */

public class NewFewature {
    public static void main(String[] args) {

        /**
         * orElse(T other)，orElseGet(Supplier other)和orElseThrow(Supplier exceptionSupplier)
         * 这三个函数放一组进行记忆，都是在构造函数传入的value值为null时，进行调用的。orElse和orElseGet的用法如下所示，相当于value值为null时，给予一个默认值:
         * 这两个函数的区别：当user值不为null时，orElse函数依然会执行createUser()方法，而orElseGet函数并不会执行createUser()方法
         */


        User user = new User();
        user.setName("hemama");
//        User user1 = Optional.ofNullable(user).orElse(createUser());
//        System.out.println(user1.toString());
        user = Optional.ofNullable(user).orElseGet(() -> createUser());
        System.out.println(user.toString());
        /**
         * map(Function mapper)和flatMap(Function> mapper)
         * 这两个函数放在一组记忆，这两个函数做的是转换值的操作。
         */
        String name = Optional.ofNullable(user).map(u -> u.getName()).orElseGet(()->get());
        System.out.println(name);
        /**
         * 对于flatMap而言:
         * 如果User结构是下面这样的
         * public class User {
         *     private String name;
         *     public Optional<String> getName() {
         *         return Optional.ofNullable(name);
         *     }
         * }
         * 这时候取name的写法如下所示
         * String city = Optional.ofNullable(user).flatMap(u-> u.getName()).get();
         */

        /**
         * 4、isPresent()和ifPresent(Consumer<? super T> consumer)
         * 这两个函数放在一起记忆，isPresent即判断value值是否为空，而ifPresent就是在value值不为空时，做一些操作。这两个函数的源码如下
         * public final class Optional<T> {
         *     //省略....
         *     public boolean isPresent() {
         *         return value != null;
         *     }
         *     //省略...
         *     public void ifPresent(Consumer<? super T> consumer) {
         *         if (value != null)
         *             consumer.accept(value);
         *     }
         * }
         * 需要额外说明的是，大家千万不要把
         * if (user != null){
         *    // TODO: do something
         * }
         * 给写成
         * User user = Optional.ofNullable(user);
         * if (Optional.isPresent()){
         *    // TODO: do something
         * }
         * 因为这样写，代码结构依然丑陋。博主会在后面给出正确写法
         * 至于ifPresent(Consumer<? super T> consumer)，用法也很简单，如下所示
         * Optional.ofNullable(user).ifPresent(u->{
         *     // TODO: do something
         * });
         */

        /**
         * 5、filter(Predicate<? super T> predicate)
         * 不多说，直接上源码
         *
         * public final class Optional<T> {
         *     //省略....
         *    Objects.requireNonNull(predicate);
         *         if (!isPresent())
         *             return this;
         *         else
         *             return predicate.test(value) ? this : empty();
         * }
         * filter 方法接受一个 Predicate 来对 Optional 中包含的值进行过滤，如果包含的值满足条件，那么还是返回这个 Optional；否则返回 Optional.empty。
         * Optional<User> user1 = Optional.ofNullable(user).filter(u -> u.getName().length()<6);
         * 如上所示，如果user的name的长度是小于6的，则返回。如果是大于6的，则返回一个EMPTY对象。
         */

        /**
         * 以前写法
         * public String getCity(User user)  throws Exception{
         *         if(user!=null){
         *             if(user.getAddress()!=null){
         *                 Address address = user.getAddress();
         *                 if(address.getCity()!=null){
         *                     return address.getCity();
         *                 }
         *             }
         *         }
         *         throw new Excpetion("取值错误");
         *     }
         */
        //java8
//        String city = Optional.ofNullable(user).map(u -> u.getAddress()).map(a -> a.getCity()).orElseThrow(()->new RuntimeException("取值错误"));
        /**
         * public User getUser(User user) throws Exception{
         *     if(user!=null){
         *         String name = user.getName();
         *         if("zhangsan".equals(name)){
         *             return user;
         *         }
         *     }else{
         *         user = new User();
         *         user.setName("zhangsan");
         *         return user;
         *     }
         * }
         * java8写法
         * public User getUser(User user) {
         *     return Optional.ofNullable(user)
         *                    .filter(u->"zhangsan".equals(u.getName()))
         *                    .orElseGet(()-> {
         *                         User user1 = new User();
         *                         user1.setName("zhangsan");
         *                         return user1;
         *                    });
         * }
         */



    }

    private static String get() {
        return "sss";
    }

    public static User createUser(){
        User user = new User();
        System.out.println("执行了");
        user.setName("hema666");
        return user;
    }
}
