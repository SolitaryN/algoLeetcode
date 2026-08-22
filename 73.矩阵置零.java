/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {
    /*
     * @date 20241010
     * 先扫描数组，找到为0的元素，收集行和列号，之后置0
     * 
     * @date 20250307
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> lines = new HashSet<>();
        Set<Integer> colomns = new HashSet<>();
        int nr = matrix.length; // 行数
        int nc = matrix[0].length; // 列数

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
            IntStream.range(0, nr).forEach(r -> matrix[r][c] = 0);
        }

        // for (Integer c : colomns) {
            // for (int i = 0; i < nr; i++) {
            //     matrix[i][c] = 0;
            // }
        //     IntStream.range(0, nr).forEach(r -> matrix[r][c] = 0);
        // }
    }

    /*
     * @date 20241010
     * 或者就地取材，使用左边列收集行是否为0，最上面行收集是否列为0
     * 同时需要两个标记变量标记行和标记列原本是否有0
     * 
     * 链接：https://leetcode.cn/problems/set-matrix-zeroes/solutions/669901/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
     */

    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

}
// @lc code=end

