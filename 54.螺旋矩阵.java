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
        int nr = matrix.length, nc = matrix[0].length;
        int cLeft = 0, cRight = nc - 1, rTop = 0, rBottom = nr - 1;

        for(;cLeft <= cRight && rTop <= rBottom;
                cLeft++, cRight--, rTop++, rBottom-- ) {
            for (int column = cLeft; column <= cRight; column++)
                ans.add(matrix[rTop][column]);

            for (int row = rTop + 1; row <= rBottom; row++)
                ans.add(matrix[row][cRight]);

            if (cLeft < cRight && rTop < rBottom) {
                for (int column = cRight - 1; column > cLeft; column--)
                    ans.add(matrix[rBottom][column]);

                for (int row = rBottom; row > rTop; row--)
                    ans.add(matrix[row][cLeft]);
            }
        }

        return ans;
    }
}
// @lc code=end

