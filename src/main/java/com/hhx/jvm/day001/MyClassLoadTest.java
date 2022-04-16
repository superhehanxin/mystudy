package com.hhx.jvm.day001;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @author he
 * @date 2021/8/3
 * @description:
 * @packagename: com.hhx.jvm
 */

public class MyClassLoadTest {
    static class MyClassLoader extends ClassLoader{
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name
                    + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

//        @Override
//        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
//            synchronized (getClassLoadingLock(name)) {
//                // First, check if the class has already been loaded
//                Class<?> c = findLoadedClass(name);
//                if (c == null) {
//                    long t0 = System.nanoTime();
//                    if (!name.startsWith("com.hhx.jvm")){
//                        c=this.getParent().loadClass(name);
//                    }else {
//                        c = findClass(name);
//                    }
//
////                    if (c == null) {
//                        // If still not found, then invoke findClass in order
//                        // to find the class.
//                        long t1 = System.nanoTime();
////                        c = findClass(name);
//
//                        // this is the defining class loader; record the stats
//                        sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
//                        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
//                        sun.misc.PerfCounter.getFindClasses().increment();
////                    }
//                }
//                if (resolve) {
//                    resolveClass(c);
//                }
//                return c;
//            }
//        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        MyClassLoader classLoader = new MyClassLoader("/Library/mystudycode");
//        Class clazz = classLoader.loadClass("com.hhx.jvm.User");
        MyClassLoader classLoader = new MyClassLoader("/Users/mac/IdeaProjects/mystudy/target/classes");
        Class clazz = classLoader.loadClass("com.hhx.jvm.day001.User");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }
}
