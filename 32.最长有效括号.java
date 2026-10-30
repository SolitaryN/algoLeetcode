/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /**
     * 动态规划解决，dp[i]表示以s[i]结尾的最长有效括号长度
     * 选择：
     * 1. 如果当前字符是'('，则dp[i] = 0
     * 2. 如果当前字符是')'，则根据前一个字符是否为'('以及前一个字符对应的dp值来计算dp[i]
     * 
     * 初始化：dp[0] = 0
     * 状态转移方程：
     * 1. 如果s[i] == '('，则dp[i] = 0
     * 2. 如果s[i] == ')'，则：
     *    - 如果s[i-1] == '('，则dp[i] = (i >= 2 ? dp[i-2] : 0) + 2
     *    - 如果s[i-1] == ')'，则令pre = i - dp[i-1] - 1，如果pre >= 0且s[pre] == '('，则dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre-1] : 0)
     */
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch.equals('(')) {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int pre = i - dp[i - 1] - 1;
                    if (pre >= 0 && s.charAt(pre) == '(') {
                        dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * @date 20261030
     *       这里使用栈，结合哨兵（标记违法起点）的方式解决该问题
     */
    public int longestValidParentheses1(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(')) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}

// @lc code=end
