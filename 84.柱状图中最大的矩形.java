/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] newHeight = new int[heights.length + 2];
        newHeight[0] = 0;
        newHeight[newHeight.length - 1] = 0;
        System.arraycopy(heights, 0, newHeight, 1, heights.length);

        int max = 0;
        stack.push(0);
        for (int i = 1; i < newHeight.length; i++) {
            if(newHeight[stack.peek()] <= newHeight[i]){
                stack.push(i);
            }else{
                while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                    int mid = stack.pop();

                    int w = i - stack.peek() - 1;
                    int h = newHeight[mid];
                    max = Math.max(w * h, max);
                }
                stack.push(i);
            }
        }

        return max;
    }
}
// @lc code=end

