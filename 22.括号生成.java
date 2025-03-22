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
     * 使用回溯法解决，回溯法与dfs有所区别，多了剪枝操作。
     * 回溯法只能解决解空间为树的题目，同时需要伴随“剪枝操作”（也即规范限制）。
     * 
     * 可简单理解回溯法为：树结构的 dfs + 剪枝操作
     * dfs 针对的是图，树只是一种特殊的图，dfs的使用范围更广。
     * 
     * @date 20250322
     */
    public List<String> generateParenthesis(int n) {
        backtrack1(0, 0, n, new StringBuilder());
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

    /*
     * @date 20250322
     * 这里使用违规就剪枝的操作，来让逻辑更加清晰
     * 
     * 建议使用下面的版本
     */
    public void backtrack1(int left, int right, int limit, StringBuilder builder) {
        if (left == limit && right == limit) {
            ans.add(builder.toString());
            return;
        }

        // 剪枝操作
        if (right > left)  return;
        if (right > limit || left > limit) return;

        builder.append("(");
        backtrack(left + 1, right, limit, builder);
        builder.deleteCharAt(builder.length() - 1);

        builder.append(")");
        backtrack(left, right + 1, limit, builder);
        builder.deleteCharAt(builder.length() - 1);
    }
}
// @lc code=end

