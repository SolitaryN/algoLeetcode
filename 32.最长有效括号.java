/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /*
     * @date 20250312
     * 可以使用动态规划，但太难理解
     * 这里使用栈配合类似于动规的方式求解
     * 这里为了dp数组可以更加合法所以长度多1
     */
    public int longestValidParentheses1(String s) {
        Stack<Integer> stk = new Stack<>();

        // dp[i] 的定义：记录以 s[i-1] 结尾，即s中第 i 个括号接尾的最长合法括号子串长度
        int[] dp = new int[s.length() + 1]; // 多创建一个方便处理边界空字符状况
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 遇到左括号，记录索引
                stk.push(i);
                // 左括号不可能是合法括号子串的结尾
                dp[i + 1] = 0;
            } else {
                // 遇到右括号
                if (!stk.isEmpty()) {
                    // 配对的左括号对应索引
                    int leftIndex = stk.pop();
                    // 以这个右括号结尾的最长子串长度，这里加上该子串左边邻接合法子串的长度
                    int len = i - leftIndex + 1 + dp[leftIndex];
                    dp[i + 1] = len;
                } else {
                    // 没有配对的左括号
                    dp[i + 1] = 0;
                }
            }
        }

        // 计算最长子串的长度
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /*
     * @date 20250312
     * 这里dp数组更加统一，使用下标来表示字符位置
     * 这里需要注意边界情况的处理，即左边界为0时，不需要再往前寻找合法字符串
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();

        // dp[i] 的定义：记录以 s[i] 结尾的最长合法括号子串长度
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 遇到左括号，记录索引
                stk.push(i);
                // 左括号不可能是合法括号子串的结尾
                dp[i] = 0;
            } else {
                // 遇到右括号
                if (!stk.isEmpty()) {
                    // 配对的左括号对应索引
                    int leftIndex = stk.pop();
                    // 以这个右括号结尾的最长子串长度，这里加上该子串左边邻接合法子串的长度
                    // 需要注意如果左边字符下标为0时，直接加 0 就可，因为前面已经没有字符了
                    int len = leftIndex == 0 ? 
                            i - leftIndex + 1 :  i - leftIndex + 1 + dp[leftIndex - 1];
                    dp[i] = len;
                } else {
                    // 没有配对的左括号，此时前面的合法字符串已经结束
                    dp[i] = 0;
                }
            }
        }

        // 计算最长子串的长度
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// @lc code=end

