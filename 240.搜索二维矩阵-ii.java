/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    /*
     * @date 20241010
     * 不能直接对整体直接二分查找，可以按行或列依次二分查找，时间复杂度为 O(mlogn)
     * 可以使用 Z 字形查找，时间复杂度为 O(m+n)
     * 
     * @date 20250307
     * 如果从左上角开始的话，无论向右还是向下走，元素大小都会增加，那么向右还是向下走就不确定
     * 而是从右上角开始，就可以做到根据目标值大小能确定是向左或向下搜索。
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

