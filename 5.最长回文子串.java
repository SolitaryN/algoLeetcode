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
     * 
     * @date 20250325
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        int len = s.length();
        int maxL = 0;    //最长回文串的起点
        int maxR = 0;    //最长回文串的终点
        int maxLen = 0;  //最长回文串的长度

        // 注意递推策略，先推 0~n, 后 0~n+1，因为后面的需要依赖 0~n 的计算结果
        boolean[][] dp = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) &&
                    (r == l + 1 || r == l + 2 || dp[l + 1][r - 1])) {
                    // r==l + 1 和 r==l + 2 判断是否是 basecase，类似于：aa 和 aba
                    // 属于边界情况，此时不看 dp[l + 1][r - 1]
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxL = l;
                        maxR = r;
                    }
                }

            }

        }
        return s.substring(maxL, maxR + 1);
    }
}
// @lc code=end

