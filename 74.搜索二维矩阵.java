/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {

    /*
     * @date 20241005
     * 二分查找，两种查法，一次二分查找 和 两次二分查找
     * 下面是两次二分查找
     * 
     * @date 20250321
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length, column = matrix[0].length;
        // 先查第一列
        int begin = 0, end = row - 1;
        while (end >= begin) {
            int mid = begin + (end - begin) / 2;

            if(matrix[mid][0] == target)
                return true;

            if (matrix[mid][0] > target)
                end = mid - 1;
            else 
                begin = mid + 1;
        }

        if (end < 0) return false; // 如果要查的行不存在，则返回，此时 end 为 -1

        // 此时end为要查找的行，这里在写算法的时候代入例子，推算即可得到end为查找行
        int left = 0, right = column - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (matrix[end][mid] == target)
                return true;

            if (matrix[end][mid] > target)
                right = mid - 1;
            else 
                left = mid + 1;
        }

        return false;
    }

    /*
     * @date 20241005 
     * 一次二分查找
     * 
     * @date 20250321
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, column = matrix[0].length;
        int low = 0, high = row * column - 1;

        while (high >= low) {
            int mid = low + (high - low) / 2;

            if (matrix[mid/column][mid%column] == target)
                return true;

            if (matrix[mid/column][mid%column] < target)
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return false;
    }
}
// @lc code=end

