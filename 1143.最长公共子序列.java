/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    /*
     * @date 202410102
     * https://www.bilibili.com/video/BV1ey4y1d7oD/?spm_id_from=333.337.search-card.all.click
     * 1、明确状态和选择  2、明确dp定义   3、明确转移方程
     * 这里使用自底向上的动态规划求解，两种状态（字符串长度）、三种选择（最后一个字符相等与否）
     * 
     * @date 20250325
     * 明确状态和选择：
     *      状态是text1和text2的长度
     *      选择是text1和text2的最后一个字符是否相等，相等如何处理，不相等如何处理
     * 分解成子问题：
     *      求text1[0...i]和text2[0...j]的最长公共子序列
     *        和text1[0...i-1]和text2[0...j-1]的最长公共子序列之间的关系
     * 
     * 得到转移方程，求解
     */
   public int longestCommonSubsequence(String text1, String text2) {
        int len_text1 = text1.length(); // 行
        int len_text2 = text2.length(); // 列

        int[][] dp = new int[len_text1 + 1][len_text2 + 1];

        // basecase，这里也可不初始化，int数组内元素会被全部自动初始化为 0
        Arrays.fill(dp[0], 0);
        IntStream.range(0, len_text1 + 1).forEach(i -> dp[i][0] = 0);

        for (int i = 1; i < len_text1 + 1; i++) {
            for (int j = 1; j < len_text2 + 1; j++) {
                // 判断字符串中text1第i个位置字符和text2第j个位置字符是否相等
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    // 可能出现类似于：acba 与 accb 这样的情况，此时选最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
                }
            }
        }

        return dp[len_text1][len_text2];
    }
}
// @lc code=end

