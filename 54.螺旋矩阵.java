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
     * 
     * @date 20250307
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return Collections.emptyList();

        List<Integer> ans = new ArrayList<Integer>();
        int lines = matrix.length, columes = matrix[0].length;
        int columeLeft = 0, columeRight = columes - 1;
        int rowTop = 0, RowBottom = lines - 1;

        for(;columeLeft <= columeRight && rowTop <= RowBottom;
                columeLeft++, columeRight--, rowTop++, RowBottom-- ) {
            for (int column = columeLeft; column <= columeRight; column++)
                ans.add(matrix[rowTop][column]);

            for (int row = rowTop + 1; row <= RowBottom; row++)
                ans.add(matrix[row][columeRight]);

            if (columeLeft < columeRight && rowTop < RowBottom) {
                for (int column = columeRight - 1; column > columeLeft; column--)
                    ans.add(matrix[RowBottom][column]);

                for (int row = RowBottom; row > rowTop; row--)
                    ans.add(matrix[row][columeLeft]);
            }
        }

        return ans;
    }
}
// @lc code=end

