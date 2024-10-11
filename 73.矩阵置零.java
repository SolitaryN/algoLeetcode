/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    /*
     * @date 20241010
     * 先扫描数组，找到为0的元素，收集行和列号，之后置0
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> lines = new HashSet<>();
        Set<Integer> colomns = new HashSet<>();
        int nr = matrix.length;
        int nc = matrix[0].length;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (matrix[i][j] == 0) {
                    lines.add(i);
                    colomns.add(j);
                }
            }
        }

        for (Integer l : lines)
            Arrays.fill(matrix[l], 0);

        for (Integer c : colomns) {
            for (int i = 0; i < nr; i++) {
                matrix[i][c] = 0;
            }
        }
    }

    /*
     * @date 20241010
     * 或者就地取材，使用左边列收集行是否为0，最上面行收集是否列为0
     * 同时需要标记起标记作用行和列原本是否有0，很麻烦这里就不写了
     */
}
// @lc code=end

