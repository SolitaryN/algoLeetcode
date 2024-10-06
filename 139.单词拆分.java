/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start

import java.util.List;

class Solution {
    /*
     * @date 20241006
     * dp[i] 代表是否到字符下标i，可以被dict里面的单词拼接
     * 递推公式: dp[i] = ( (substr(i-word_1.length, i) && dp[i-wrod_1.length]) || (substr(i-word_2.length, i) && dp[i-wrod_2.length]) || ....)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int dictLen = wordDict.size();
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            
            // 判断往前推一个单词，进行判断
            for (int j = 0; j < dictLen; j++) {
                if ( i - wordDict.get(j).length() < 0)
                    continue;

                int wl = wordDict.get(j).length(); // 某个word的长度
                // 匹配当前字符
                dp[i] = (dp[i] || (dp[i-wl] && s.substring(i-wl, i).equals(wordDict.get(j))));
            }

        }

        return dp[s.length()];
    }
}
// @lc code=end

