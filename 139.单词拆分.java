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
     * 选择 字典中所有的单词
     * 递推公式: dp[i] = ( (substr(i-word_1.length, i) == word_1 && dp[i-wrod_1.length]) || (substr(i-word_2.length, i) == word_2 && dp[i-wrod_2.length]) || ....)
     * 
     * @date 20250308
     * 递推公式：
     *  dp[i] = 是否存在 (dp[i - word[i].length()] && substr(i-word[i].length(), i) == word[i] ) == true
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int dictLen = wordDict.size();
        int len = s.length() + 1;
        boolean[] dp = new boolean[len];

        dp[0] = true; // base case
        // 遍历求解状态
        for (int i = 0; i < len; i++) {

            // 这里有 dictLen 个选择，即字典中单词的数量
            for (int j = 0; j < dictLen; j++) {
                // 违规，设置为false，不过初始化已经全部设置为false了，直接跳过就好
                if ( i - wordDict.get(j).length() < 0)
                    continue;

                int wl = wordDict.get(j).length(); // 某个word的长度
                // 匹配当前字符
                dp[i] = (dp[i] || ( dp[i-wl] && s.substring(i-wl, i).equals(wordDict.get(j)) ));
            }

        }

        return dp[s.length()];
    }
}
// @lc code=end

