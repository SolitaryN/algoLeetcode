/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /*
     * @date 202410102
     * https://www.bilibili.com/video/BV1ey4y1d7oD/?spm_id_from=333.337.search-card.all.click
     * 1、明确状态和选择  2、明确dp定义   3、明确转移方程
     */
   public int longestCommonSubsequence(String text1, String text2) {
        int len_text1 = text1.length(); // 行
        int len_text2 = text2.length(); // 列

        int[][] dp = new int[len_text1 + 1][len_text2 + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < len_text1 + 1; i++)
            dp[i][0] = 0;

        for (int i = 1; i < len_text1 + 1; i++) {
            for (int j = 1; j < len_text2 + 1; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
                }
            }
        }

        return dp[len_text1][len_text2];
    }
}
// @lc code=end

