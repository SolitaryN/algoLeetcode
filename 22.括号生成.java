/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ans = new ArrayList<>();

    /*
     * @Date 20240805 20241009
     * 使用回溯法解决，回溯法与dfs有所区别，多了剪枝操作1。
     * 回溯法只能解决解空间为树的题目，同时需要伴随“剪枝操作”（也即规范限制）。
     * 可简单理解回溯法为：树结构的 dfs + 剪枝操作
     * dfs 主要针对的是图，树也是一种特殊的图。
     */
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return ans;
    }

    public void backtrack(int left, int right, int limit, StringBuilder sb) {
        if (left == limit && right == limit)
            ans.add(sb.toString());

        // 剪枝操作
        if (right > left)  return;

        if (left < limit) {
            sb.append("(");
            backtrack(left + 1, right, limit, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < limit) {
            sb.append(")");
            backtrack(left, right + 1, limit, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

