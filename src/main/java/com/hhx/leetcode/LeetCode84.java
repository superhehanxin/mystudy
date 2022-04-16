package com.hhx.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author he
 * @date 2022/2/21
 * @description: 柱状最大面积
 *给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *  * 输入：heights = [2,1,5,6,2,3]
 *  * 输出：10
 *  * 解释：最大的矩形为图中红色区域，面积为 10
 *  * 输入： heights = [2,4]
 *  * 输出： 4
 * @packagename: com.hhx.leetcode
 */

public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        int answer=0;
        if (heights.length == 0){
            return answer;
        }
        if (heights.length == 1){
            answer=heights[0];
        }
        //暴力求解
//        for (int i = 0; i < heights.length; i++) {
//            int minHeight=Integer.MAX_VALUE;
//            for (int j = i; j < heights.length; j++) {
//                minHeight=Math.min(minHeight,heights[j]);
//                answer=Math.max(answer,minHeight*(j-i+1));
//            }
//        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            //栈没数据就push
            //有数据的情况下：1.当前数据比栈顶的数据小，栈顶出栈并计算栈顶数据的高度的最大面积，
            // 2.当前数据再与栈顶元素比较
            // 3.直到当前数据比栈顶的数据大或者等于的时候，push进去
//            while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
//                int height = heights[stack.peek()];
//                answer=Math.max(answer,height*(i-stack.pop()));
//            }
//
//            while (!stack.isEmpty()&&heights[stack.peek()]<=heights[i]&&i == heights.length-1){
//                int height = heights[stack.peek()];
//                answer=Math.max(answer,height*(i-stack.pop()+1));
//            }
//            if ((stack.isEmpty() || heights[stack.peek()]<=heights[i])&&(i != heights.length-1)){
//                stack.push(i);
//            }

        }
        return answer;
    }

    public static void main(String[] args) {
//        int[] heights={2,1,5,6,2,3};
//        int[] heights={20,20,20};
        int[] heights={0,9};
//        int[] heights={2,1,2};
        System.out.println(new LeetCode84().largestRectangleArea(heights));
    }
}
