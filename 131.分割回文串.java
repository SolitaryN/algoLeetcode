/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    boolean[][] dp;
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> now = new ArrayList<String>();

    /*
     * @date 20241009
     * 动态规划 + 回溯
     * dp 数组只有上三角矩阵有意义，如果 i > j（即子串的起始位置在结束位置之后），这样的子串是无效的，因此 dp[i][j] 在这种情况下没有意义。
     * 首先使用动态规划，求出所有字串是否是回文串，加快判断子串是否回文的速度，再使用回溯求解
     * 
     * @date 20250322
     */
    public List<List<String>> partition1(String s) {
        int len = s.length();
        dp = new boolean[len][len];
        IntStream.range(0,len).forEach(i -> dp[i][i] = true);

        // 画龙点睛的一笔，这里的求解顺序是有技巧、有规律的
        // 求dp的顺序: 01 02 12 03 13 23 04 14 24 34 05 15 25 35 45 ... 类似于杨辉三角
        // 25 的求解依赖于 34， 15 的求解依赖于 24，最下方画出三角
        for (int right = 0; right < len; ++right) {
            for (int left = 0; left < right; ++left)
                dp[left][right] = (s.charAt(left) == s.charAt(right)) 
                    && (dp[left + 1][right - 1] || right - left <= 2 ) ;
        }

        dfs(s, 0);

        return ans;
    }

    public void dfs(String str, int index) {
        int len = str.length();
        if (index == len) {
            ans.add(new ArrayList<String>(now));
            return;
        }

        // 剪枝操作
        if (index >= len) return;

        for (int end = index; end < len; ++end) {
            // 回溯操作，这里选择下一个为回文串的字串
            if (dp[index][end]) {
                now.add(str.substring(index, end + 1));
                dfs(str, end + 1);
                now.remove(now.size() - 1);
            }
        }
    }

    /*
     * @date 20250322
     * 这里只使用回溯，不辅助使用动态规划
     */
    public List<List<String>> partition(String s) {
        dfs2(s, 0);
        return ans;
    }

    public void dfs2(String str, int index) {
        int len = str.length();
        if (index == len) {
            ans.add(new ArrayList<String>(now));
            return;
        }
        // 剪枝操作
        if (index >= len) return;

        for (int end = index; end < len; ++end) {
            // 回溯操作，这里选择下一个为回文串的字串
            if (isPalindrome( str.substring(index, end + 1) ))  {
                now.add(str.substring(index, end + 1));
                dfs2(str, end + 1);
                now.remove(now.size() - 1);
            }
        }
    }

    // 或者不用动态规划，直接求是否是回文串
    boolean isPalindrome(String s) {
        for(int l = 0, r = s.length() -1; l < r; l++, r--) {
            if(s.charAt(l) != s.charAt(r)) return false;
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

