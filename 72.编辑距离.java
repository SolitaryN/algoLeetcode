/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start

import static java.lang.Math.min;

import java.util.stream.IntStream;
class Solution {
    /*
     * @date 20241002
     * 1、明确状态、选择    2、明确dp定义    3、写出转移方程
     * 两种状态（两个字符串的index）、四种选择（啥也不干、插入、删除、替换）
     * 这里采用自底向上解决，dp 代表字符串(0-i)转为(o-j)锁需要的最小操作数
     * 
     * @date 20250325
     * 和https://leetcode.cn/problems/longest-common-subsequence/description/ 很相
     * 似，只是这里的状态转移方程有所不同，这里是四种选择：啥也不干、替换、删除、插入
     * 
     * 教程：https://www.bilibili.com/video/BV1FJ4m1M7RJ/
     */
    public int minDistance(String word1, String word2) {
        int lenW1 = word1.length();
        int lenW2 = word2.length();

        int[][] dp = new int[lenW1 + 1][lenW2 + 1];
        IntStream.range(0, lenW1 + 1).forEach(i -> dp[i][0] = i);
        IntStream.range(0, lenW2 + 1).forEach(i -> dp[0][i] = i);

        // 这里是把 word1 变为 word2, i 是 word1 的 index，j 是 word2 的index
        for (int i = 1; i < lenW1 + 1; i++) {
            for (int j = 1; j < lenW2 + 1; j++) {
                // 判断第i个字符和第j个字符是否相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 啥也不干
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 剩下的三种选择：替换、删除、插入，注意：这里的操作都是针对 word1 的
                    // 在 word1 中插入字符，等价于在 word2 中删除字符
                    dp[i][j] = min( min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1),
                                            dp[i][j - 1] + 1);
                }
            }
        }
        
        return dp[lenW1][lenW2];
    }
}
// @lc code=end

