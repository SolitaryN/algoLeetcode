/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    /*
     * @date 20241010
     * 按层变量，while循环，四个类型的方向
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return Collections.emptyList();

        List<Integer> order = new ArrayList<Integer>();
        int nr = matrix.length, nc = matrix[0].length;
        int left = 0, right = nc - 1, top = 0, bottom = nr - 1;

        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++)
                order.add(matrix[top][column]);

            for (int row = top + 1; row <= bottom; row++)
                order.add(matrix[row][right]);

            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--)
                    order.add(matrix[bottom][column]);

                for (int row = bottom; row > top; row--)
                    order.add(matrix[row][left]);
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
// @lc code=end

