/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0; // 左边界
        int maxFreq = 0; // 窗口内最大频度的字符数量
        int res = 0;
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) { // i 表示有边界
            freq[s.charAt(i) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(i) - 'A']);

            if(i - l + 1 - maxFreq > k){ // 当有除了最大频度字符的数量大于可以容许的差错时
                // res = Math.max(res, i - l);
                freq[s.charAt(l) - 'A']--;
                l++; // 左边界右移
            }

            // 每次循环都要刷新最大长度
            // 注意，窗口的大小只会增长或者不变，即 (i - l) 的大小，所以下面这句代码没有问题
            res = Math.max(res, i - l + 1);
        }


        return res;
    }
}
// @lc code=end

