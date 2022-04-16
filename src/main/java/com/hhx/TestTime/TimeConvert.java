package com.hhx.TestTime;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author he
 * @date 2022/2/18
 * @description: 时间转换
 * @packagename: com.hhx.TestTime
 */

public class TimeConvert {
    public static void main(String[] args) throws IOException {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(now);
        FileInputStream fileInputStream = new FileInputStream("");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        int len;
        while ((len=bufferedInputStream.read(bytes))!=-1){

        }



    }
}
