/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    /*
     * @date 20241010
     * 该题不能直接对整体就行二分查找，可以按行或列依次二分查找
     * 下面使用 Z 字形查找，
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int nr = matrix.length, nc = matrix[0].length;
        int x = 0, y = nc - 1;

        while (x < nr && y >= 0) {
            if (matrix[x][y] == target)
                return true;

            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
// @lc code=end

