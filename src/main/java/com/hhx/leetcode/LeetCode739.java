package com.hhx.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author he
 * @date 2022/2/20
 * @description: 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * @packagename: com.hhx.leetcode
 */

public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] answer =new int[temperatures.length];
//        LinkedList<Integer> temperaturesIndex = new LinkedList<>();
//        for (int i = 0; i < temperatures.length; i++) {
//            while (!temperaturesIndex.isEmpty() && temperatures[i]>temperatures[temperaturesIndex.peek()]){
//                Integer index = temperaturesIndex.poll();
//                answer[index]=i-index;
//            }
//                temperaturesIndex.push(i);
//
//        }

        for (int i = temperatures.length -2; i >= 0; i--) {
            //为了比较过的不在比较，而直接从该索引的answer获取值
            for (int j = i+1; j < temperatures.length; j=j+answer[j]) {
                if (temperatures[j]<=temperatures[i]){
                    if (answer[j] == 0){
                        answer[i]=0;
                        break;
                    }
                }else {
                    answer[i]=j-i;
                    break;
                }

            }
        }
        return answer;

    }

    public static void main(String[] args) {
//       int[] temperatures = {73,74,75,71,69,72,76,73};
//       int[] temperatures = {30,40,50,60};
       int[] temperatures = {30,60,90};
        int[] ints = new LeetCode739().dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }

}
