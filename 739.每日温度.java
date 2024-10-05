/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /*
     * @date 20240814  20241005
     * 单调栈：单调递减栈用来求右边第一个更大的元素，递增栈则是右边第一个更小的元素
     * 类似于优先级问题，保证栈顶的优先级最高或最低
     * Arrays.fill(ans, 0); 不用这样初始化，java创建数组自动初始化
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && 
                temperatures[stack.peek()] < temperatures[i]) {
                    int index = stack.pop();
                    ans[index] = i - index;
            }
            
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end

