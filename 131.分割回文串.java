/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[][] dp;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int len;

    /*
     * @date 20241009
     * 动态规划 + 回溯
     * dp 数组只有上三角矩阵有意义
     * 首先使用动态规划，求出所有字串是否是回文串，加快判断子串是否回文的速度，再使用回溯求解
     */
    public List<List<String>> partition(String s) {
        len = s.length();
        dp = new boolean[len][len];
        for (int i = 0; i < len; ++i)
            dp[i][i] = true;

        // 求dp的顺序: 01 02 12 03 13 23 04 14 24 34 05 15 25 35 45 ... 类似于杨辉三角
        // 25 的求解依赖于 34， 15 的求解依赖于 24，最下方画出三角
        for (int right = 0; right < len; ++right) {
            for (int left = 0; left < right; ++left)
                dp[left][right] = (s.charAt(left) == s.charAt(right)) 
                    && (dp[left + 1][right - 1] || right - left <= 2 ) ;
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String str, int begin) {
        if (begin == len) {
            ret.add(new ArrayList<String>(ans));
            return;
        }

        for (int end = begin; end < len; ++end) {
            if (dp[begin][end]) {
                ans.add(str.substring(begin, end + 1));
                dfs(str, end + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // 或者不用动态规划，直接求是否是回文串
    boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }

    /*  这里数字代表子串在主串当中的左右下标
                01
              02  12
            03  13  23
          04  14  24  34
        05  15  25  35  45
      06  16  26  36  46  56
    07  17  27  37  47  57  67
    .......

     */
}
// @lc code=end

