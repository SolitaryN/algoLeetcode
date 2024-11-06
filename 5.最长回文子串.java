/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    /*
     * @date 20241001
     * 注意回文字符串是单中心还是双中心
     * 这里使用双指针的解法
     */
    public String longestPalindrome1(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {
        int len = s.length();
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            --l; ++r;
        }
        return s.substring(l + 1, r);
    }

    /*
     * @@date 20241001
     * 使用动态规划求解，两种状态（左右边界）
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        // 先推 0到n, 之后 0到 n+1 会依赖 0 到 n 的计算结果
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) &&
                    (r == l + 1 || r == l + 2 || dp[l + 1][r - 1])) {
                    // 这里 r == l + 1 和 r == l + 2 是特殊判断，判断是否是特殊情况，或者说是basecase
                    // 类似于：aa 和 aba 这种，这种属于特殊情况，属于边界情况，特殊考虑，此时不能看 dp[l + 1][r - 1]
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
// @lc code=end

