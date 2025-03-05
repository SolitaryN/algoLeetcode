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
     * 
     * @date 20250305
     * 这里使用单调递减栈，从身高的角度来理解就好，这里其余未做处理的，自动都赋值0了
     * 否则需要再去进行初始化操作
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            // 注意这里是while循环
            while (!stack.isEmpty() && 
                temperatures[stack.peek()] < temperatures[i]) {
                    int index = stack.pop();
                    ans[index] = i - index;
            }
            
            stack.push(i);
        }
        return ans;
    }

    /*
     * @date 20250305
     * 单调栈模板，注意是从后往前遍历，这里也是单调递减栈
     * https://labuladong.online/algo/data-structure/monotonic-stack/
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        // 这里放元素索引，而不是元素
        Stack<Integer> s = new Stack<>(); 
        // 单调栈模板
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            // 得到索引间距
            res[i] = s.isEmpty() ? 0 : (s.peek() - i); 
            // 将索引入栈，而不是元素
            s.push(i); 
        }
        return res;
    }
}
// @lc code=end

