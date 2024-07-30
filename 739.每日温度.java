/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);

        // 类似于优先级问题，保证栈顶的优先级最高或最低
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() 
                && temperatures[stack.peek()] < temperatures[i] ){

                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

    // 单调栈问题：单调递减栈用来求右边第一个更大的元素，递增栈则是右边第一个更小的元素
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, 0);

        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() 
                && temperatures[i] > temperatures[stack.peek()]){
                    ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return ans;
    }
}
// @lc code=end

