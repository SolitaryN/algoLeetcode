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
     * 递推公式: dp[i] = ( (substr(i-word_1.length, i) == word_1 && dp[i-wrod_1.length]) || (substr(i-word_2.length, i) == word_2 && dp[i-wrod_2.length]) || ....)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int dictLen = wordDict.size();
        int len = s.length() + 1;
        boolean[] dp = new boolean[len];

        dp[0] = true;
        for (int i = 0; i < len; i++) {
            
            // 判断往前推一个单词，进行判断
            for (int j = 0; j < dictLen; j++) {
                if ( i - wordDict.get(j).length() < 0) // 违规，为false，初始化全为false
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

