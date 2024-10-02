/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * @Date 20240805
     * 使用回溯法 backtracking 解决，回溯法与dfs有所区别。
     * 回溯法只能解决解空间为树的题目，同时需要伴随“剪枝操作”（也即规范限制）。
     * 可简单理解回溯法为：树结构的 dfs + 剪枝操作
     * dfs 主要针对的是图，树也是一种特殊的图。
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        StringBuilder status = new StringBuilder();
        backtrack(ans, 0, 0, n, status);

        return ans;
    }

    public void backtrack(List<String> ans, int left, int right, int limit, StringBuilder sb) {
        if (left == limit && right == limit) {
            ans.add(sb.toString());
        }

        if (left < limit && left >= right) {
            sb.append("(");
            backtrack(ans, left + 1, right, limit, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < limit && left > right) {
            sb.append(")");
            backtrack(ans, left, right + 1, limit, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis4(int n) {
        if(n == 0){
            return new ArrayList<String>();
        }

        List<String> ans = new ArrayList<>();

        helper_DFS(ans, "", 0, 0, n);
        
        return ans;
    }

    void helper_DFS(List<String> ans, String s, int l, int r, int all){
        // assert r >= l; // 右括号数量大于等于左括号数量
        if(l == all && r == all){
            ans.add(s);
            return;
        }
        if(r > l){ // 剪枝操作
            return;
        }

        if(all > l){
            helper_DFS(ans, s +"(", l + 1, r, all);
        }
        if(all > r){
            helper_DFS(ans, s + ")", l, r + 1, all);
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<List<String>> total = new ArrayList<>();
        if(n == 0){
            return new ArrayList<>();
        }

        total.add(new ArrayList<String>());
        total.get(0).add("");
        total.add(new ArrayList<String>());
        total.get(1).add("()");

        for (int i = 2; i <= n; i++) { // 有 i 个括号的字符串
            List<String> temp_ans = new ArrayList<>(); 

            for (int j = 0; j < i; j++) {
                List<String> now1 = total.get(j); // 有 j 个括号的情况
                List<String> now2 = total.get(i - j - 1); // 有 i - j -1 个括号的情况

                for (String string1 : now1) {
                    for (String string2 : now2) {
                        String temp = "(" + string1 + ")" + string2;
                        temp_ans.add(temp);
                    }
                }
            }

            total.add(temp_ans);
        }

        return total.get(n);
    }
    

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();

        if(n == 0){
            return ans;
        }
        
        dfs_helper(ans, 0, 0, "", n);
        return ans;
    }

    public void dfs_helper(List<String> ans, Integer left, Integer right, String sb, int n){
        if(left == n && right == n){ // 出递归条件
            ans.add(sb.toString());
            return;
        }
        if(left < right){ // 剪枝操作
            return;
        }
        if(left < n){
            dfs_helper(ans, left + 1, right, sb + "(", n);
        }
        if(right < n){
            dfs_helper(ans, left, right + 1, sb + ")", n);
        }
    }
}
// @lc code=end

