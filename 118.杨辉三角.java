/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * 20241005
     * 注意这里直接把杨辉三角全部值向左对齐,同时basecase都为0，这里使用自底向上迭代方式求解
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        int[][] table = new int[numRows + 1][numRows + 1];
        table[1][1] = 1;
        ans.add(Arrays.asList(table[1][1]));

        for (int i = 2; i < table.length; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                table[i][j] = table[i - 1][j] + table[i - 1][j - 1];
                line.add(table[i][j]);
            }
            ans.add(line);
        }
        return ans;
    }
}
// @lc code=end

